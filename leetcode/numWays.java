package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class numWays {
    public int numWays(int n, int[][] relation, int k) {
        return back(n, relation, k, 0);
    }

    public int back(int n, int[][] relation, int k, int start) {
        int count = 0;
        if (k == 0) {
            return start == n - 1 ? 1 : 0;
        }
        for (int i = 0; i < relation.length; i++) {
            if (relation[i][0] == start) {//找到开始
                count += back(n, relation, k - 1, relation[i][1]);
            }
        }
        return count;
    }

    public int numWaysdp(int n, int[][] relation, int k) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < k; i++) {
            int[] next = new int[n];
            for (int[] edge : relation) {
                int src = edge[0], dst = edge[1];
                next[dst] += dp[src];
            }
            dp = next;
        }
        return dp[n - 1];
    }

    public int numWaysbfs(int n, int[][] relation, int k) {
        List<List<Integer>> edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<Integer>());
        }
        for (int[] edge : relation) {
            int src = edge[0], dst = edge[1];
            edges.get(src).add(dst);
        }
        int steps = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        while (!queue.isEmpty() && steps < k) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int index = queue.poll();
                List<Integer> list = edges.get(index);
                for (int nextIndex : list) {
                    queue.offer(nextIndex);
                }
            }
        }
        int ways = 0;
        if (steps == k) {
            while (!queue.isEmpty()) {
                if (queue.poll() == n - 1) {
                    ways++;
                }
            }
        }
        return ways;
    }


    @Test
    public void test() {
        int n = 5;
        int[][] relation = {{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};
        int k = 3;
        System.out.println(numWays(n, relation, k));

    }
}

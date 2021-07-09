package leetcode;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

public class SnakesAndLadders {

    public int SnakesAndLadders(int[][] nums) {
        int n = nums.length;
        int count = 0;
        boolean[] vis = new boolean[n * n + 1];
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{1, 0});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 1; i <= 6; i++) {
                int nxt = p[0] + i;
                if (nxt > n * n) {
                    break;
                }
                int[] rc = id2rc(nxt, n);
                if (nums[rc[0]][rc[1]] > 0) {
                    nxt = nums[rc[0]][rc[1]];
                }
                if (nxt == n * n) {
                    return p[1] + 1;
                }
                if (!vis[nxt]) {
                    vis[nxt] = true;
                    queue.offer(new int[]{nxt, p[1] + 1});
                }
            }
        }
        return n - 1;
    }

    private int[] id2rc(int id, int n) {
        int r = (id - 1) / n, c = (id - 1) % n;
        if (r % 2 == 1) {
            c = n - 1 - c;
        }
        return new int[]{n - 1 - r, c};
    }


    @Test
    public void test() {
        int[][] nums = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };
        int res = SnakesAndLadders(nums);
        System.out.println(res);
    }
}

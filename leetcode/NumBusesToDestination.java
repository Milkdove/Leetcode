package leetcode;

import org.junit.Test;

import java.util.*;

public class NumBusesToDestination {


    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {//起点是终点 返回0
            return 0;
        }
        int n = routes.length;
        boolean[][] edge = new boolean[n][n];//定义一个线路之间的可达矩阵
        Map<Integer, List<Integer>> rec = new HashMap<Integer, List<Integer>>();//存放车站所拥有的公交列表
        for (int i = 0; i < n; i++) {//建图
            for (int site : routes[i]) {//遍历每一条公交路线
                List<Integer> list = rec.getOrDefault(site, new ArrayList<Integer>());//获得该条公交路线的每个站点的公交列表
                for (int j : list) {//设置同一个站点的公交线路的可达矩阵
                    edge[i][j] = edge[j][i] = true;
                }
                list.add(i);//将当前公交线路加入到该站点的公交列表忠
                rec.put(site, list);
            }
        }
        int[] dis = new int[n];
        Arrays.fill(dis, -1);
        Queue<Integer> que = new LinkedList<Integer>();
        for (int bus : rec.getOrDefault(source, new ArrayList<Integer>())) {//获得起点站的公交列表 并遍历每一个线路的所有站点
            dis[bus] = 1;//将对应站点 设置成1
            que.offer(bus);//将起始站能到达的所有站点入栈
        }
        while (!que.isEmpty()) {//
            int x = que.poll();
            for (int y = 0; y < n; y++) {
                if (edge[x][y] && dis[y] == -1) {
                    dis[y] = dis[x] + 1;
                    que.offer(y);
                }
            }
        }

        int ret = Integer.MAX_VALUE;
        for (int bus : rec.getOrDefault(target, new ArrayList<Integer>())) {
            if (dis[bus] != -1) {
                ret = Math.min(ret, dis[bus]);
            }
        }
        return ret == Integer.MAX_VALUE ? -1 : ret;

    }

    @Test
    public void test() {

    }
}

package leetcode;

import org.junit.Test;

/**
 * 63. 不同路径 II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 */
public class UniquePathsWithObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    if (i > 0 && j > 0) {
                        dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                    } else if (i == 0 && j != 0) {
                        dp[i][j] = dp[i][j - 1];
                    } else if (j == 0 && i != 0) {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    @Test
    public void test() {
        int[][] obstacleGrid = {{0, 0}, {0, 1}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}

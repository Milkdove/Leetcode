package leetcode;

import org.junit.Test;

import java.util.Arrays;

public class MaxIceCream {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int res = 0;
        long count = 0;
        for (int i = 0; i < costs.length; i++) {
            count += costs[i];
            if (count <= coins) {
                res += 1;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] costs = {1, 6, 3, 1, 2, 5, 6};
        int coins = 20;
        System.out.println(maxIceCream(costs, coins));
    }
}

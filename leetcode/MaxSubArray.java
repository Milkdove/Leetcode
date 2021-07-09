package leetcode;

import org.junit.Test;

import java.lang.reflect.Array;
import java.sql.DriverAction;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        String s = "123";
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (sum >= 0 && nums[i] < 0) {
                continue;
            }
            for (int j = i; j < nums.length; j++) {
                sum = Math.max(sum, getSum(nums, i, j));
            }
        }
        return sum;
    }

    public int maxSubArray2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    private int getSum(int[] nums, int left, int right) {
        int sum = 0;
        while (left <= right) {
            sum += nums[left];
            left++;
        }
        return sum;
    }


    @Test
    public void test() {
        int[] nums2 = {-1, -2};
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int res = maxSubArray2(nums);
        System.out.println(res);

    }
}

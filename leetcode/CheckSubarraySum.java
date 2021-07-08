package leetcode;

import org.junit.Test;

import java.sql.SQLOutput;

public class CheckSubarraySum {

    /**
     * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
     * 子数组大小 至少为 2 ，且
     * 子数组元素总和为 k 的倍数。
     * 如果存在，返回 true ；否则，返回 false 。
     * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。
     * 输入：nums = [23,2,4,6,7], k = 6
     * 输出：true
     * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int[] temp = new int[i];
            for (int a : temp) {

            }
        }

        return false;
    }

    @Test
    public void test() {
        int[] nums = {23, 2, 4, 6, 7};
        int k = 6;
        Boolean a = checkSubarraySum(nums, k);
        System.out.println(a);
    }
}

package leetcode;

import org.junit.Test;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, sum = 0, minLength = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int sum = 0, minLength = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    minLength = Math.min(minLength, j - i + 1);
                    break;
                }
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    @Test
    public void test() {
        int target = 4;
        int[] nums = {1, 4, 4};
//        int target = 1;
//        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(minSubArrayLen2(target, nums));
    }
}

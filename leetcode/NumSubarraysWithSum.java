package leetcode;

import org.junit.Test;

public class NumSubarraysWithSum {

    public int numSubarraysWithSum(int[] nums, int goal) {
        int left = 0, right = 0, n = nums.length, count = 0;
        while (left < n) {
            right = left;
            int sum = 0;
            while (right < n) {
                sum += nums[right++];
                if (sum == goal) {
                    count++;
                    break;
                }
                if (sum > goal) {
                    break;
                }
            }
            left++;
        }
        return count;
    }

    @Test
    public void test() {
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        System.out.println(numSubarraysWithSum(nums, goal));
    }
}

package leetcode;

import org.junit.Test;

/**
 * 给定一个二进制数组， 计算其中最大连续 1 的个数。
 */
public class FindMaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            count = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 1) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    i = j;
                    break;
                }
            }
        }
        return max;
    }

    @Test
    public void test() {
        int[] nums = {1, 0, 1, 1, 0, 1};
        int res = findMaxConsecutiveOnes(nums);
        System.out.println(res);

    }
}

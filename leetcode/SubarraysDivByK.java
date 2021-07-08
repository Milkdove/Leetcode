package leetcode;

import org.junit.Test;

/**
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 */
public class SubarraysDivByK {

    public int subarraysDivByK(int[] nums, int k) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraysDivByK2(int[] nums, int k) {
        int count = 0;
        int[] subs = new int[nums.length + 1];
        subs[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            subs[i + 1] = subs[i] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if ((subs[j + 1] - subs[i]) % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }


    @Test
    public void test() {
        int[] nums1 = {5};
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        int res = subarraysDivByK2(nums, k);
        System.out.println(res);
    }
}

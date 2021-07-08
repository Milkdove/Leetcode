package leetcode;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
public class Rotate {

    public void rotate(int[] nums, int k) {
        if (nums.length < 2) {
            return;
        }
        int n = nums.length;
        int temp;
        for (int i = 0; i < k; i++) {
            temp = nums[0];
            nums[0] = nums[n - 1];
            for (int j = n - 1; j > 1; j--) {
                nums[j] = nums[j - 1];
            }
            nums[1] = temp;
        }
    }

    public void rotate3(int[] nums, int k) {
        int n = nums.length;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = nums[i];
        }
        System.arraycopy(temp, 0, nums, 0, n);
    }

    public void rotate4(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int left, int right) {
        int temp;
        while (left < right) {
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate3(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}

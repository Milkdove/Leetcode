package leetcode;

import org.junit.Test;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 */
public class Search {

    public int search(int[] nums, int target) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                res++;
            }
            if (nums[i] > target) {
                return res;
            }
        }
        return res;
    }

    public int search2(int[] nums, int target) {
        int res = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] >= target) right = mid;
            else left = mid + 1;
        }
        while (left < nums.length && nums[left] == target) {
            res++;
            left++;
        }
        return res;
    }

    /**
     * 34. 在排序数组中查找元素的第一个和最后一个位置
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + right >> 1;
            if (nums[mid] <= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        right = left;
        while (right < nums.length && nums[right] == target) {
            right++;
        }
        return nums[left] == target ? new int[]{left, right} : new int[]{-1, -1};
    }

    @Test
    public void test() {
        int[] nums = {1, 3};
        int target = 3;
        System.out.println(search2(nums, target));
    }
}

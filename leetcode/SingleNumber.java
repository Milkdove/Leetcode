package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
            i++;
        }
        return nums[nums.length - 1];
    }

    public void quickSort(int[] nums, int left, int right) {
        int i = left, j = right, temp;
        temp = nums[i];
        while (i < j) {
            while (i < j && nums[j] > temp) {
                j--;
            }
            if (i < j) {
                nums[i] = nums[j];
                i++;
            }
            while (i < j && nums[i] < temp) {
                i++;
            }
            if (i < j) {
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = temp;
        if (left < j) quickSort(nums, left, i - 1);
        if (right > i) quickSort(nums, i + 1, right);
    }

    public int singleNumber2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() == 1) {
                return m.getKey();
            }
        }
        return -1;
    }

    public int singleNumber3(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }


    @Test
    public void test() {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber3(nums));
    }
}

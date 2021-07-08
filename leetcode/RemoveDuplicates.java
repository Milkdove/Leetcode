package leetcode;

import org.junit.Test;

import java.util.Arrays;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {//遍历数组
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    @Test
    public void test() {
        int[] a = {1, 1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 8};
        int b = removeDuplicates(a);
        System.out.println(Arrays.toString(a));
    }
}

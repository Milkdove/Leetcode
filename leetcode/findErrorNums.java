package leetcode;

import org.junit.Test;

import java.util.*;

public class findErrorNums {

    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int n = nums.length;
        Set set = new HashSet();
        for (int i = 0; i < n; i++) {
            if (!set.add(nums[i])) {
                res[0] = nums[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (set.add(i + 1)) {
                res[1] = i + 1;
                break;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {3, 3, 1};
        nums = findErrorNums(nums);
        System.out.println(Arrays.toString(nums));
    }
}

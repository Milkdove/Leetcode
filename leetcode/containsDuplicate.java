package leetcode;

import org.junit.Test;

import java.util.HashSet;

public class containsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        HashSet set = new HashSet();
        for (int i = 0; i < n; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {

    }
}

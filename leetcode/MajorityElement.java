package leetcode;

import org.junit.Test;

import java.util.HashMap;

/**
 * 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {//hashmap
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > n / 2) {
                return nums[i];
            }
        }
        return -1;
    }

    public int majorityElement2(int[] nums) {//摩尔投票
        int n = nums.length;
        int count = 0, res = 0;
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                res = nums[i];
                count++;
            } else if (nums[i] == res) {
                count++;
            } else {
                count--;
            }
        }
        if (count == 0) {
            return -1;
        }
        count = 0;
        for (int num : nums) {//二次验证
            if (num == res) {
                count++;
            }
        }
        return count > n / 2 ? res : -1;
    }


    @Test
    public void test() {
        int[] nums = {1, 3, 2, 3, 3};
        System.out.println(majorityElement2(nums));
    }
}

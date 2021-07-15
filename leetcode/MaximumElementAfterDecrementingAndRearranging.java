package leetcode;

import org.junit.Test;

import java.util.Arrays;

public class MaximumElementAfterDecrementingAndRearranging {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int res = 1;
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1] || arr[i] > res) {
                res++;
            }
        }
        return res;
    }

    @Test
    public void test() {

    }
}

package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EqualSubstring {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] res = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            res[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int start = 0, end = 0, count = 0;
        int sum = 0;
        while (end < res.length) {
            sum += res[end];
            while (sum > maxCost) {
                sum -= res[start];
                start++;
            }
            count = Math.max(count, end - start + 1);
            end++;
        }
        return count;
    }

    @Test
    public void test() {
        String s, t;
        int maxCost;
        s = "abc";
        t = "ajxss";
        maxCost = 0;
        System.out.println(equalSubstring(s, t, maxCost));
    }
}

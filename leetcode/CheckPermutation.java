package leetcode;

import org.junit.Test;

import java.util.HashMap;

/**
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 */
public class CheckPermutation {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map.put(c1[i], map.getOrDefault(c1[i], 0) + 1);
            map.put(c2[i], map.getOrDefault(c2[i], 0) - 1);
        }
        for (Integer res : map.values()) {
            if (res != 0) {
                return false;
            }
        }
        return true;
    }


    @Test
    public void test() {
        System.out.println(CheckPermutation("abac", "baca"));
    }
}

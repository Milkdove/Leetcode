package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 * 回文串不一定是字典当中的单词。
 */
public class CanPermutePalindrome {
    public boolean canPermutePalindrome(String s) {
        int flag = 0;
        if (s.length() % 2 == 0) {
            flag = 0;
        } else {
            flag = 1;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Integer res : map.values()) {
            if (res % 2 != 0) {//单数
                if (flag == 1) {//长度为单
                    flag++;
                } else {//长度为双 或者以及出现过单
                    return false;
                }
            }
        }
        return true;
    }

    public boolean canPermutePalindrome2(String s) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.add(s.charAt(i))) {
                set.remove(s.charAt(i));
            }
        }
        return set.size() <= 1;
    }

    @Test
    public void test() {
        System.out.println(canPermutePalindrome("aaaaa"));
    }
}

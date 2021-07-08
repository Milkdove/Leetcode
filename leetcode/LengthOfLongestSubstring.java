package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, maxLength = 0;
        StringBuffer res = new StringBuffer();
        while (right < s.length()) {
            res.append(s.charAt(right));
            while (res.indexOf(s.charAt(right) + "") != res.length() - 1) {
                res.deleteCharAt(0);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring2(String s) {
        char[] chs = s.toCharArray();
        int left = 0, right = 0, maxLength = 0;
        Set<Character> set = new HashSet<>();
        while (right < chs.length) {
            while (!set.add(chs[right])) {//已存在该元素
                set.remove(chs[left]);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }

    @Test
    public void test() {
        String str = "1231";
        int res = lengthOfLongestSubstring2(str);
        System.out.println(res);
    }
}

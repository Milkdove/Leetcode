package leetcode;

import org.junit.Test;

/**
 * 实现 strStr() 函数。
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * 说明：
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 */
public class Strstr {

    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        if (m == 0 && n == 0) {
            return 0;
        }
        for (int i = 0; i < m; i++) {
            int j = 0;
            boolean flag = true;
            while (j < n) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    flag = false;
                    break;
                }
                j++;
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int res = strStr("aaa", "aaaa");
        System.out.println(res);
    }
}

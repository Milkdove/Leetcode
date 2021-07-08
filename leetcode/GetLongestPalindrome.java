package leetcode;

import org.junit.Test;

/**
 * 描述
 * 对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。
 * 给定字符串A以及它的长度n，请返回最长回文子串的长度。
 */
public class GetLongestPalindrome {
    public int getLongestPalindrome(String A, int n) {
        // write code here
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (back(A, i, j)) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    public boolean back(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public int getLongestPalindrome2(String A, int n) {
        // write code here

        int max = 0, left, right;
        for (int i = 0; i < n; i++) {
            left = right = i;
            while (left >= 0 && right < n) {
                if (A.charAt(left) != A.charAt(right)) {
                    break;
                }
                max = Math.max(max, right - left + 1);
                left--;
                right++;
            }
            left = i;
            right = i + 1;
            while (left >= 0 && right < n) {
                if (A.charAt(left) != A.charAt(right)) {
                    break;
                }
                max = Math.max(max, right - left + 1);
                left--;
                right++;
            }
        }
        return max;
    }

    public String longestPalindrome(String s) {
        // write code here
        int n = s.length();
        String res = "";
        int left, right;
        for (int i = 0; i < n; i++) {
            left = right = i;
            while (left >= 0 && right < n) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                if ((right - left + 1) > res.length()) {
                    res = s.substring(left, right);
                }
                left--;
                right++;
            }
            left = i;
            right = i + 1;
            while (left >= 0 && right < n) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                if ((right - left + 1) > res.length()) {
                    res.substring(left, right);
                }
                left--;
                right++;
            }
        }
        return res;
    }

    public String longestPalindrome2(String s) {
        // write code here
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            dp[j][j] = true;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    if (res.length() < j - i + 1 && dp[i][j]) {
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        String str = "abc1234321ab";
        System.out.println(str.substring(1, str.length()));
        System.out.println(getLongestPalindrome2(str, str.length()));
    }
}

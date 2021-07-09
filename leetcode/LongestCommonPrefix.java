package leetcode;

import org.junit.Test;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0) {
            return "";
        }
        String res = "";
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i) {
                    return res;
                }
                if (strs[j].charAt(i) != strs[0].charAt(i)) {
                    return res;
                }
            }
            res += strs[0].charAt(i);
        }
        return res;
    }


    @Test
    public void test() {
        String[] strs = {"falower", "fa", "fliagh"};
        String str = longestCommonPrefix(strs);
        System.out.println(str);
    }
}

package leetcode;

import org.junit.Test;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int n = s.length(), res = 0;
        if (n == 0) {
            return 0;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                res += 1;
            } else {
                break;
            }
        }
        return res;
    }

    @Test
    public void test() {
        String s = "a";
        System.out.println(lengthOfLastWord(s));
    }
}

package leetcode;

import org.junit.Test;

/**
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 */
public class IsUnique {

    public boolean isUnique(String astr) {
        for (int i = astr.length() - 1; i >= 0; i--) {
            if (astr.indexOf(astr.charAt(i)) != i) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(isUnique("1"));
    }
}

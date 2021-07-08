package leetcode;

import org.junit.Test;

/**
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 */
public class TitleToNumber {

    public int titleToNumber(String columnTitle) {
        int res = 0;
        int n = columnTitle.length() - 1;
        for (char ch : columnTitle.toCharArray()) {
            res += (ch - 64) * Math.pow(26, n);
            n--;
        }
        return res;
    }

    @Test
    public void test() {
        int res = titleToNumber("AZ");
        System.out.println(res);
    }
}

package leetcode;

import org.junit.Test;

/**
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 */
public class ConvertToTitle {

    public String convertToTitle(int columnNumber) {
        if (columnNumber <= 26) {
            columnNumber += 64;
            return (char) columnNumber + "";
        } else {
            int a = columnNumber % 26 + 64;
            columnNumber = columnNumber / 26;
            if (a == 64) {
                columnNumber--;
                a = 90;
            }
            return convertToTitle(columnNumber) + (char) a;
        }
    }


    public String convertToTitle2(int columnNumber) {
        StringBuffer stringBuffer = new StringBuffer();
        while (columnNumber > 0) {
            int a = (columnNumber - 1) % 26 + 1;
            stringBuffer.append((char) (a - 1 + 'A'));
            columnNumber = (columnNumber - a) / 26;
        }
        return stringBuffer.reverse().toString();
    }

    @Test
    public void test() {
        String res = convertToTitle2(26);
        System.out.println(res);
    }
}

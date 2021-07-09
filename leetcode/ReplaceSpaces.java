package leetcode;

import org.junit.Test;

/**
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
 * （注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 */
public class ReplaceSpaces {

    public String replaceSpaces(String S, int length) {
        return S.substring(0, length).replaceAll(" ", "%20");
    }

    public String replaceSpaces2(String S, int length) {
        char[] chars = new char[length * 3];
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) != ' ') {
                chars[j] = S.charAt(i);
                j++;
            } else {
                chars[j++] = '%';
                chars[j++] = '2';
                chars[j++] = '0';
            }
        }
        return new String(chars, 0, j);
    }

    public String replaceSpaces3(String S, int length) {
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) != ' ') {
                res.append(S.charAt(i));
            } else {
                res.append("%20");
            }
        }
        return res.toString();
    }

    @Test
    public void test() {
        System.out.println(replaceSpaces3("Mr John Smith    ", 13));
    }
}

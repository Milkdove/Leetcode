package leetcode;

import org.junit.Test;

public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuffer res = new StringBuffer();
        int alen = a.length();
        int blen = b.length();
        int n = alen > blen ? alen : blen, i = 0, carry = 0;
        char cha, chb;
        while (i < n || carry == 1) {
            if (i < alen) {
                cha = a.charAt(alen - i - 1);
            } else {
                cha = '0';
            }
            if (i < blen) {
                chb = b.charAt(blen - i - 1);
            } else {
                chb = '0';
            }
            if (carry == 0) {
                if (cha == chb) {//相同
                    res.append(0);
                    if (cha == '1') {
                        carry++;
                    }
                } else {
                    res.append(1);
                }
            } else {
                carry--;
                if (cha == chb) {//相同
                    res.append(1);
                } else {
                    res.append(0);
                }
                if (cha == '1' || chb == '1') {
                    carry++;
                }
            }
            i++;
        }
        return res.reverse().toString();
    }


    @Test
    public void test() {
        String a = "100", b = "110010";
        System.out.println(addBinary(a, b));
    }
}

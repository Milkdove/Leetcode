package leetcode;

import org.junit.Test;

/**
 * 对于给定的整数 n, 如果n的k（k>=2）进制数的所有数位全为1，则称k（k>=2）是 n 的一个好进制。
 * <p>
 * 以字符串的形式给出 n, 以字符串的形式返回 n 的最小好进制。
 */
public class SmallestGoodBase {

    public String smallestGoodBase(String n) {
        long nVal = Long.parseLong(n);
        int mMax = (int) Math.floor(Math.log(nVal) / Math.log(2));
        for (int m = mMax; m > 1; m--) {
            int k = (int) Math.pow(nVal, 1.0 / m);
            long mul = 1, sum = 1;
            for (int i = 0; i < m; i++) {
                mul *= k;
                sum += mul;
            }
            if (sum == nVal) {
                return Integer.toString(k);
            }
        }
        return Long.toString(nVal - 1);
    }

    public String smallestGoodBase2(String n) {
        long nVal = Long.parseLong(n);
        for (int i = 2; i < nVal; i++) {
            if (nVal % i != 1) {
                continue;
            } else {
                long temp = 0;
                for (int j = 0; temp <= nVal; j++) {
                    temp += Math.pow(i, j);
                    if (temp == nVal) {
                        return Integer.toString(i);
                    }
                }

            }
        }
        return Long.toString(nVal - 1);
    }

    @Test
    public void test() {
        System.out.println(smallestGoodBase2("1000000000000000000"));
    }
}

package leetcode;

import org.junit.Test;

public class MyPow {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    private double quickMul(double x, long n) {
        if (n < 1) {
            return n == 0 ? 1 : x;
        }
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

//    public double myPow2(double x, int n) {
//        for ()
//
//    }

    @Test
    public void test() {
        System.out.println(myPow(0.00001, 2147483647));
    }
}

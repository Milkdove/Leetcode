package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class IsHappy {

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (set.add(n)) {
            int temp = 0;
            while (n >= 10) {
                temp += Math.pow(n % 10, 2);
                n = n / 10;
            }
            temp += Math.pow(n % 10, 2);
            n = temp;
        }
        return n == 1;
    }

    @Test
    public void test() {
        System.out.println(isHappy(19));
    }
}

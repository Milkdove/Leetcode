package leetcode;

import org.junit.Test;

import java.util.*;

public class Permutation {

    Set res = new HashSet();

    public String[] permutation(String s) {
        perm(s, 0, s.length());
        return (String[]) res.toArray(new String[0]);
    }

    public void perm(String s, int start, int end) {
        if (start == end) {
            res.add(s);
            return;
        } else if (end - start == 1) {
            res.add(s);
            return;
        } else {
            for (int i = start; i < end; i++) {
                s = swap(s, start, i);
                perm(s, start + 1, end);
                s = swap(s, start, i);
            }
        }
    }

    public String swap(String s, int a, int b) {
        char[] chs = s.toCharArray();
        char ch = chs[a];
        chs[a] = chs[b];
        chs[b] = ch;
        return new String(chs);
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(permutation("ABC")));
    }
}

package leetcode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class ReadBinaryWatch {

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> list = new LinkedList<>();
        for (int i = 0; i < 1024; i++) {
            int h = i >> 6;
            int m = i & 63;
            if (h < 12 && m < 60 && Integer.bitCount(i) == turnedOn) {
                list.add(h + ":" + ((m < 10) ? "0" : "") + m);
            }
        }
        return list;
    }

    public List<String> readBinaryWatch2(int turnedOn) {
        List<String> list = new LinkedList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    list.add(h + ":" + ((m < 10) ? "0" : "") + m);
                }
            }
        }
        return list;
    }

    @Test
    public void test() {
        System.out.println(readBinaryWatch2(3));
    }
}

package leetcode;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;

public class CharCount {
    public int CharCount(char[] chars) {
        if (chars == null && chars.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] - 'a' >= 0 && chars[i] - 'z' <= 0) {
                count += 1;
            } else if (chars[i] - 'A' >= 0 && chars[i] - 'Z' <= 0) {
                count += 1;
            }
        }
        return count;
    }

    @Test
    public void test() throws Exception {
        File file = new File("D:\\test\\src\\test.txt");
        FileReader fileReader = new FileReader(file);
        char[] chars = new char[(int) file.length()];
        fileReader.read(chars);
        System.out.println(CharCount(chars) + " " + file.length());
    }
}

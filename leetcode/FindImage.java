package leetcode;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

public class FindImage {
    public void find(String filetype) {
        File file = new File("D:\\test\\src");
        File[] files = file.listFiles();
        ArrayList<File> images = new ArrayList<File>();
        for (File f : files) {
            if (f.getName().lastIndexOf(filetype) == f.getName().length() - filetype.length()) {
                images.add(f);
            }
        }
        System.out.println(images.toString());
    }

    @Test
    public void test() {
        find(".txt");
    }
}

package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxLength {

    public int maxLength(List<String> arr) {
        String res = "";
        for (int i = 0; i < arr.size(); i++) {
            String temp = back(arr, i);
            res = temp.length() > res.length() ? temp : res;
        }
        System.out.println(res);
        return res.length();
    }

    public void maxLength2(List<String> arr) {


    }

    public String back(List<String> arr, int index) {
        String res = "";
        for (int i = index; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).length(); j++) {
                if (res.indexOf(arr.get(i).charAt(j)) != -1 ||
                        arr.get(i).lastIndexOf(arr.get(i).charAt(j)) != j
                        ) {
                    break;
                }
                if (j == arr.get(i).length() - 1) {
                    res += arr.get(i);
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        String[] strs = new String[]{"a", "abc", "d", "de", "def"
        };
        List<String> list;
        list = Arrays.asList(strs);
        System.out.println(maxLength(list));
    }
}

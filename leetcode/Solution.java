package leetcode;

import org.junit.Test;

import java.util.*;

public class Solution {


    @Test
    public void testCut() {
        String s = "ab_c_\"abc_adadf_asd\"_def_dddd_\"abc_ad\"";
        System.out.println(Arrays.toString(cutString(s)));
        System.out.println(cutString2(s));
        System.out.println(cutString3(s));
    }

    /**
     * java，Shell)来完成下面任务。有一个 log 日志 文件，里面每行日志大概格式如下，其中_代表空格。 ab_c_"abc_adadfasd"_def_"dddd" 需要对这样的数据进行处理，切分为数组。切分规则如下:
     * (1) 双引号 "" 里面的空格不切分，作为整体 (2) 双引号 "" 外的空格是分隔符 这样上面这行数据切分后的数组如下:
     * [
     * "ab",
     * "c",
     * "abc_adadfasd",
     * "def",
     * "dddd"
     */


    @Test
    public void test2() {
        for (int i = 1; i <= 100; i++) {
            if (i % 15 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    public String[] cutString(String s) {
        String[] res = s.split("_");
        String[] res2 = null;
        String temp = "";
        int j = 0;
        for (int i = 0; i < res.length; i++) {
            if (res[i].startsWith("\"")) {//为"开始
                temp = res[i].substring(1);
                while (!res[i].endsWith("\"")) {//跳出 "结束
                    temp = temp + "_" + res[++i];
                }
                temp = temp.substring(0, temp.length() - 1);
            } else {
                temp += res[i];
            }
            res[j] = temp;
            j++;
            res2 = Arrays.copyOf(res, j);
            temp = "";
        }
        return res2;
    }

    public ArrayList cutString2(String s) {
        String[] res = s.split("\"");
        ArrayList res2 = new ArrayList();
        String[] temp;
        for (int i = 0; i < res.length; i++) {
            if (i % 2 == 1) {//双引号中的
                res2.add(res[i]);
            } else {//需要二次分割
                temp = res[i].split("_");
                for (String a : temp) {
                    if (a != null && a.length() != 0) {
                        res2.add(a);
                    }
                }
            }
        }
        return res2;
    }

    public ArrayList cutString3(String s) {
        ArrayList<String> res = new ArrayList<>();
        String temp = "";
        int i = 0;
        while (i < s.length()) {//遍历字符串
            if (s.charAt(i) != '"' && s.charAt(i) != '_') {//普通字符
                while (s.charAt(i) != '_') {
                    temp += s.charAt(i);
                    i++;
                }
                res.add(temp);
                temp = "";
            } else if (s.charAt(i) == '"') {//遇到"
                i++;
                while (s.charAt(i) != '"') {//直到遇到下一个字符跳出
                    temp += s.charAt(i);
                    i++;
                }
                res.add(temp);
                temp = "";
            }
            i++;
        }
        return res;
    }

    @Test
    public void testsort() {
        int[] a = {1, 5, 2, 3, 4, 123, 126, 988, 0};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public void quickSort(int[] nums, int left, int right) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int temp, i, j;
        i = left;
        j = right;
        temp = nums[i];
        while (i < j) {//左右指针相遇
            while (i < j && nums[j] > temp) {//从右往左
                j--;
            }
            if (i < j) {//
                nums[i] = nums[j];
                i++;
            }
            while (i < j && nums[i] < temp) {
                i++;
            }
            if (i < j) {
                nums[j] = nums[i];
                j--;
            }
            nums[i] = temp;
            if (left < i) quickSort(nums, left, i - 1);
            if (right > j) quickSort(nums, j + 1, right);

        }

    }

    //两数之和
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    @Test
    public void test() {
        int[] a = twoSum(new int[]{1, 2, 3, 4,}, 4);
        System.out.println(Arrays.toString(a));
    }

    boolean a = true;

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();
        String a = input.next();
        String b = input.next();
        input.close();
        i = stringChange(i, a, b);
        System.out.println(i);
//        int a = Math.round(i);
    }

    public static int numCombo(int i) {
        if (i > 27 || i <= 0) {//无效数字
            return -1;
        }
        if (i < 10) {//个位数最小
            return i;
        }
        if (i <= 18) {//两位数最小
            for (int a = 1; a <= 9; a++) {
                if ((i - a) > 9) {
                    continue;
                }
                return a * 10 + (i - a);
            }
        }
        if (i <= 27) {//三位数最小
            for (int a = 1; a <= 9; a++) {
                if ((i - a) > 9) {
                    continue;
                }
                for (int b = 1; b <= 9; b++) {
                    if ((i - a - b) > 9) {
                        continue;
                    }
                    return a * 100 + (i - a) * 10 + (i - a - b);
                }
            }
        }
        return -1;
    }

    public static int stringChange(int len, String a, String b) {
        int flag = 0;
        if (a.equals(b)) return 0;
        for (int i = 0; i < len - 1; i++) {//遍历a字符串
            char z = b.charAt(i);
            flag += z;//记录值大小
            if (b.contains(z + "")) {
                continue;
            }
            return -1;
        }
        return 0;
    }
}

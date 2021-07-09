package leetcode;

import org.junit.Test;

public class VersionControl {

    public int firstBadVersion(int n) {
        int l, r = n;
        while (n > 1) {
            if (isBadVersion(n)) {//坏版本
                if (!isBadVersion(n - 1)) {//找到第一个错误版本
                    return n;
                } else {
                    if (isBadVersion(n / 2)) {
                        n /= 2;
                    } else {
                        r = n;//坏的位置
                        l = n / 2;//好的位置
                        n = (int) (0.75 * n);
                    }
                }
            } else {//好版本
                if (isBadVersion(n + 1)) {//找到第一个错误版本
                    return n + 1;
                }
                l = n;
                n += (r - l) / 2;

            }
        }
        return isBadVersion(n) ? n : 0;
    }

    public int firstBadVersion2(int n) {
        int left = 1, right = n;
        while (left < right) { // 循环直至区间左右端点相同
            int mid = left + (right - left) / 2; // 防止计算时溢出
            if (isBadVersion(mid)) {
                right = mid; // 答案在区间 [left, mid] 中
            } else {
                left = mid + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;
    }


    public boolean isBadVersion(int n) {
        return n >= 1702766719;
    }


    @Test
    public void test() {
        System.out.println(firstBadVersion2(2126753390));
        int lineLen = 1999999999;
        double times = 1.0d; // Double instead of float
        double newLineLen = (double) lineLen * times;
        System.out.println(newLineLen); // 更宽

        // TODO:hillHeight的计算有精度损失，要求修改变量类型或者数据的类型使结果以2.147483643E9形式表示
        double hillHeight = 2147483642d; // 0x7ffffffa
        hillHeight += 1.0f; // x contains 2147483647 (0x7fffffff)
        // after the computation
        System.out.println(hillHeight);

        // TODO:singleRoomWidth,averageTall有精度损失，在数值不变的情况下，通过修改计算使用的数据，修改数据类型或者明确地进行类型转换使计算结果正确，
        // totalLen计算有溢出现象，要求totalLen类型为double型
        short roomWidth = 533;
        int treeTall = 6783;
        long cableLen = 4664382371590123456L;
        float singleRoomWidth = roomWidth / 5f; // d is 106.0 (truncated)
        double averageTall = treeTall / 30d; // e is 226.0 (truncated)
        double totalLen = cableLen * 2; // f is -9.1179793305293046E18

        System.out.println(singleRoomWidth);
        System.out.println(averageTall);
        System.out.println(totalLen);

    }
}

package leetcode;

import org.junit.Test;

/**
 * 374. 猜数字大小
 * 猜数字游戏的规则如下：
 * 每轮游戏，我都会从1到n 随机选择一个数字。 请你猜选出的是哪个数字。
 * 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
 * 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
 * -1：我选出的数字比你猜的数字小 pick < num
 * 1：我选出的数字比你猜的数字大 pick > num
 * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
 * 返回我选出的数字。
 */
public class GuessNumber {

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            n = guess(right);
            if (n == -1) {//值在左
                if (right - left == 1) {
                    return left;
                } else {
                    right -= (right - left) / 2;
                }
            } else if (n == 1) {//值在右
                n = left;
                left = right;
                if (left - n == 1) {
                    right++;
                } else {
                    right = right + (right - n) / 2;
                }
            } else {
                return right;
            }
        }
        return left;
    }

    public int guess(int num) {
        int pick = 662351799;
        return pick == num ? 0 : (num > pick ? -1 : 1);
    }

    @Test
    public void test() {
        System.out.println(guessNumber(1182691386));
    }
}

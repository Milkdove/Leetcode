package leetcode;

import org.junit.Test;

/*
1818. 绝对差值和
给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。

数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始）。

你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。

在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 109 + 7 取余 后返回。

|x| 定义为：
    如果 x >= 0 ，值为 x ，或者
    如果 x <= 0 ，值为 -x
 */
public class MinAbsoluteSumDiff {

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int sum = 0, max = 0, n = nums1.length, mod = (int) 1e9 + 7;
        for (int i = 0; i < n; i++) {//两次循环看能每个元素最多能节省多少
            int n2 = nums2[i], originAbs = Math.abs(nums1[i] - n2), minAbs = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) minAbs = Math.min(minAbs, Math.abs(n2 - nums1[j]));
            max = Math.max(max, originAbs - minAbs);
            sum += originAbs;   //abs求和
        }
        return (sum - max) % mod;
    }
    

    @Test
    public void test() {
        int[] nums1 = {5, 4, 6, 8, 10}, nums2 = {2, 4, 6, 8, 10};
        System.out.println(minAbsoluteSumDiff(nums1, nums2));
    }
}

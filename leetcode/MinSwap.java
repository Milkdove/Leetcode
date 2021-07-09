package leetcode;

import org.junit.Test;

/**
 * 我们有两个长度相等且不为空的整型数组A和B。
 * 我们可以交换A[i]和B[i]的元素。注意这两个元素在各自的序列中应该处于相同的位置。
 * 在交换过一些元素之后，数组A和B都应该是严格递增的（数组严格递增的条件仅为A[0] < A[1] < A[2] < ... < A[A.length - 1]）。
 * 给定数组A和B，请返回使得两个数组均保持严格递增状态的最小交换次数。假设给定的输入总是有效的。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-swaps-to-make-sequences-increasing
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinSwap {

    public int minSwap(int[] A, int[] B) {//dp[n]=dp[n-1] // dp[n-1]+1
        // n: natural, s: swapped
        int n1 = 0, s1 = 1;
        for (int i = 1; i < A.length; ++i) {
            int n2 = Integer.MAX_VALUE, s2 = Integer.MAX_VALUE;
            if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
                n2 = Math.min(n2, n1);
                s2 = Math.min(s2, s1 + 1);
            }
            if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
                n2 = Math.min(n2, s1);
                s2 = Math.min(s2, n1 + 1);
            }
            n1 = n2;
            s1 = s2;
        }
        return Math.min(n1, s1);
    }

    public int minSwap2(int[] A, int[] B) {//dp[n]=dp[n-1] // dp[n-1]+1
        int[][] dp = new int[A.length][2];
        dp[0][1] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = Integer.MAX_VALUE;
            if (A[i] > A[i - 1] && B[i] > B[i - 1]) {//可交换 可不换
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][0]);
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][1] + 1);

            }
            if (A[i] > B[i - 1] && B[i] > A[i - 1]) {//可交换 可不换
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]);
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][0] + 1);
            }

        }
        return Math.min(dp[A.length - 1][0], dp[A.length - 1][1]);
    }


    @Test
    public void test() {

        /*
        [0,4,4,5,9]
        [0,1,6,8,10]
         */
        int[] nums1 = new int[]{0, 7, 8, 10, 10, 11, 12, 13, 19, 18};
        int[] nums2 = new int[]{4, 4, 5, 7, 11, 14, 15, 16, 17, 20};
        System.out.println(minSwap2(nums1, nums2));
    }
}

package leetcode;

import org.junit.Test;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * <p>
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return back(nums, 0, nums.length - 1);
    }

    public TreeNode back(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = back(nums, start, mid - 1);
        node.right = back(nums, mid + 1, end);
        return node;
    }

    @Test
    public void test() {
        System.out.println(sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }
}

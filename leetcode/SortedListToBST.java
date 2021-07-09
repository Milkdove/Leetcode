package leetcode;

import org.junit.Test;

public class SortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    public TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = getMedian(left, right);
        TreeNode node = new TreeNode(mid.val);
        node.left = buildTree(left, mid);
        node.right = buildTree(mid.next, right);
        return node;
    }


    public ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    @Test
    public void test() {

    }
}

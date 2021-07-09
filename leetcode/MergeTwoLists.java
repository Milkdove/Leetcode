package leetcode;

import org.junit.Test;

public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l2 == null || l1 != null) {
            return l2 == null ? l1 : l2;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }

    @Test
    public void test() {

    }
}

package leetcode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * <p>
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 */
public class isSymmetric {

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        } else if (node1.val != node2.val) {
            return false;
        } else {
            return check(node1.left, node2.right) && check(node1.right, node2.left);
        }
    }

    public boolean check2(TreeNode node1, TreeNode node2) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node1);
        q.offer(node2);

        while (!q.isEmpty()) {
            node1 = q.poll();
            node2 = q.poll();
            if (node1 == null && node2 == null) {
                continue;
            } else if (node1 == null || node2 == null) {
                return false;
            } else if (node1.val != node2.val) {
                return false;
            }
            q.offer(node1.left);
            q.offer(node2.right);
            q.offer(node1.right);
            q.offer(node2.left);
        }
        return true;
    }

    @Test
    public void test() {
        TreeNode node = new TreeNode();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node.left);
        q.offer(node.left);
        System.out.println(q.isEmpty());
        q.poll();
        System.out.println(q.poll());
        System.out.println(q.isEmpty());
    }
}
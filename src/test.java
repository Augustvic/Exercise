import DataStructure.BinaryTree;
import DataStructure.BinaryTreeNode;
import DataStructure.ComplexListNode;
import DataStructure.ListNode;
import Tools.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
        BinaryTree test = new BinaryTree();
        System.out.println(t.getDepth(test.full_binary_tree()));
        System.out.println(t.getDepth(test.complete_binary_tree()));
        System.out.println(t.getDepth(test.one_node_binary_tree()));
        System.out.println(t.getDepth(test.left_node_only_binary_tree()));
        System.out.println(t.getDepth(test.right_node_only_binary_tree()));
        System.out.println(t.isBalancedOptimal(test.full_binary_tree()));
        System.out.println(t.isBalancedOptimal(test.complete_binary_tree()));
        System.out.println(t.isBalancedOptimal(test.one_node_binary_tree()));
        System.out.println(t.isBalancedOptimal(test.left_node_only_binary_tree()));
        System.out.println(t.isBalancedOptimal(test.right_node_only_binary_tree()));
    }

    public static test t = new test();

    public int getDepth(BinaryTreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    private boolean flag = true;

    public boolean isBalancedOptimal(BinaryTreeNode root) {
        if (root == null)
            return true;
        isBalancedWithDepth(root);
        return flag;
    }

    private int isBalancedWithDepth(BinaryTreeNode root) {
        if (root == null)
            return 0;
        int left = isBalancedWithDepth(root.left);
        int right = isBalancedWithDepth(root.right);
        if (Math.abs(left - right) > 1) {
            flag = false;
        }
        return Math.max(left, right) + 1;
    }
}

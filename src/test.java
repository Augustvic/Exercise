import DataStructure.BinaryTreeNode;
import DataStructure.ComplexListNode;
import DataStructure.ListNode;
import Tools.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(6);
        root.right = new BinaryTreeNode(14);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(8);
        root.right.left = new BinaryTreeNode(12);
        root.right.right = new BinaryTreeNode(16);
        BinaryTreeNode res = t.convert(root);
        BinaryTreeNode curr = res;
        while(curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
    }

    public static test t = new test();

    private BinaryTreeNode curr, head;

    public BinaryTreeNode convert(BinaryTreeNode root) {
        if (root == null)
            return null;
        convertHelp(root);
        return head;
    }

    public void convertHelp(BinaryTreeNode root) {
        if (root == null)
            return;
        convertHelp(root.left);
        if (head == null) {
            head = root;
            curr = root;
        }
        else {
            curr.right = root;
            root.left = curr;
            curr = curr.right;
        }
        convertHelp(root.right);
    }
}

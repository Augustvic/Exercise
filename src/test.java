import DataStructure.BinaryTreeNode;
import DataStructure.ListNode;
import Tools.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(8);
        root.left = new BinaryTreeNode(6);
        root.right = new BinaryTreeNode(10);
        root.left.left = new BinaryTreeNode(5);
        root.left.right = new BinaryTreeNode(7);
        root.right.left = new BinaryTreeNode(9);
        root.right.right = new BinaryTreeNode(11);
        t.print(root);
        System.out.println();
        t.getMirror(root);
        t.print(root);
    }

    public static test t = new test();

    public void getMirror(BinaryTreeNode root) {
        if (root == null)
            return;
        BinaryTreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        getMirror(root.left);
        getMirror(root.right);
    }

    public void print(BinaryTreeNode root) {
        if(root == null)
            return;
        print(root.left);
        System.out.print(root.val + " ");
        print(root.right);
    }
}

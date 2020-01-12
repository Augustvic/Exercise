package DataStructure;

import java.util.LinkedList;
import java.util.List;

public class Tree {

    public static TreeNode treeInstance() {
        TreeNode root = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        root.child.add(t2);
        root.child.add(t3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t2.child.add(t4);
        t2.child.add(t5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t4.child.add(t6);
        t4.child.add(t7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        TreeNode t10 = new TreeNode(10);
        t5.child.add(t8);
        t5.child.add(t9);
        t5.child.add(t10);
        return root;
    }
}

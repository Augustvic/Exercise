import DataStructure.*;
import Tools.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode r1 = new TreeNode(1, root);
        TreeNode r2 = new TreeNode(2, root);
        TreeNode r3 = new TreeNode(3, r1);
        TreeNode r4 = new TreeNode(4, r1);
        TreeNode r5 = new TreeNode(5, r3);
        TreeNode r6 = new TreeNode(6, r3);
        TreeNode r7 = new TreeNode(7, r4);
        TreeNode r8 = new TreeNode(8, r4);
        TreeNode r9 = new TreeNode(9, r4);
        root.child.add(r1);
        root.child.add(r2);
        r1.child.add(r3);
        r1.child.add(r4);
        r3.child.add(r5);
        r3.child.add(r6);
        r4.child.add(r7);
        r4.child.add(r8);
        r4.child.add(r9);
        System.out.println(t.getCommonParentNode(root, r3, root).val);
    }

    public static test t = new test();

    public TreeNode getCommonParentNode(TreeNode root, TreeNode r1, TreeNode r2) {
        if (root == null || r1 == null || r2 == null)
            return null;
        LinkedList<TreeNode> l1 = getPath(root, r1);
        LinkedList<TreeNode> l2 = getPath(root, r2);
        TreeNode ret = null;
        while (!l1.isEmpty() && !l2.isEmpty() && l1.getFirst() == l2.getFirst()) {
            ret = l1.getFirst();
            l1.removeFirst();
            l2.removeFirst();
        }
        return ret;
    }

    private LinkedList<TreeNode> getPath(TreeNode root, TreeNode r1) {
        if (root == null || r1 == null)
            return null;
        LinkedList<TreeNode> l = new LinkedList<>();
        getPathHelp(root, r1, l);
        return l;
    }

    private boolean getPathHelp(TreeNode root, TreeNode r1, LinkedList<TreeNode> l) {
        if (root == null) {
            return false;
        }
        if (root == r1) {
            l.add(root);
            return true;
        }
        boolean found = false;
        l.add(root);
        Iterator<TreeNode> it = root.child.iterator();
        while (!found && it.hasNext()) {
            found = getPathHelp(it.next(), r1, l);
        }
        if (!found)
            l.removeLast();
        return found;
    }
}

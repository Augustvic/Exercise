import DataStructure.*;

import java.util.Iterator;
import java.util.LinkedList;

public class test {
    public static void main(String[] args) {
        TreeNode root = Tree.treeInstance();
        TreeNode ret = t.getCommonParentNode(root, root.child.get(0), root.child.get(1));
        System.out.println(ret.val);
    }

    private static test t = new test();

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

    private LinkedList<TreeNode> getPath(TreeNode root, TreeNode r) {
        LinkedList<TreeNode> list = new LinkedList<>();
        if (root == null || r == null)
            return list;
        getPathHelp(list, root, r);
        return list;
    }

    private boolean getPathHelp(LinkedList<TreeNode> list, TreeNode root, TreeNode r) {
        if (root == null)
            return false;
        if (root == r) {
            list.add(root);
            return true;
        }
        list.add(root);
        boolean found = false;
        Iterator<TreeNode> it = root.child.iterator();
        while (!found && it.hasNext()) {
            found = getPathHelp(list, it.next(), r);
        }
        if (!found)
            list.removeLast();
        return found;
    }
}

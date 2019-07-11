import java.util.*;

import DataStructure.TreeNode;

/**
 * Created by August on 2019/5/7 10:31
 **/

public class test {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
    }

    private static test t = new test();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return null;
        LinkedList<TreeNode> path1 = new LinkedList<>();
        getPathHelp(root, p, path1);
        LinkedList<TreeNode> path2 = new LinkedList<>();
        getPathHelp(root, q, path2);
        return getCommonParent(path1, path2);
    }

    public boolean getPathHelp(TreeNode root, TreeNode p, LinkedList<TreeNode> path) {
        if (root == null)
            return false;
        if (root == p) {
            path.add(p);
            return true;
        }
        path.add(root);
        boolean flag = getPathHelp(root.left, p, path) || getPathHelp(root.right, p, path);
        if (!flag)
            path.removeLast();
        return flag;
    }

    public TreeNode getCommonParent(List<TreeNode> path1, List<TreeNode> path2) {
        int i = 0;
        while (i < path1.size() && i < path2.size() && path1.get(i) == path2.get(i))
            i++;
        return path1.get(i - 1) == path2.get(i - 1) ? path1.get(i - 1) : null;
    }

}

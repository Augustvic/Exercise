package DataStructure;

import java.util.LinkedList;
import java.util.List;

/**
 * author : August
 * description :
 * remarks:
 * date : 2019/4/30 20:50
 */

public class TreeNode {
//        public int val;
//        public TreeNode parent;
//        public List<TreeNode> child = new LinkedList<>();
//        public TreeNode(int val) {
//            this.val = val;
//        }
//        public TreeNode(int val, TreeNode parent) {
//            this.val = val;
//            this.parent = parent;
//        }

    public int val;
    public TreeNode left = null;
    public TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}

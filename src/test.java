import DataStructure.*;
import Tools.*;
import com.sun.javafx.css.parser.LadderConverter;
import javafx.util.Pair;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

public class test {
    public static void main(String[] args) {
        t.print(BinaryTree.complete_binary_tree());
    }

    public static test t = new test();

    public void print(BinaryTreeNode root) {
        ArrayDeque<BinaryTreeNode> aq = new ArrayDeque<>();
        aq.offer(root);
        int currLevel = 1;
        int nextLevel = 0;
        while (!aq.isEmpty()) {
            if (currLevel == 0) {
                System.out.println();
                currLevel = nextLevel;
                nextLevel = 0;
            }
            BinaryTreeNode tn = aq.poll();
            System.out.print(tn.val + " ");
            currLevel--;
            if (tn.left != null) {
                aq.offer(tn.left);
                nextLevel++;
            }
            if (tn.right != null) {
                aq.offer(tn.right);
                nextLevel++;
            }
        }
    }
}

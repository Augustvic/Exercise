import DataStructure.*;
import Tools.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {

        // 栈：先进后出，后进先出(LIFO)
        Stack<Integer> iStack = new Stack<Integer>(); //实例化一个存储Integer类型对象的栈对象

        iStack.push(0); //入栈
        iStack.push(1);

        for (int i = 0; i < 5; i++) {

            int f2 = iStack.pop(); //出栈
            int f1 = iStack.pop();

            int tmp = f1 + f2;

            iStack.push(f1);
            iStack.push(f2);
            iStack.push(tmp);

        }

        while (!iStack.empty()) { //判断栈是否为空
            System.out.println(iStack); //打印栈里面的数据
            iStack.pop();
        }
    }

    public static test t = new test();

    public void postOrder(BinaryTreeNode root) {
        if (root == null)
            return;
        Stack<BinaryTreeNode> st1 = new Stack<>();
        Stack<BinaryTreeNode> st2 = new Stack<>();
        while (root != null || !st1.isEmpty()) {
            while (root != null) {
                st1.push(root);
                st2.push(root);
                root = root.right;
            }
            if (!st1.isEmpty()) {
                root = st1.pop();
                root = root.left;
            }
        }
        while (!st2.isEmpty()) {
            root = st2.pop();
            visit(root);
        }
    }

    private void visit(BinaryTreeNode root) {
        System.out.print(root.val + " ");
    }
}

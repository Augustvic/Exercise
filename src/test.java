import DataStructure.*;
import Tools.*;
import com.sun.javafx.css.parser.LadderConverter;
import javafx.util.Pair;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        ListNode headB = new ListNode(2);
        ListNode intersection = new ListNode(8);
        headA.next = new ListNode(4);
        headA.next.next = intersection;
        headB.next = intersection;
        ListNode ret = t.getIntersectionNode(headA, headB);
        System.out.println(ret.val);
    }

    public static test t = new test();

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        if (lenA > lenB) {
            while (lenA > lenB) {
                headA = headA.next;
                lenA--;
            }
        }
        else if (lenA < lenB) {
            while (lenA < lenB) {
                headB = headB.next;
                lenB--;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    private int getLength(ListNode head) {
        int cnt = 0;
        while (head != null) {
            cnt++;
            head = head.next;
        }
        return cnt;
    }
}

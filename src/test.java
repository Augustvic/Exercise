import DataStructure.BinaryTreeNode;
import DataStructure.ListNode;
import Tools.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = head.next;
        ListNode res = t.findEntry(head);
        if(res == null)
            System.out.print("None");
        else
            System.out.print(res.val);
    }

    public static test t = new test();

    public ListNode findEntry(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode meet = hasCycle(head);
        if (meet != null) {
            ListNode p = meet.next;
            int lengthOfCycle = 1;
            while (p != meet) {
                lengthOfCycle++;
                p = p.next;
            }
            p = head;
            for (int i = 0; i < lengthOfCycle; i++)
                p = p.next;
            ListNode q = head;
            while (p != q) {
                p = p.next;
                q = q.next;
            }
            return p;
        }
        return null;
    }

    private ListNode hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null && fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast == null || fast.next == null)
            return null;
        return fast;
    }
}

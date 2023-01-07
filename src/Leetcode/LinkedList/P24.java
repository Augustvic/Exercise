package Leetcode.LinkedList;

import static Leetcode.LinkedList.ListNode.print;

public class P24 {

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        print(swapPairs(l));
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preHead = new ListNode(-1);
        preHead.next = head.next;
        ListNode p = head, q = head.next;
        while (q != null) {
            if (q.next != null) {
                ListNode next = q.next;
                q.next = p;
                p.next = (next.next == null ? next : next.next);
                p = next;
                q = next.next;
            } else {
                q.next = p;
                p.next = null;
                break;
            }
        }
        return preHead.next;
    }
}

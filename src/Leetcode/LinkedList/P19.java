package Leetcode.LinkedList;

import static Leetcode.LinkedList.ListNode.print;

public class P19 {

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        ListNode head = removeNthFromEnd(l, 2);
        print(head);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        int length = getLength(head);
        if (length < n) {
            return head;
        }
        if (length == n) {
            return head.next;
        }
        ListNode pre = head, curr = head;
        for (int i = 0; i <= n; i++) {
            curr = curr.next;
        }
        while (curr != null) {
            pre = pre.next;
            curr = curr.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    public static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}

package Leetcode.LinkedList;

import static Leetcode.LinkedList.ListNode.print;

public class P2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(9);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(9);
        ListNode head =addTwoNumbers2(l1, l2);
        print(head);
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return  l1;
        }
        ListNode sList = l1, lList = l2;
        int len1 = getLen(l1);
        int len2 = getLen(l2);
        if (len1 > len2) {
            sList = l2;
            lList = l1;
        }
        ListNode head = lList;
        ListNode tail = lList;
        int carry = 0;
        while (lList != null) {
            int lEle = lList.val;
            int sEle = sList == null ? 0 : sList.val;
            lList.val = (lEle + sEle + carry) % 10;
            carry = (lEle + sEle + carry) / 10;
            tail = lList;
            lList = lList.next;
            sList = sList == null ? null : sList.next;
        }
        if (carry != 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    private static int getLen(ListNode l1) {
        int len = 0;
        while (l1 != null) {
            len++;
            l1 = l1.next;
        }
        return len;
    }
}
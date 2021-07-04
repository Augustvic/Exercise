package Leetcode.LinkedList;


public class P2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(9);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(9);
        ListNode head =addTwoNumbers(l1, l2);
        System.out.println();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int len1 = length(l1);
        int len2 = length(l2);
        if (len1 < len2) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        ListNode preFirst = new ListNode(-1, l1);
        ListNode pre = preFirst;
        while (l2 != null) {
            int sum = l1.val + l2.val + carry;
            l1.val = sum % 10;
            carry = sum / 10;
            pre = pre.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null && carry != 0) {
            int sum = l1.val + carry;
            l1.val = sum % 10;
            carry = sum / 10;
            pre = pre.next;
            l1 = l1.next;
        }
        if (l1 == null && carry != 0) {
            pre.next = new ListNode(carry);
        }
        return preFirst.next;
    }

    private static int length(ListNode l) {
        int len = 0;
        while (l != null) {
            len++;
            l = l.next;
        }
        return len;
    }
}
package Leetcode.LinkedList;

public class P25 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        int k = 3;
        ListNode ret = reverseKGroup(l1, 3);
        while (ret != null) {
            System.out.print(ret.val + " ");
            ret = ret.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode preHead = new ListNode(-1, head);
        ListNode preStart = preHead;
        ListNode start = head;
        loop:
        while (start != null) {
            ListNode end = start;
            for (int i = 1; i < k; i++) {
                end = end.next;
                if (end == null) {
                    break loop;
                }
            }
            ListNode nextStart = end.next;
            end.next = null;
            preStart.next = reverse(start, end);
            start.next = nextStart;
            preStart = start;
            start = nextStart;
        }
        return preHead.next;
    }

    public static ListNode reverse(ListNode start, ListNode end) {
        if (start == end) {
            return start;
        }
        ListNode p = start, q = start.next;
        while (q != null) {
            ListNode nex = q.next;
            q.next = p;
            p = q;
            q = nex;
        }
        return end;
    }
}

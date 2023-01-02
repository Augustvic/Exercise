package Leetcode.LinkedList;

import static Leetcode.LinkedList.ListNode.print;

public class P23 {

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[4];
        ListNode l1 = new ListNode(-1);
        l1.next = new ListNode(5);
        lists[1] = l1;
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);
        lists[2] = l2;
        ListNode l3 = new ListNode(4);
        l3.next = new ListNode(5);
        l3.next.next = new ListNode(6);
        lists[3] = l3;
        ListNode head =mergeKLists(lists);
        print(head);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        adjustMinHeapAll(lists);
        ListNode preHead = new ListNode(-1);
        ListNode curr = preHead;
        while (!isEmpty(lists)) {
            curr.next = lists[0];
            curr = curr.next;
            lists[0] = lists[0].next;
            adjustMinHeap(lists, 0);
        }
        return preHead.next;
    }

    public static boolean isEmpty(ListNode[] lists) {
        for (ListNode list : lists) {
            if (list != null) {
                return false;
            }
        }
        return true;
    }

    public static void adjustMinHeapAll(ListNode[] lists) {
        for (int i = lists.length / 2 - 1; i >= 0; i--) {
            adjustMinHeap(lists, i);
        }
    }

    public static void adjustMinHeap(ListNode[] lists, int i) {
        ListNode temp = lists[i];
        for (int k = 2 * i + 1; k < lists.length; k = 2 * k + 1) {
            if (k + 1 < lists.length && lt(lists, k + 1, k)) {
                k = k + 1;
            }
            if (lists[k] == null) {
                continue;
            }
            if (temp == null || temp.val > lists[k].val) {
                lists[i] = lists[k];
                i = k;
            }
        }
        lists[i] = temp;
    }

    public static boolean lt(ListNode[] lists, int i, int j) {
        if (lists[i] != null && lists[j] == null) {
            return true;
        }
        return lists[i] != null && lists[j] != null && lists[i].val < lists[j].val;
    }
}

package playground.leetcode2;

import playground.leetcode.ListNode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = head;
        int size = 1;

        while (last.next != null) {
            size++;
            last = last.next;
        }

        k = k % size;
        if (k == 0) {
            return head;
        }

        ListNode current = head;
        for (int i = 0; i < size - k - 1; i++) {
            current = current.next;
        }

        last.next = head;
        ListNode newHead = current.next;
        current.next = null;

        return newHead;
    }


}

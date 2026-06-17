package playground.leetcode2;

import playground.leetcode.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class DeletetheMiddleNodeofaLinkedList {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;

        ListNode ret = head;
        ListNode doubleSpeed = head;
        ListNode prev = head;

        while (head != null) {
            if (doubleSpeed == null || doubleSpeed.next == null) {
                prev.next = head.next;
                return ret;
            }
            prev = head;
            head = head.next;
            doubleSpeed = doubleSpeed.next;
            if (doubleSpeed != null) {
                doubleSpeed = doubleSpeed.next;
            }
        }
        return ret;
    }
}

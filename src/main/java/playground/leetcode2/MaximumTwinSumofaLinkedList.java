package playground.leetcode2;

import playground.leetcode.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MaximumTwinSumofaLinkedList {

    public int pairSum(ListNode head) {
        ListNode dh = head;
        Deque<Integer> stack = new ArrayDeque<>();
        int max = Integer.MIN_VALUE;
        while (head != null) {
            if (dh != null) {
                stack.push(head.val);
                head = head.next;
                dh = dh.next;
                if (dh != null) {
                    dh = dh.next;
                }
            } else {
                max = Math.max(max, stack.pop() + head.val);
                head = head.next;
            }
        }
        return max;
    }


}

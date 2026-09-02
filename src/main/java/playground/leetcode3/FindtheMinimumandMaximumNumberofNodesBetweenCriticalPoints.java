package playground.leetcode3;

import playground.leetcode.ListNode;

public class FindtheMinimumandMaximumNumberofNodesBetweenCriticalPoints {

    public int[] nodesBetweenCriticalPoints(ListNode head) {

        ListNode first = head;
        ListNode middle = head != null ? head.next : null;
        ListNode last = middle != null ? middle.next : null;
        int lastFound = -1;
        int firstFound = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int i = 1;
        while (last != null) {
            if (middle.val < first.val && middle.val < last.val) {
                if (firstFound == -1) {
                    firstFound = i;
                } else {
                    max = Math.max(i - firstFound, max);
                    min = Math.min(i - lastFound, min);
                }
                lastFound = i;

            }
            if (middle.val > first.val && middle.val > last.val) {
                if (firstFound == -1) {
                    firstFound = i;
                } else {
                    max = Math.max(i - firstFound, max);
                    min = Math.min(i - lastFound, min);
                }
                lastFound = i;
            }
            i++;
            first = middle;
            middle = last;
            last = last.next;
        }
        if (max != Integer.MIN_VALUE) {
            return new int[]{min, max};
        }

        return new int[]{-1, -1};
    }

}

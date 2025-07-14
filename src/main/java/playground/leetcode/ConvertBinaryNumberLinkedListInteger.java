package playground.leetcode;

/**
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/description/?envType=daily-question&envId=2025-07-14
 */
public class ConvertBinaryNumberLinkedListInteger {

    public int getDecimalValue(ListNode head) {
        int size = sizeOf(head);
        int res = 0;
        int pow = 1 << size;
        while (head != null) {
            pow = pow / 2;
            res = res + head.val * pow;
            head = head.next;
        }
        return res;
    }

    private static int sizeOf(ListNode node) {
        int s = 0;
        while (node != null) {
            s++;
            node = node.next;
        }
        return s;
    }

}

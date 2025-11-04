package playground.leetcode;

import java.util.HashSet;
import java.util.List;

public class DeleteNodesFromLinkedListPresentInArray {

    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode ret = null;
        ListNode last = null;
        HashSet<Integer> nn = new HashSet<>();
        for (int el : nums) {
            nn.add(el);
        }
        while (head != null) {
            if (!nn.contains(head.val)) {
                if (last == null) {
                    last = head;
                    ret = head;
                } else {
                    last.next = head;
                    last = last.next;
                }
            }
            head = head.next;
        }
        last.next = null;
        return ret;
    }

}

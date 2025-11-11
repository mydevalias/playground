package playground.leetcode;

import java.util.ArrayList;

public class MinimumOperationsConvertAllElementsZero {

    public int minOperations(int[] nums) {
        int stack[] = new int[nums.length];
        int c = 0;
        int ss = 0;
        for (int el : nums) {
            while (ss != 0 && el < stack[ss - 1]) {
                ss--;
            }
            if (el == 0) {
                continue;
            }
            if (ss == 0 || stack[ss - 1] < el) {
                stack[ss] = el;
                ss++;
                c++;
            }
        }
        return c;
    }
}

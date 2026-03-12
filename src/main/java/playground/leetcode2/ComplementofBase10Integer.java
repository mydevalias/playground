package playground.leetcode2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ComplementofBase10Integer {

    public int bitwiseComplement(int n) {
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        while (n > 0) {
            int rem = n % 2;
            stack.push(rem > 0 ? 0 : 1);
            n = n / 2;
        }
        while (!stack.isEmpty()) {
            res = res * 2 + stack.pop();
        }

        return res;
    }

}

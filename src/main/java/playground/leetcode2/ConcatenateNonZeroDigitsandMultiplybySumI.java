package playground.leetcode2;

import java.util.ArrayDeque;
import java.util.Deque;

public class ConcatenateNonZeroDigitsandMultiplybySumI {

    public long sumAndMultiply(int n) {
        int sum = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        while (n != 0) {
            int e = n % 10;
            n = n / 10;
            if (e == 0) {
                continue;
            }
            stack.push(e);
            sum += e;
        }
        long res = 0;
        while (!stack.isEmpty()) {
            res = res * 10 + stack.pop();
        }
        return res * sum;
    }

}

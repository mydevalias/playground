package playground.leetcode2;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.Queue;

public class JumpGameIII {

    public boolean canReach(int[] arr, int start) {
        if (arr[start] == 0) {
            return true;
        }
        BitSet visited = new BitSet(arr.length);
        Queue<Integer> stack = new LinkedList<>();
        stack.add(start);
        visited.set(start);
        while (!stack.isEmpty()) {
            Integer pos = stack.poll();

            int nextLeft = pos - arr[pos];
            if (found(arr, nextLeft, visited, stack)) {
                return true;
            }
            int nextRight = pos + arr[pos];
            if (found(arr, nextRight, visited, stack)) {
                return true;
            }

        }
        return false;

    }

    private static boolean found(int[] arr, int next, BitSet visited, Queue<Integer> stack) {
        if (next>=0 && next < arr.length && !visited.get(next)) {
            if (arr[next] == 0) {
                return true;
            }
            stack.add(next);
            visited.set(next);
        }
        return false;
    }


}

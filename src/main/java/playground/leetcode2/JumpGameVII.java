package playground.leetcode2;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.Queue;

public class JumpGameVII {

    public boolean canReach(String s, int minJump, int maxJump) {
        if (s.charAt(s.length() - 1) != 0) {
            return false;
        }
        BitSet visited = new BitSet(s.length());
        Queue<Integer> stack = new LinkedList<>();
        stack.add(0);
        visited.set(0);

        while (!stack.isEmpty()) {
            int pos = stack.poll();
            for (int i = Math.min(pos + minJump, s.length()); i < Math.min(pos + maxJump, s.length()); i++) {
                if (visited.get(i)) {
                    continue;
                }
                if (s.charAt(i) == '0') {
                    if (i == s.length() - 1) {
                        return true;
                    }
                    visited.set(i);
                    stack.add(i);
                }
            }
        }
        return false;
    }

}

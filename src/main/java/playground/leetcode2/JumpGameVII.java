package playground.leetcode2;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.Queue;

public class JumpGameVII {

    public boolean canReach(String s, int minJump, int maxJump) {
        if (s.charAt(s.length() - 1) != '0') {
            return false;
        }
        BitSet visited = new BitSet(s.length());
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited.set(0);
        int maxReached = 0;

        while (!queue.isEmpty()) {
            int pos = queue.poll();
            for (int i = Math.max(pos + minJump, maxReached + 1); i <= Math.min(pos + maxJump, s.length() - 1); i++) {
                if (s.charAt(i) == '0') {
                    if (i == s.length() - 1) {
                        return true;
                    }
                    visited.set(i);
                    queue.add(i);
                }
                maxReached = i; //this will help to skip already visited on I don't get O(n^2)
            }
        }
        return false;
    }
}

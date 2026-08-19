package playground.leetcode3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CinemaSeatAllocation {
     static final Set<Integer> TWO_GROUPS = new HashSet<>();
     static final Set<Integer> ONE_GROUP = new HashSet<>();

    static {
        int leftMask = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
        int midMask = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);
        int rightMask = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);
        for (int mask = 0; mask < 2048; mask++) {
            boolean left = (mask & leftMask) == 0;
            boolean mid = (mask & midMask) == 0;
            boolean right = (mask & rightMask) == 0;
            if (left && right) {
                TWO_GROUPS.add(mask);
            } else if (left || mid || right) {
                ONE_GROUP.add(mask);
            }
        }
    }

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Arrays.sort(reservedSeats, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        int res = 0;
        int index = 0;
        for (int i = 1; i <= n; i++) {
            int mask = 0;
            while (index < reservedSeats.length && reservedSeats[index][0] == i) {
                mask |= 1 << reservedSeats[index][1];
                index++;
            }
            if (TWO_GROUPS.contains(mask)) {
                res += 2;
            } else if (ONE_GROUP.contains(mask)) {
                res += 1;
            }
        }
        return res;
    }
}

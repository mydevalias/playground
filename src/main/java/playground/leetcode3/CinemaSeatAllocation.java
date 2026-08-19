package playground.leetcode3;

import java.util.Arrays;

public class CinemaSeatAllocation {
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
            boolean[] reserved = new boolean[11];
            while (index < reservedSeats.length && reservedSeats[index][0] == i) {
                reserved[reservedSeats[index][1]] = true;
                index++;
            }
            boolean left = !reserved[2] && !reserved[3] && !reserved[4] && !reserved[5];
            boolean mid = !reserved[4] && !reserved[5] && !reserved[6] && !reserved[7];
            boolean right = !reserved[6] && !reserved[7] && !reserved[8] && !reserved[9];
            if (left && right) {
                res += 2;
            } else if (left || mid || right) {
                res += 1;
            }
        }
        return res;
    }
}

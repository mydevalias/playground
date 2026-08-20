package playground.leetcode3;

import java.util.*;

public class CinemaSeatAllocation {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> rowMasks = new HashMap<>();
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            int currentMask = rowMasks.getOrDefault(row, 0);
            int seatBit = 1 << (col - 1);
            int updatedMask = currentMask | seatBit;
            rowMasks.put(row, updatedMask);
        }

        int res = 2 * (n - rowMasks.size());

        int left = 0b0111100000;
        int mid  = 0b0001111000;
        int right = 0b0000011110;

        for (int row : rowMasks.values()) {
            boolean leftFree = (row & left) == 0;
            boolean midFree = (row & mid) == 0;
            boolean rightFree = (row & right) == 0;
            if (leftFree && rightFree) {
                res += 2;
            } else if (leftFree || midFree || rightFree) {
                res += 1;
            }
        }
        return res;
    }
}

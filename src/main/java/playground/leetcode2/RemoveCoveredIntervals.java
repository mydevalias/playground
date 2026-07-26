package playground.leetcode2;

import java.util.Arrays;

public class RemoveCoveredIntervals {

    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
        });
        int count = 0;
        int end = 0;
        for (int[] interval : intervals) {
            if (interval[1] > end) {
                end = interval[1];
                count++;
            }
        }

        return count;
    }

}

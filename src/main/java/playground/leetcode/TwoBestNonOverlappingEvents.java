package playground.leetcode;

import java.util.Arrays;

public class TwoBestNonOverlappingEvents {

    public int maxTwoEvents(int[][] events) {
        int max = 0;
//        Arrays.sort(events, (a, b) -> Integer.compare(a[2], b[2]));
        for (int i = 0; i < events.length - 1; i++) {
            for (int j = i + 1; j < events.length; j++) {
                boolean noOverlap = events[i][1] < events[j][0] || events[j][1] < events[i][0];
                if (noOverlap) {
                    max = Math.max(max, events[i][2] + events[j][2]);
                }
            }
            max = Math.max(max, events[i][2]);
        }
        max = Math.max(max, events[events.length - 1][2]);

        return max;
    }

}

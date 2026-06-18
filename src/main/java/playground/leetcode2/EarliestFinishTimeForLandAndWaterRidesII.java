package playground.leetcode2;

public class EarliestFinishTimeForLandAndWaterRidesII {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        return Math.min(find(landStartTime, landDuration, waterStartTime, waterDuration),
                find(waterStartTime, waterDuration, landStartTime, landDuration));
    }

    private static int find(int[] firstStart, int[] firstDuration, int[] secondStart, int[] secondDuration) {
        int MinFirst = Integer.MAX_VALUE;

        for (int i = 0; i < firstDuration.length; i++) {
            int end = firstStart[i] + firstDuration[i];
            MinFirst = Math.min(MinFirst, end);
        }

        int minRes = Integer.MAX_VALUE;
        for (int i = 0; i < secondStart.length; i++) {
            int start = Math.max(secondStart[i], MinFirst);
            minRes = Math.min(minRes, start + secondDuration[i]);

        }

        return minRes;
    }
}

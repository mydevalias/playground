package playground.leetcode2;

public class EarliestFinishTimeForLandAndWaterRidesI {

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < landDuration.length; i++) {
            int landEnd = landStartTime[i] + landDuration[i];
            for (int j = 0; j < waterStartTime.length; j++) {
                int waterStart = Math.max(waterStartTime[j], landEnd);
                min = Math.min(min, waterStart + waterDuration[j]);
            }
        }

        for (int j = 0; j < waterStartTime.length; j++) {
            int waterEnd = waterStartTime[j] + waterDuration[j];
            for (int i = 0; i < landDuration.length; i++) {
                int landStart = Math.max(landStartTime[i], waterEnd);
                min = Math.min(min, landStart + landDuration[i]);
            }
        }

        return min;
    }

}

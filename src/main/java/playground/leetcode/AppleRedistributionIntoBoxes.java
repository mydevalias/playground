package playground.leetcode;

import java.util.Arrays;

public class AppleRedistributionIntoBoxes {

    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int sum = 0;
        for (int app : apple) {
            sum += app;
        }
        int count = 0;
        for (int i = capacity.length - 1; i >= 0; i--) {

            count++;
            sum = sum - capacity[i];
            if (sum <= 0) {
                return count;
            }
        }
        return -1;
    }


}

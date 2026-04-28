package playground.leetcode2;

public class TwoFurthestHousesWithDifferentColors {
    public int maxDistance(int[] colors) {
        int max = 0;
        for (int i = 0; i < colors.length - 1; i++) {
            for (int j = i; j < colors.length; j++) {
                if (colors[i] != colors[j]) {
                    max = Math.max(max, j - i);
                }
            }
        }
        return max;
    }
}

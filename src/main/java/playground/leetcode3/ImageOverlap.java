package playground.leetcode3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ImageOverlap {

    public int largestOverlap(int[][] img1, int[][] img2) {
        ArrayList<int[]> coordinates1 = new ArrayList<>();
        ArrayList<int[]> coordinates2 = new ArrayList<>();

        for (int i = 0; i < img1.length; i++) {
            for (int j = 0; j < img1[i].length; j++) {
                if (img1[i][j] == 1) {
                    coordinates1.add(new int[]{i, j});
                }
                if (img2[i][j] == 1) {
                    coordinates2.add(new int[]{i, j});
                }
            }
        }
        int res = 0;
        Map<Integer, Integer> all = new HashMap<>();
        for (int[] first : coordinates1) {
            for (int[] second : coordinates2) {
                int di = first[0] - second[0];
                int dj = first[1] - second[1];
                int transalation = di * 100 + dj;
                int current = all.merge(transalation, 1, Integer::sum);
                res = Math.max(res, current);
            }
        }

        return res;
    }

}

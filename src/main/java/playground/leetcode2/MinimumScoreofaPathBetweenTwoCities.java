package playground.leetcode2;

import java.util.HashMap;
import java.util.HashSet;

public class MinimumScoreofaPathBetweenTwoCities {

    public int minScore(int n, int[][] roads) {
        HashMap<Integer, Cities> all = new HashMap<>();

        for (int road[] : roads) {
            int f = road[0];
            int t = road[1];
            int d = road[2];

            Cities ff = city(all, f, d, t);
            Cities tt = city(all, t, d, f);

            if (ff != tt) {
                merge(all, ff, tt);
            } else {
                ff.min = Math.min(ff.min, d);
            }
        }

        return all.get(1).min;
    }

    private void merge(HashMap<Integer, Cities> all, Cities ff, Cities tt) {
        ff.cities.addAll(tt.cities);
        ff.min = Math.min(ff.min, tt.min);

        for (int city : tt.cities) {
            all.put(city, ff);
        }
    }

    private Cities city(HashMap<Integer, Cities> all, int f, int d, int t) {
        Cities ff = all.get(f);
        if (ff == null) {
            ff = new Cities();
            ff.min = d;
            ff.cities.add(f);
            all.put(f, ff);
        } else {
            ff.min = Math.min(ff.min, d);
        }
        return ff;
    }

    static class Cities {
        HashSet<Integer> cities = new HashSet<>();
        int min = Integer.MAX_VALUE;
    }
}

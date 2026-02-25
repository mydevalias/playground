package playground.leetcode;

import java.util.ArrayList;

public class MinimumPairRemovaltoSortArrayI {

    public int minimumPairRemoval(int[] nums) {
        ArrayList<Integer> working = new ArrayList<>();
        for (int v : nums) {
            working.add(v);
        }

        int res = 0;

        while (working.size() > 1) {
            boolean sorted = true;
            int min = Integer.MAX_VALUE;
            int pos = -1;
            for (int i = 1; i < working.size(); i++) {
                if (min > working.get(i - 1) + working.get(i)) {
                    min = working.get(i - 1) + working.get(i);
                    pos = i;
                }
                if (working.get(i - 1) > working.get(i)) {
                    sorted = false;
                }
            }
            if (sorted) {
                return res;
            }

            working.remove(pos);
            working.set(pos - 1, min);
            res++;

        }
        return res;
    }

}

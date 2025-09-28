package playground.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
//        List<Integer> result = new ArrayList<>(triangle.size());
//        result.add(triangle.get(0).get(0));
//        for (int i = 1; i < triangle.size(); i++) {
//            result.add(0);
//        }
        int min = 0;
        for (int i = 1; i < triangle.size(); i++) {
             min = Integer.MAX_VALUE;
            for (int j = 0; j < i + 1; j++) {
                var val = triangle.get(i).get(j);
                int v1 = 0;
                if (j - 1 >= 0) {
                    v1 = triangle.get(i - 1).get(j - 1);
                }
                int v2 = 0;
                if(j< triangle.get(i - 1).size()) {
                     v2 = triangle.get(i - 1).get(j);
                }
                int r = val + Math.max(v1, v2);
                triangle.get(i).set(j, r);
                min = Math.min(r, min);
            }
        }
        return min;
    }

}

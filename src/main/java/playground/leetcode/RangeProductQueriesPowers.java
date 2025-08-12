package playground.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RangeProductQueriesPowers {

    public int[] productQueries(int n, int[][] queries) {
        List<Integer> powers = new ArrayList<>();
        int rep = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                powers.add(rep);
            }
            n /= 2;
            rep *= 2;
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long cur = 1;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                cur = (cur * powers.get(j)) % 1000000007;
            }
            ans[i] = (int) cur;
        }
        return ans;
    }

}

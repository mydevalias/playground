package playground.leetcode;

public class IncrementSubmatricesOne {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] res = new int[n][n];
        for (int[] query : queries) {
            incQ(res, query);
        }
        return res;
    }

    private void incQ(int[][] res, int[] query) {
        for (int i = query[0]; i <= query[2]; i++) {
            for (int j = query[1]; j <= query[3]; j++) {
                res[i][j]++;
            }
        }
    }
}

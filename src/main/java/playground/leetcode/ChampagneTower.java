package playground.leetcode;

public class ChampagneTower {

    public double champagneTower(int poured, int query_row, int query_glass) {
        int queryRow = query_row;
        int queryGlass = query_glass;

        double m[][] = new double[101][101];
        m[0][0] = poured;
        for (int i = 0; i <= queryRow; i++) {
            for (int j = 0; j <= i; j++) {
                double quantity = (m[i][j] - 1) / 2;
                if (quantity > 0) {
                    m[i+1][j] += quantity;
                    m[i+1][j+1] += quantity;
                }
            }
        }
        return Math.min(1, m[queryRow][queryGlass]);
    }

}

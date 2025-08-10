package playground.leetcode;

/**
 * https://leetcode.com/problems/soup-servings/description
 */
public class SoupServings {

    private Double memo[][];

    public double soupServings(int n) {
        if (n > 5000) {
            return 1.0;
        }
        memo = new Double[n + 1][n + 1];
        return bk(n, n);
    }

    public double bk(int a, int b) {
        if (a <= 0 && b > 0) return 1.0;
        if (a == 0 && b == 0) return 0.5;
        if (a > 0 && b <= 0) return 0.0;
        if (a <= 0 && b <= 0) return 0.5;
        if (memo[a][b] != null) {
            return memo[a][b];
        }

        double c1 = 0.25 * bk(a - 100, b);
        double c2 = 0.25 * bk(a - 75, b - 25);
        double c3 = 0.25 * bk(a - 50, b - 50);
        double c4 = 0.25 * bk(a - 25, b - 75);
        double ret = c1 + c2 + c3 + c4;
        memo[a][b] = ret;
        return ret;
    }

}

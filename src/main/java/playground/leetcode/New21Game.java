package playground.leetcode;

import playground.IntMultiCounter;

import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.HashMap;

public class New21Game {
    int n;
    int k;
    int maxPts;
    double[] memo;

    public double new21Game(int n, int k, int maxPts) {
        this.n = n;
        this.k = k;
        this.maxPts = maxPts;
        memo =  new double[n + maxPts + 1];
        Arrays.fill(memo, -1.0);
        return bk(0);
    }

    public double bk(int current) {
        if (current >= k) {
            if (current <= n) {
                return 1.0;
            } else {
                return 0;
            }
        }
        if (memo[current] != -1.0) {
            return memo[current];
        }

        double sum = 0;

        for (int i = 1; i <= maxPts; i++) {
            sum += bk(current + i);
        }

        memo[current] = sum / maxPts;
        return memo[current];
    }

}

package playground.leetcode2;

import java.util.Arrays;

public class DetermineWhetherMatrixCanBeObtainedByRotation {

    public boolean findRotation(int[][] mat, int[][] target) {
        boolean[] trueFor = new boolean[4];
        Arrays.fill(trueFor, true);

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != target[i][j])
                    trueFor[0] = false;
                if (mat[i][j] != target[j][mat.length - i - 1])
                    trueFor[1] = false;
                if (mat[i][j] != target[mat.length - i - 1][mat[0].length - j - 1])
                    trueFor[2] = false;
                if (mat[i][j] != target[mat[0].length - j - 1][i])
                    trueFor[3] = false;
            }
        }

        return trueFor[0] || trueFor[1] || trueFor[2] || trueFor[3];
    }

}

package playground.leetcode;

public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] res = new int[n * m];
        int i = 0, j = 0;
        boolean goingUp = true;

        for (int r = 0; r < res.length; r++) {
            res[r] = mat[i][j];

            if (goingUp) {
                //(i-1, j+1)
                if (i == 0 || j == m - 1) {
                    goingUp = false;
                    if (j == m - 1) {
                        i++;
                    } else {
                        j++;
                    }
                } else {
                    i--;
                    j++;
                }
            } else {
                // (i+1, j-1)
                if (j == 0 || i == n - 1) {
                    goingUp = true;
                    if (i == n - 1) {
                        j++;
                    } else {
                        i++;
                    }
                } else {
                    i++;
                    j--;
                }
            }
        }

        return res;
    }

}

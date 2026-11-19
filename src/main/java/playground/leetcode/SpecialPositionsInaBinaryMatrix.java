package playground.leetcode;

public class SpecialPositionsInaBinaryMatrix {

    public int numSpecial(int[][] mat) {
        int[] colSums = new int[mat.length];
        int[] rowSums = new int[mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                rowSums[i] += mat[i][j];
                colSums[j] += mat[i][j];
            }
        }
        int res = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1 && rowSums[i]==1 && colSums[j]==1) {
                   res++;
                }
            }
        }
        return res;
    }

}

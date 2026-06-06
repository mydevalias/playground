package playground.leetcode2;

import java.util.Arrays;

public class RotatingTheBox {

    public char[][] rotateTheBox(char[][] boxGrid) {
        char[][] r = new char[boxGrid[0].length][boxGrid.length];
        for (char[] row : r) Arrays.fill(row, '.');
        for (int i = 0; i < boxGrid.length; i++) {
            int stone = 0;
            for (int j = 0; j < boxGrid[0].length; j++) {

                if (boxGrid[i][j] == '*') {
                    for (int kk = j - 1; kk >= j - stone; kk--) {
                        r[kk][boxGrid.length - 1 - i] = '#';
                    }
                    r[j][boxGrid.length - 1 - i] = '*';
                    stone = 0;
                } else {
                    if (boxGrid[i][j] == '#') {
                        stone++;
                    }
                }
            }
            for (int kk = boxGrid[0].length - 1; kk >= boxGrid[0].length - stone; kk--) {
                r[kk][boxGrid.length - 1 - i] = '#';
            }
        }

        return r;
    }

}

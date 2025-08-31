package playground.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int length = board.length;
        HashSet<Character>[] lines = init(length);
        HashSet<Character>[] columns = init(length);
        HashSet<Character>[] squares = init(length);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                char e = board[i][j];
                if (e == '.') {
                    continue;
                }
                if (!lines[i].add(e)) {
                    return false;
                }
                if (!columns[j].add(e)) {
                    return false;
                }
                int sq = i / 3 * 3 + j / 3;
                if (!squares[sq].add(e)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static HashSet<Character>[] init(int length) {
        HashSet<Character>[] lines = new HashSet[length];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = new HashSet<Character>();
        }
        return lines;
    }
}

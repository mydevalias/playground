package playground.leetcode;

public class CountUnguardedCellsGrid {

    private static byte GUARD = 1;
    private static byte WALL = 2;
    private static byte GUARDED = 3;
    private static byte UNGUARDED = 0;


    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        byte g[][] = new byte[m][n];
        for (int[] guard : guards) {
            g[guard[0]][guard[1]] = GUARD;
        }
        for (int[] wall : walls) {
            g[wall[0]][wall[1]] = WALL;
        }
        for (int[] guard : guards) {
            mark(guard[0], guard[1], g);
        }

        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == UNGUARDED) {
                    ret++;
                }
            }
        }
        return ret;
    }

    private void mark(int x, int y, byte[][] g) {
        for (int i = x + 1; i < g.length; i++) {
            if (g[i][y] == WALL || g[i][y] == GUARD) {
                break;
            }
            g[i][y] = GUARDED;
        }

        for (int i = x - 1; i >= 0; i--) {
            if (g[i][y] == WALL || g[i][y] == GUARD) {
                break;
            }
            g[i][y] = GUARDED;
        }

        for (int i = y + 1; i < g[x].length; i++) {
            if (g[x][i] == WALL || g[x][i] == GUARD) {
                break;
            }
            g[x][i] = GUARDED;
        }

        for (int i = y - 1; i >= 0; i--) {
            if (g[x][i] == WALL || g[x][i] == GUARD) {
                break;
            }
            g[x][i] = GUARDED;
        }
    }


}

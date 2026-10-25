package playground.leetcode3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberofClosedIslands {
    int visited[][];
    Set<Integer> checked = new HashSet<>();
    Set<Integer> invalid = new HashSet<>();
    int[][] grid;

    public int closedIsland(int[][] grid) {
        this.grid = grid;
        visited = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] == 0) {
                    if (grid[i][j] == 1) {
                        visited[i][j] = -1;
                    } else {
                        int id = (i + 1) * (j + 1);
                        checked.add(id);
                        dfs(i, j, id);
                    }
                }
            }
        }

        return checked.size() -invalid.size();
    }

    private void dfs(int i, int j, int id) {
        if (i < 0 || j < 0 || i == grid.length || j == grid.length) {
            invalid.add(id);
        }
        if (grid[i][j] == 1) {
            return;
        }
        if (visited[i][j] != 0) {
            return;
        }
        dfs(i - 1, j, id);
        dfs(i + 1, j, id);
        dfs(i, j + 1, id);
        dfs(i, j - 1, id);

    }

}

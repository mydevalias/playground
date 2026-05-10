package playground.leetcode2;

import java.util.ArrayList;
import java.util.Collections;

public class CyclicallyRotatingaGrid {

    public int[][] rotateGrid(int[][] grid, int k) {
        int layers = Math.min(grid.length, grid[0].length) / 2;

        for (int layer = 0; layer < layers; layer++) {
            layer(grid, k, layer);
        }
        return grid;
    }

    private static void layer(int[][] grid, int k, int layer) {
        ArrayList<Integer> all = new ArrayList<>();
        // Top row
        for (int i = layer; i < grid[0].length - layer; i++) {
            all.add(grid[layer][i]);
        }

        // Right col
        for (int i = layer + 1; i < grid.length - layer; i++) {
            all.add(grid[i][grid[0].length - layer - 1]);
        }

        // Bottom row
        for (int i = grid[0].length - layer - 2; i >= layer; i--) {
            all.add(grid[grid.length - layer - 1][i]);
        }

        // Left col
        for (int i = grid.length - layer - 2; i >= layer + 1; i--) {
            all.add(grid[i][layer]);
        }

        Collections.rotate(all, k);

        int cc = 0;

        for (int i = layer; i < grid[0].length - layer; i++) {
            grid[layer][i] = all.get(cc++);
        }

        // Right col
        for (int i = layer + 1; i < grid.length - layer; i++) {
            grid[i][grid[0].length - layer - 1] = all.get(cc++);
        }

        // Bottom row
        for (int i = grid[0].length - layer - 2; i >= layer; i--) {
            grid[grid.length - layer - 1][i] = all.get(cc++);
        }

        // Left col
        for (int i = grid.length - layer - 2; i >= layer + 1; i--) {
            grid[i][layer] = all.get(cc++);
        }
    }


}

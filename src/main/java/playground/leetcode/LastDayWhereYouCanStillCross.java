package playground.leetcode;

import java.util.*;

public class LastDayWhereYouCanStillCross {

    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 1;
        int right = cells.length;
        int answer = 0;
        int[][] grid = new int[row][col];

        while (left <= right) {
            int mid = left + (right - left) / 2;

            populateCells(row, col, cells, grid, mid);

            if (hasPath(grid, row, col)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private static void populateCells(int row, int col, int[][] cells, int[][] grid, int mid) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                grid[i][j] = 0;
            }
        }

        for (int day = 0; day < mid; day++) {
            int r = cells[day][0] - 1;
            int c = cells[day][1] - 1;
            grid[r][c] = 1;
        }
    }

    private boolean hasPath(int[][] grid, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < col; i++) {
            if (grid[0][i] == 0) {
                queue.offer(new int[]{0, i});
                visited[0][i] = true;
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            if (r == row - 1) {
                return true;
            }

            if (r - 1 >= 0 && !visited[r-1][c] && grid[r-1][c] == 0) {
                visited[r-1][c] = true;
                queue.offer(new int[]{r-1, c});
            }

            if (r + 1 < row && !visited[r+1][c] && grid[r+1][c] == 0) {
                visited[r+1][c] = true;
                queue.offer(new int[]{r+1, c});
            }

            if (c - 1 >= 0 && !visited[r][c-1] && grid[r][c-1] == 0) {
                visited[r][c-1] = true;
                queue.offer(new int[]{r, c-1});
            }

            if (c + 1 < col && !visited[r][c+1] && grid[r][c+1] == 0) {
                visited[r][c+1] = true;
                queue.offer(new int[]{r, c+1});
            }
        }

        return false;
    }

    public int wrongApproach(int row, int col, int[][] cells) {
        int canCrossRows = col;
        int canCrossCols = row;

        List<BitSet> rows = new ArrayList<>(row);
        List<BitSet> cols = new ArrayList<>(col);

        for (int i = 0; i < row; i++) rows.add(null);
        for (int i = 0; i < col; i++) cols.add(null);

        for(int day = 0; day < cells.length; day++){
            int[] f = cells[day];

            BitSet currentRow = get(rows, f[0], col);
            if (currentRow.cardinality() == 0) {
                canCrossRows--;
            }
            currentRow.set(f[1] - 1);
            if (currentRow.cardinality() == col) {
                canCrossRows--;
                if (canCrossRows == 0) {
                    return day;
                }
            }

            BitSet currentCol = get(cols, f[1], row);
            if (currentCol.cardinality() == 0) {
                canCrossCols--;
            }
            currentCol.set(f[0] - 1);
            if (currentCol.cardinality() == row) {
                canCrossCols--;
                if (canCrossCols == 0) {
                    return day;
                }
            }

            if (canCrossRows == 0 && canCrossCols == 0) {
                return day;
            }
        }
        return cells.length;
    }

    private BitSet get(List<BitSet> lst, int index, int size) {
        BitSet bs = lst.get(index - 1);
        if (bs == null){
            bs = new BitSet(size);
            lst.set(index - 1, bs);
        }
        return bs;
    }

}

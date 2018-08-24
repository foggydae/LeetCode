package medium;

public class Problem64_Minimum_Path_Sum {
    public int minPathSum(int[][] grid) {
        int row_num = grid.length;
        int col_num = grid[0].length;
        if (row_num == 0 || col_num == 0) {
            return 0;
        }

        int row, col;
        for (row = 0; row < row_num; row++) {
            for (col = 0; col < col_num; col++) {
                if (row == 0 && col != 0) {
                    grid[row][col] += grid[row][col - 1];
                }
                if (col == 0 && row != 0) {
                    grid[row][col] += grid[row - 1][col];
                }
                if (row != 0 && col != 0) {
                    grid[row][col] += Math.min(grid[row][col - 1], grid[row - 1][col]);
                }
            }
        }

        return grid[row_num - 1][col_num - 1];
    }
}

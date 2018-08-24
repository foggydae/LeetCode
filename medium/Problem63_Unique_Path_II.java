package medium;

public class Problem63_Unique_Path_II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row_num = obstacleGrid.length;
        int col_num = obstacleGrid[0].length;
        if (row_num == 0 || col_num == 0) {
            return 1;
        } else if (obstacleGrid[0][0] == 1 || obstacleGrid[row_num - 1][col_num - 1] == 1) {
            return 0;
        }
        
        int row, col;
        for (row = 0; row < row_num; row++) {
            for (col = 0; col < col_num; col++) {
                if (obstacleGrid[row][col] == 1) {
                    continue;
                } else {
                    if (col == 0 && row == 0) {
                        obstacleGrid[row][col] = -1;
                    } else if (col == 0) {
                        if (obstacleGrid[row - 1][col] != 1) {
                            obstacleGrid[row][col] += obstacleGrid[row - 1][col];
                        }
                    } else if (row == 0) {
                        if (obstacleGrid[row][col - 1] != 1) {
                            obstacleGrid[row][col] += obstacleGrid[row][col - 1];
                        }
                    } else {
                        if (obstacleGrid[row - 1][col] != 1) {
                            obstacleGrid[row][col] += obstacleGrid[row - 1][col];
                        }
                        if (obstacleGrid[row][col - 1] != 1) {
                            obstacleGrid[row][col] += obstacleGrid[row][col - 1];
                        }
                    }
                }
            }
        }
        
        return -obstacleGrid[row_num - 1][col_num - 1];
    }
}

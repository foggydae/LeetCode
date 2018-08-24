package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class problem51 {

    public static void main(String[] args) {
        problem51 curProblem = new problem51();
        List<List<String>> results = curProblem.solveNQueens(4);
        System.out.println(results);
    }
    
    public List<List<String>> solveNQueens(int n) {
        List<String> curBoard = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder curRow = new StringBuilder();
            for (int j = 0; j< n; j++) {
                curRow.append(".");
            }
            curBoard.add(curRow.toString());
        }
        List<List<String>> results = new ArrayList<>();
        HashSet<Integer> colTaken = new HashSet<>();
        BP(0, curBoard, results, colTaken);
        return results;
    }
    
    private void BP(int row, List<String> curBoard, List<List<String>> results, HashSet<Integer> colTaken) {
        if (row == curBoard.size()) {
            List<String> curResult = new ArrayList<>(curBoard);
            results.add(curResult);
            return;
        }
        StringBuilder curRow = new StringBuilder(curBoard.get(row));
        for (int col = 0; col < curBoard.size(); col++) {
            if (colTaken.contains(col) || checkDiagonal(row, col, curBoard)) {
                continue;
            }
            colTaken.add(col);
            curRow.setCharAt(col, 'Q');
            curBoard.set(row, curRow.toString());
            BP(row + 1, curBoard, results, colTaken);
            colTaken.remove(col);
            curRow.setCharAt(col, '.');
            curBoard.set(row, curRow.toString());
        }
    }
    
    private boolean checkDiagonal(int row, int col, List<String> curBoard) {
        int backCol = col;
        int frontCol = col;
        for (int i = 0; row - i >= 0; i++, backCol--, frontCol++) {
            if (backCol >= 0 && curBoard.get(row - i).charAt(backCol) == 'Q') {
                return true;
            }
            if (frontCol < curBoard.size() && curBoard.get(row - i).charAt(frontCol) == 'Q') {
                return true;
            }
        }
        return false;
    }
}

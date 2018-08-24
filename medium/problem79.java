package medium;

public class problem79 {
    
    public boolean exist(char[][] board, String word) {
        
        boolean[][] visit = new boolean[board.length][board[0].length]; 
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                visit[x][y] = false;
            }
        }
        
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (charMatching(x, y, board, visit, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean charMatching(int x, int y, char[][] board, boolean[][] visit, int index, String word) {
        visit[x][y] = true;
        boolean result = false;
        if (index == word.length() - 1 && board[x][y] == word.charAt(index)) {
            result = true;
        } else if (board[x][y] != word.charAt(index)) {
            result = false;
        } else if (x > 0 && !visit[x - 1][y] && charMatching(x - 1, y, board, visit, index + 1, word)) {
            result = true;
        } else if (x < board.length - 1 && !visit[x + 1][y] && charMatching(x + 1, y, board, visit, index + 1, word)) {
            result = true;
        } else if (y > 0 && !visit[x][y - 1] && charMatching(x, y - 1, board, visit, index + 1, word)) {
            result = true;
        } else if (y < board[0].length - 1 && !visit[x][y + 1] && charMatching(x, y + 1, board, visit, index + 1, word)) {
            result = true;
        } else {
            result = false;
        }
        visit[x][y] = false;        
        return result;
    }

}

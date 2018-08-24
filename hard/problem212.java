package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class problem212 {
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        HashSet<String> appeared = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            if (appeared.contains(words[i])) {
                continue;
            }
            appeared.add(words[i]);
            if (exist(board, words[i])) {
                result.add(words[i]);
            }
        }
        return result;
    }

    private boolean exist(char[][] board, String word) {
        
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

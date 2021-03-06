public class Solution {
    public boolean exist(char[][] board, String word) {
        
        //check corner cases
        if (board == null || board.length ==0) {
            return false;
        }
        
        if (word.length() == 0) {
            return true;
        }
        
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean ans = find(board, i, j, word, 0);
                    if (ans == true) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    public boolean find(char[][] board, int i, int j, String word, int start) {
        if (start == word.length()) {
            return true;
        }
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(start)) {
            return false;
        }
        
        board[i][j] = '#';
        boolean result = find(board, i-1, j, word, start+1) ||
                         find(board, i, j-1, word, start+1) ||
                         find(board, i+1, j, word, start+1) ||
                         find(board, i, j+1, word, start+1);
        
        //backtrack
        board[i][j] = word.charAt(start);
        return result;
    }
}
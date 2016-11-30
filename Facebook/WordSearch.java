public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
            if (dfs(board, visited, i, j, 0, word))
                return true;
          }
        }
       return false;
    }
    private boolean dfs(char[][] board, boolean[][] visited, int i, int j, int index, String word) {
           if (index == word.length())   return true;
           if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)    
               return false;   // stop if cross the board
           if (visited[i][j])   return false;  // stop if visited
           if (board[i][j] != word.charAt(index))  return false;   // stop if not match
           visited[i][j] = true;   // marked as visited
           boolean match = dfs(board, visited, i - 1, j, index + 1, word)
                 || dfs(board, visited, i, j - 1, index + 1, word)
                 || dfs(board, visited, i + 1, j, index + 1, word)
                 || dfs(board, visited, i, j + 1, index + 1, word);
           visited[i][j] = false;
           return match;
   }
}

public class Solution {
public boolean exist(char[][] board, String word) {
    for(int i = 0; i < board.length; i++)
        for(int j = 0; j < board[0].length; j++){
            if(exist(board, i, j, word, 0))
                return true;
        }
    return false;
}
private boolean exist(char[][] board, int i, int j, String word, int ind){
    if(ind == word.length()) return true;
    if(i > board.length-1 || i <0 || j<0 || j >board[0].length-1 || board[i][j]!=word.charAt(ind))
        return false;
    board[i][j]='*';
    boolean result =    exist(board, i-1, j, word, ind+1) ||
                        exist(board, i, j-1, word, ind+1) ||
                        exist(board, i, j+1, word, ind+1) ||
                        exist(board, i+1, j, word, ind+1);
    board[i][j] = word.charAt(ind);
    return result;
}
}
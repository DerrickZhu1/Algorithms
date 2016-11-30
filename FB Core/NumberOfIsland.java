public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;
 
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
               if (grid[i][j] == '1'){
                  count++;
                  merge(grid, i, j);
               }
            }
        }
        return count;
    }
    public void merge(char[][] grid, int i, int j){
       //validity checking
       if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1)
           return;
 
       // if current cell is water or visited
       if (grid[i][j] != '1') return;
 
       // set visited cell to '0'
       grid[i][j] = '0';
 
       // merge all adjacent land
       merge(grid, i-1, j);
       merge(grid, i+1, j);
       merge(grid, i, j-1);
       merge(grid, i, j+1);
   }
    
}

O(m^2n^2) time complexity
the space complexity is O(4mn) if the function call stack is taken into account. 
In each cell, we recursively call its 4 four neighbors and there are mn cells in total.

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
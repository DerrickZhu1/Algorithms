岛先都改成-1，然后结束计数以后再恢复回来
计算完一次以后用缓存存一下

DFS
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

BFS:
public int numIslands(char[][] grid) {
    int count=0;
    for(int i=0;i<grid.length;i++)
        for(int j=0;j<grid[0].length;j++){
            if(grid[i][j]=='1'){
                bfsFill(grid,i,j);
                count++;
            }
        }
    return count;
}

private void bfsFill(char[][] grid,int x, int y){
    grid[x][y]='0';
    int n = grid.length;
    int m = grid[0].length;
    Queue<Integer> queue = new LinkedList<Integer>();  
    int code = x*m+y;  
    queue.offer(code);  

    while(!queue.isEmpty()) {  
        code = queue.poll();  
        int i = code/m;  
        int j = code%m;  
        if(i>0 && grid[i-1][j]=='1')    //search upward and mark adjacent '1's as '0'.
        {  
            queue.offer((i-1)*m+j);  
            grid[i-1][j]='0';  
        }  
        if(i<n-1 && grid[i+1][j]=='1')  //down
        {  
            queue.offer((i+1)*m+j);  
            grid[i+1][j]='0';  
        }  
        if(j>0 && grid[i][j-1]=='1')  //left
        {  
            queue.offer(i*m+j-1);  
            grid[i][j-1]='0';  
        }  
        if(j<m-1 && grid[i][j+1]=='1')  //right
        {  
            queue.offer(i*m+j+1);  
            grid[i][j+1]='0';  
        }
    } 
}






















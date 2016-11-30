only need to store one killed enemies value for a row and an array of each column;
if current grid value is W, this means previous stored value becomes invalid, you need to recalculate.

public int maxKilledEnemies(char[][] grid) {
    if (grid == null || grid.length == 0 ||  grid[0].length == 0) return 0;
    int max = 0;
    int row = 0;
    int[] col = new int[grid[0].length];
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
            // 直接跳过
            if (grid[i][j] == 'W') continue;
            // 不需要重算
            if (j == 0 || grid[i][j-1] == 'W') {
                 row = killedEnemiesRow(grid, i, j);
            }
            // 如果上一排是‘W', 则需要重算
            if (i == 0 || grid[i-1][j] == 'W'){
                 col[j] = killedEnemiesCol(grid, i, j);
            }
            if (grid[i][j] == '0') {
                max = (row + col[j] > max) ? row + col[j] : max;
            }
        }

    }
    
    return max;
}

//calculate killed enemies for row i from column j
private int killedEnemiesRow(char[][] grid, int i, int j){
    int num = 0;
    while(j <= grid[0].length - 1 && grid[i][j] != 'W'){
        if (grid[i][j] == 'E') num++;
        j++;
    }
    return num;
}
//calculate killed enemies for  column j from row i
private int killedEnemiesCol(char[][] grid, int i, int j){
    int num = 0;
    while(i <= grid.length -1 && grid[i][j] != 'W'){
        if(grid[i][j] == 'E') num++;
        i++;
    }
    return num;
}
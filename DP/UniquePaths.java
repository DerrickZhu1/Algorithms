Climbing Stairs二维版。计算解个数的题多半是用DP。而这两题状态也非常显然，dp[i][j]表示从起点到位置(i, j)的路径总数。DP题目定义好状态后，
接下去有两个任务：找通项公式，以及确定计算的方向。

1. 由于只能向右和左走，所以对于(i, j)来说，只能从左边或上边的格子走下来：
dp[i][j] = dp[i-1][j] + dp[i][j-1]

2. 对于网格最上边和最左边，则只能从起点出发直线走到，dp[0][j] = dp[i][0] = 1

3. 计算方向从上到下，从左到右即可。可以用滚动数组实现。

public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
		if (m == 1 || n == 1) return 1;
		int[][] dp = new int[m][n];
		
		//left column
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}
		//top row
		for (int j = 0; j < n; j++) {
			dp[0][j] = 1;
		}
		//fill up the dp table
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
    }
}

Unique Paths II

与I有两点不同：

1. 当(i, j)有障碍时dp[i][j] = 0
2. dp[0][j]和dp[i][0]未必为1.
dp[0][j] = obstacleGrid[0][j] ? 0 : dp[0][j-1]
dp[i][0] = obstacleGrid[i][0] ? 0 : dp[i-1][0]
3. 当obstacleGrid [0][0] = 1时，return 0

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        
        //flip upper left cell (the start cell): 1 => 0 or 0 => 1
        obstacleGrid[0][0] ^= 1;
        
        //first row: if 1, then 0; otherwise, left cell
        for (int i = 1; i < n; i++)
            obstacleGrid[0][i] = obstacleGrid[0][i] == 1 ? 0 : obstacleGrid[0][i - 1];
        
        //first column: if 1, then 0; otherwise, top cell
        for (int i = 1; i < m; i++)
            obstacleGrid[i][0] = obstacleGrid[i][0] == 1 ? 0 : obstacleGrid[i - 1][0];
            
        //rest: if 1, then 0; otherwise, left cell + top cell
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? 0 : obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                
        //return lower right cell (the end cell)
        return obstacleGrid[m - 1][n - 1];
    }
}









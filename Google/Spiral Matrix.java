[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

[1,2,3,6,9,8,7,4,5]

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> s = new LinkedList<>();
        if (matrix.length == 0) return s;
        int row = matrix.length, col = matrix[0].length;
        int i = 0, j = -1;
    
        while (true) {
            for (int n = 0; n < col; n++)
                s.add(matrix[i][++j]);  // go right
            if (--row == 0) break;
            for (int n = 0; n < row; n++)
                s.add(matrix[++i][j]);  // go down
            if (--col == 0) break;
            for (int n = 0; n < col; n++)
                s.add(matrix[i][--j]);  // go left
            if (--row == 0) break;
            for (int n = 0; n < row; n++)
                s.add(matrix[--i][j]);  // go up
            if (--col == 0) break;
       }
     return s;
    }
}


Given an integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.

public int[][] generateMatrix(int n) {
    int[][] mat = new int[n][n];
    if (n == 0) return mat;
    int count = 1, row = n, col = n;
    int i = 0, j = -1;
    
    while (true) {
        for (int k = 0; k < col; k++)
            mat[i][++j] = count++;  // go right
        if (--row == 0)   break;
        for (int k = 0; k < row; k++)
            mat[++i][j] = count++;  // go down
        if (--col == 0)   break;
        for (int k = 0; k < col; k++)
            mat[i][--j] = count++;  // go left
        if (--row == 0)   break;
        for (int k = 0; k < row; k++)
            mat[--i][j] = count++;  // go up
        if (--col == 0)   break;
     }
    
    return mat;
}









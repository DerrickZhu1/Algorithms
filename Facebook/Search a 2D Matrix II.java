Write an efficient algorithm that searches for a value in an m x n matrix. 
This matrix has the following properties:
Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}

Write an efficient algorithm that searches for a value in an m x n matrix. 
This matrix has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row_num = matrix.length;
	    int col_num = matrix[0].length;
	
	    int begin = 0, end = row_num * col_num - 1;
	
	   while (begin <= end) {
		    int mid = (begin + end) / 2;
		    int mid_value = matrix[mid/col_num][mid%col_num];
		
		   if ( mid_value == target) {
			   return true;
		
		   } else if(mid_value < target) {
			   //Should move a bit further, otherwise dead loop.
			   begin = mid+1;
	       } else {
			  end = mid-1;
		   } 
	  }
	
	   return false;
    }
}


The DP solution proceeds row by row, starting from the first row. Let the maximal rectangle area at row i and column j
be computed by [right(i,j) - left(i,j)]*height(i,j).

All the 3 variables left, right, and height can be determined by the information from previous row, 
and also information from the current row. So it can be regarded as a DP solution. The transition equations are:

left(i,j) = max(left(i-1,j), cur_left), cur_left can be determined from the current row
right(i,j) = min(right(i-1,j), cur_right), cur_right can be determined from the current row
height(i,j) = height(i-1, j) + 1, if matrix[i][j] == '1';
height(i,j) = 0, if matrix[i][j] == '0'

class Solution {public:
int maximalRectangle(vector<vector<char> > &matrix) {
    if(matrix.empty()) return 0;
    int m = matrix.size();
    int n = matrix[0].size();
    int left[n], right[n], height[n];
    fill_n(left,n,0); 
    fill_n(right,n,n); 
    fill_n(height,n,0);
    int maxA = 0;
    for (int i=0; i<m; i++) {
        int cur_left=0, cur_right=n; 
        for (int j = 0; j < n; j++) { // compute height (can do this from either side)
            if(matrix[i][j]=='1') height[j]++; 
            else height[j]=0;
        }
        for (int j = 0; j < n; j++) { // compute left (from left to right)
            if(matrix[i][j]=='1') left[j] = max(left[j],cur_left);
            else {
                left[j] = 0; 
                cur_left = j + 1;
            }
        }
        // compute right (from right to left)
        for (int j = n-1; j >= 0; j--) {
            if (matrix[i][j]=='1') right[j] = min(right[j],cur_right);
            else {right[j] = n; cur_right = j;}    
        }
        // compute the area of rectangle (can do this from either side)
        for(int j = 0; j < n; j++)
            maxA = max(maxA,(right[j]-left[j])*height[j]);
    }
    return maxA;
}

else left[j] = 0  cur_left = j+1
else right[j] = n  cur_right = j

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 6



	



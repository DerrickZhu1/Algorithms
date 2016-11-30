Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. 
You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. 
Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

public int maxCoins(int[] iNums) {
    int[] nums = new int[iNums.length + 2];
    int n = 1;
    for (int x : iNums) if (x > 0) nums[n++] = x;
    nums[0] = nums[n++] = 1;


    int[][] memo = new int[n][n];
    return burst(memo, nums, 0, n - 1);
}

public int burst(int[][] memo, int[] nums, int left, int right) {
    if (left + 1 == right) return 0;
    if (memo[left][right] > 0) return memo[left][right];
    int ans = 0;
    for (int i = left + 1; i < right; i++)
        ans = Math.max(ans, nums[left] * nums[i] * nums[right] 
        + burst(memo, nums, left, i) + burst(memo, nums, i, right));
    memo[left][right] = ans;
    return ans;
}


public class Solution {
    public int maxCoins(int[] nums) {
        int[] num1s = new int[nums.length + 2];
        int n = 1;
        for (int x : nums) if (x > 0) num1s[n++] = x;
        num1s[0] = num1s[n++] = 1;

        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k)
            for (int l = 0; l < n - k; ++l) {
                int r = l + k;
                for (int m = l + 1; m < r; ++m)
                    dp[l][r] = Math.max(dp[l][r], 
                        num1s[l] * num1s[m] * num1s[r] + dp[l][m] + dp[m][r]);
            }
    
        return dp[0][n - 1];
    }
}


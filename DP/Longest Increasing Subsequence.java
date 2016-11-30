dp[x] = max(dp[x], dp[y] + 1) 其中 y < x 并且 nums[x] > nums[y]

维护一个单调序列

遍历nums数组，二分查找每一个数在单调序列中的位置，然后替换之。

public int longestIncreasingSubsequence(int[] nums) {
    int []f = new int[nums.length];
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
        f[i] = 1;
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                 f[i] = f[i] > f[j] + 1 ? f[i] : f[j] + 1;
            }
        }
        if (f[i] > max) {
            max = f[i];
         }
     }
    return max;
}
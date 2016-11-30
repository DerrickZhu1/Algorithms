public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int prev = 0, sum = 0, len = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // 先加
            sum += nums[i];
            while (sum >= s) {
                len = Math.min(len, i - prev + 1);
                sum -= nums[prev++];
            }
         }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}

return len == Integer.MAX_VALUE ? 0 : len;


extends to 2d and find if tangrecle sum = k
class FindSubRect {
    public boolean find(int[][] matrix, int target) {
        for (int right = 0; right < matrix[0].length; right++) {
            int[] rowSum = new int[matrix.length];
            for (int left = right; left >= 0; left--) {
                Set<Integer> sum = new HashSet<>();
                int curSum = 0;
                sum.add(0);
                for (int row = 0; row < matrix.length; row++) {
                    rowSum[row] += matrix[row][left];
                    curSum += rowSum[row];
                    if (sum.contains(curSum - target)) {
                        return true;
                    }
                    sum.add(curSum);
                }
            }
        }
        return false;
    }
}
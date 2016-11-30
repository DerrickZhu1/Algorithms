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

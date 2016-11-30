public static int maxSubArray(int[] A) {
    int maxSoFar = A[0], maxEndingHere = A[0];
    for (int i =1; i < A.length;++i){
    	maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
    	maxSoFar = Math.max(maxSoFar, maxEndingHere);	
    }
    return maxSoFar;
}


public class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = 1, minProd = 1, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
           int temp = maxProd;
           maxProd = Math.max(Math.max(maxProd * nums[i], nums[i]), minProd * nums[i]);
           minProd = Math.min(Math.min(minProd * nums[i], nums[i]), temp * nums[i]);
           max = Math.max(maxProd, max);
           min = Math.min(minProd, min);
        }
        return max;
    }
}
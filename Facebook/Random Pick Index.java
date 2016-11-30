Given an array of integers with possible duplicates, 
randomly output the index of a given target number. 
You can assume that the given target number must exist in the array.

public class Solution {
    int[] nums;
    Random rnd;

    public Solution(int[] nums) {
        this.nums = nums;
        this.rnd = new Random();
    }
    
    public int pick(int target) {
        int result = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target)
                continue;
            if (rnd.nextInt(++count) == 0)  // probability 1/n
                result = i;
        }
        
        return result;
    }
}
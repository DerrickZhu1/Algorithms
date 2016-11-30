From Sorted Array


public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)  
           return 0;  
        int index = 1;  
        for (int i = 1; i < nums.length; i++) {  
            if (nums[i] != nums[i-1]) {  
               nums[index] = nums[i];  
               index++;  
            }  
        }  
        return index;  
    }
}


What if duplicates are allowed at most twice.

public int removeDuplicates(int[] nums) {
    int i = 0;
    for (int n : nums)
        if (i < 2 || n > nums[i-2])
            nums[i++] = n;
    return i;
}
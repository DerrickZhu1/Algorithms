Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithms runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        // find the leftmost match
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            // 先更新lo
            if (nums[mid] < target)    lo = mid + 1;
            else                    hi = mid;
        }

        int start = lo;
        if (nums[lo] != target)    return new int[]{-1, -1};   // no match is found
    
        // find the rightmost match
        hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            // 先更新hi
            if (nums[mid] > target)    hi = mid;
            else                    lo = mid + 1;
        }

        int end = hi;

        if (nums[hi] != target)    end = hi - 1;  // if no match on hi, need to move backward one step
    
       return new int[]{start, end};
    }
}


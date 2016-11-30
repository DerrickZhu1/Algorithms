Given an array of integers, find out whether there are two distinct 
indices i and j in the array such that the difference between nums[i] 
and nums[j] is at most t and the difference between i and j is at most k.

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            int c = nums[i];
            if (set.floor(c) != null && set.floor(c) >= c - t
             || set.ceiling(c) != null && set.ceiling(c) <= c + t) {
               return true;
            } else {
              set.add(c);
              if (i >= k)  set.remove(nums[i - k]);
            }
        }
        return false;
    }
}

O(nlog(k))


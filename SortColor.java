public class Solution {
    public void sortColors(int[] nums) {
        // 0 - red, 1 - while, 2 - blue
        int curr = 0, red = 0, blue = nums.length - 1;
        while (curr <= blue) {
            if (nums[curr] == 0)
               swap(nums, curr++, red++);
            else if (nums[curr] == 2)
               swap(nums, curr, blue--); // Do not forward curr since it might be red now
            else
               curr++;
        }
    }
    private void swap(int[] A, int a, int b) {
         int temp = A[a];
         A[a] = A[b];
         A[b] = temp;
   }
    
}
All elements before the slow pointer (lastNonZeroFoundAt) are non-zeroes.
All elements between the current and slow pointer are zeroes.
public void moveZeroes(int[] nums) {

    int j = 0;
    for(int i = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            j++;
        }
    }
}


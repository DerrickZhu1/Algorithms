public void sortColors(int[] nums) {
    // 0 - red, 1 - while, 2 - blue
    int j = 0, k = nums.length - 1;
    for (int i = 0; i <= k; i++) {
         if (nums[i] == 0)
             swap(nums, i, j++);
         else if (nums[i] == 2)
             swap(nums, i--, k--);
    }
}

private void swap(int[] A, int a, int b) {
    int temp = A[a];
    A[a] = A[b];
    A[b] = temp;
}

Method 1: Same idea with method 2 above. Each time sort the array into three parts:
[all min] [all unsorted others] [all max], then update min and max and 
sort the [all unsorted others] with the same method.



O(n^2): T(n) = T(n - 2) + n

public void sortColors2(int[] colors, int k) {
        int pl = 0;
        int pr = colors.length - 1;
        int i = 0;
        int min = 1, max = k;
        while (min < max) {
            while (i <= pr) {
                if (colors[i] == min) {
                    swap(colors, pl, i);
                    i++;
                    pl++;
                } else if (colors[i] == max) {
                    swap(colors, pr, i);
                    pr--;
                } else {
                    i++;
                }
                // printArray(colors);
            }
            // i = pl;
            // min++;
            // max--;
            i = pl;
            min++;
            max--;
        }
    }


Counting sort

public void sortColors2(int[] colors, int k) {
        int[] count = new int[k];
        for (int color : colors) {
            count[color-1]++;
        }
        int index = 0;
        for (int i = 0; i < k; i++) {
            while (count[i]>0) {
                colors[index++] = i+1;
                count[i]--;
            }
        }
    }






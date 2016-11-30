Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.

Java - Naive Solution

public int countRangeSum(int[] nums, int lower, int upper) {
    int n = nums.length;
    long[] sums = new long[n + 1];
    for (int i = 0; i < n; ++i)
        sums[i + 1] = sums[i] + nums[i];
    int ans = 0;
    for (int i = 0; i < n; ++i)
        for (int j = i + 1; j <= n; ++j)
            if (sums[j] - sums[i] >= lower && sums[j] - sums[i] <= upper)
                ans++;
    return ans;
}

Recall count smaller number after self where we encountered the problem

count[i] = count of nums[j] - nums[i] < 0 with j > i
Here, after we did the preprocess, we need to solve the problem

count[i] = count of a <= S[j] - S[i] <= b with j > i
ans = sum(count[:])

Therefore the two problems are almost the same. We can use the same technique used in that problem to solve this problem. 
One solution is merge sort based; another one is Balanced BST based. The time complexity are both O(n log n).



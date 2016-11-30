Given a sorted positive integer array nums and an integer n, add/patch elements to the array 
such that any number in range [1, n] inclusive can be formed by the sum of some elements in the array. 
Return the minimum number of patches required.

读者不难想到暴力搜索的做法：先穷举每一个不在数组里的数p，再穷举判断p是否可以表示为数组中若干个数的和；如果不能，则把p加入数组中，把答案加一。

然而，这种做法时间复杂度高且实际操作难度大（需要考虑穷举的顺序）。我们不妨先思考一个简单的问题，如果nums数组为空，
那么最少需要多少个数字才能表示1到n之间所有数？相信大家都可以想到一个贪心算法，
即按照1、2、4、8...都顺序添加，每次加入的   数都比之前所有数的总和大1，直到总和大于n。
本题的难点是预先给出了一些数，但这不影响我们的贪心策略：假设nums当前至多可以表示1到m之间的所有数，
加入m+1；直到m大于等于n。


public int minPatches(int[] nums, int n) {
    long sum = 0;
    int ans = 0;
    int index = 0;
    if (nums.length > 0 && nums[0] == 1) {
        sum = 1;
        index = 1;
    }
    while (sum < n) {
        while (index < nums.length && nums[index] <= sum) {
            sum += nums[index];
            index++;
        }

        if (sum < n) {
            if (index < nums.length && nums[index] == sum + 1) 
                index++;
            else {
                 ans++;
            }
            sum = 2 * sum + 1;  // (sum + sum + 1)
        }
    }
    return ans;
}




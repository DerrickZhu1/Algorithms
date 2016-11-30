Given an array of integers, return indices of the two numbers such that 
they add up to a specific target.

public int[] twoSum(int[] nums, int target) {
     if (nums.length < 2  || nums == null)  
        return null;
     Map<Integer, Integer> map = new HashMap<>();
	 for (int i = 0; i < nums.length; i++) {
		  int x = nums[i];
		  if (map.containsKey(target - x)) {
			 return new int[] { map.get(target - x), i };
		  }
		  map.put(x, i);
	 }
	 return null;
}

3Sum
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.
For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

O(n2)
public List<List<Integer>> threeSum(int[] num) {
    Arrays.sort(num);
    List<List<Integer>> res = new LinkedList<>(); 
    for (int i = 0; i < num.length - 2; i++) {
        if (i == 0 || (i > 0 && num[i] != num[i-1])) {
            int lo = i+1, hi = num.length-1, sum = 0 - num[i];
            while (lo < hi) {
                if (num[lo] + num[hi] == sum) {
                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
                    while (lo < hi && num[lo] == num[lo+1]) lo++;
                    while (lo < hi && num[hi] == num[hi-1]) hi--;
                    lo++; hi--;
                } else if (num[lo] + num[hi] < sum) lo++;
                else hi--;
           }
        }
    }
    return res;
}

Arrays.asList(num[i], num[lo], num[hi]);

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        int result = num[0] + num[1] + num[num.length - 1];
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
   } 
}

3Sum Smaller
public int threeSumSmaller(int[] nums, int target) {
    int count = 0;
    Arrays.sort(nums);
    int len = nums.length;
    
    for(int i=0; i<len-2; i++) {
        int left = i+1, right = len-1;
        while(left < right) {
            if(nums[i] + nums[left] + nums[right] < target) {
                count += right-left;
                left++;
            } else {
                right--;
            }
        }
    }
        
    return count;
}

4Sum
public List<List<Integer>> fourSum(int[] num, int target) {
    ArrayList<List<Integer>> ans = new ArrayList<>();
    if (num.length<4) return ans;
    Arrays.sort(num);
    for (int i = 0; i < num.length - 3; i++){
        if (i > 0 && num[i] == num[i-1]) continue;
        for (int j = i+1; j < num.length-2; j++){
            if (j > i+1 && num[j] == num[j-1]) continue;
            int low = j+1, high = num.length-1;
            while (low < high) {
                int sum=num[i]+num[j]+num[low]+num[high];
                if (sum==target) {
                    ans.add(Arrays.asList(num[i], num[j], num[low], num[high]));
                    while(low<high&&num[low] == num[low+1])  low++;
                    while(low<high&&num[high] == num[high-1])  high--;
                    low++;
                    high--;
                }
                else if(sum<target)low++;
                else high--;
            }
        }
    }
    return ans;
}
















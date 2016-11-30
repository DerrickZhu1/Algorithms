Must not contain duplicate subsets.

public class Solution {
    private List<List<Integer>> listSet = new ArrayList<List<Integer>>();
    private List<Integer> list = new ArrayList<Integer>();
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        addUp(nums, 0);
        return listSet;
    }
    private void addUp(int[] nums, int start) {
      listSet.add(new ArrayList<Integer>(list));
      for (int i = start; i < nums.length; i++) {
          list.add(nums[i]);
          addUp(nums, i + 1);
          list.remove(list.size() - 1);
      }
    }
}

Given a collection of integers that might contain duplicates, nums,
return all possible subsets.

public class Solution {
    private List<List<Integer>> listSet = new ArrayList<List<Integer>>();
    private List<Integer> list = new ArrayList<Integer>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        addUp(nums, 0);
        return listSet;
    }
    private void addUp(int[] nums, int start) {
    // if (!listSet.contains(list))         // No need to check duplicate lists!! 
        listSet.add(new ArrayList<Integer>(list));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i - 1] == nums[i]) continue; // skip the duplicated elements (important pruning step to increase speed)!!
            list.add(nums[i]);
            addUp(nums, i + 1);
            list.remove(list.size() - 1);
        }  
    }
}



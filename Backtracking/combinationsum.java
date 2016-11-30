Factor Combinations

public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, new ArrayList<Integer>(), n, 2);
        return result;
    }
    
    public void helper(List<List<Integer>> result, List<Integer> item, int n, int start) {
        if (n <= 1) {
           if (item.size() > 1) {
              result.add(new ArrayList<Integer>(item));
           }
          return;
        }
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                item.add(i);
                helper(result, item, n/i, i);
                item.remove(item.size()-1);
             }
        }
     }
}

Combination Sum
public class Solution {
    private List<List<Integer>> listSet = new ArrayList<List<Integer>>();
    private List<Integer> list = new ArrayList<Integer>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        addUp(candidates, 0, target);
        return listSet;
    }
    private void addUp(int[] candidates, int start, int target) {
         if      (target < 0)    return;
         else if (target == 0) {
        /** if (!listSet.contains(list)) **/    // No need to check duplicate lists!!    
            listSet.add(new ArrayList<Integer>(list));
         } else {
            for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) continue;  // avoid duplicated list: another alternative (command the 3rd line above)
                list.add(candidates[i]);
                addUp(candidates, i, target - candidates[i]);
                list.remove(list.size() - 1);
            }
        }
   } 
}

Combination Sum II   (use once)

public class Solution {
    private List<List<Integer>> listSet = new ArrayList<List<Integer>>();
    private List<Integer> list = new ArrayList<Integer>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        addUp(candidates, 0, target);
        return listSet;
    }
    private void addUp(int[] candidates, int start, int target) {
    if      (target < 0)    return;
    else if (target == 0) {
        /** if (!listSet.contains(list)) **/    // No need to check duplicate lists!!    
            listSet.add(new ArrayList<Integer>(list));
    } else {
        for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;  // avoid duplicated list: another alternative (command the 3rd line above)
            list.add(candidates[i]);
            addUp(candidates, i + 1, target - candidates[i]);   // only modification
            list.remove(list.size() - 1);
        }
    }
  }
}


Find all possible combinations of k numbers that add up to a number n, 
given that only numbers from 1 to 9 can be used and each combination 
should be a unique set of numbers.

Combination Sum III

public class Solution {
    private List<List<Integer>> listSet = new ArrayList<List<Integer>>();
    private List<Integer> list = new ArrayList<Integer>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        addUp(1, k, n);
        return listSet;
    }
    
    private void addUp(int start, int k, int n) {
         if (k < 0 || n < 0) return;
         else if (k == 0 && n == 0) {
             listSet.add(new ArrayList<Integer>(list));
         } else {
             for (int i = start; i <= 9; i++) {
                 list.add(i);
                 addUp(i + 1, k - 1, n - i);
                 list.remove(list.size() - 1);
             }
        }
    }
}


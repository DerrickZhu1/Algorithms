Path Sum II

public class Solution {
    private List<List<Integer>> pathSet = new ArrayList<List<Integer>>();
    private List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        findPathSum(root, sum);
        return pathSet;
    }
    // DFS
    private void findPathSum(TreeNode root, int sum) {
       if (root == null)   return;
       path.add(root.val);
       // root.val == sum
       if (root.left == null && root.right == null && root.val == sum)
              pathSet.add(new ArrayList<Integer>(path));  // need to create a new ArrayList!!
       findPathSum(root.left, sum - root.val);
       findPathSum(root.right, sum - root.val);
       path.remove(path.size() - 1);
   }
}

path.remove(path.size() - 1);
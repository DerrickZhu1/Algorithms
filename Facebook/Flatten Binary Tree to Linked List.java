Flatten Binary Tree to Linked List

         1
        / \
       2   5
      / \   \
     3   4   6

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6


public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        root.left = null;
        
        flatten(left);
        flatten(right);
        
        root.right = left;
        TreeNode cur = root;
        while (cur.right != null) cur = cur.right;
        cur.right = right;
    }
}




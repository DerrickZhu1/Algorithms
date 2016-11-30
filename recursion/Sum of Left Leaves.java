public class Solution {
    public int sumOfLeftLeaves(TreeNode n) {
        if (n == null || (n.left == null && n.right == null)) return 0;
        int l = 0, r = 0;
        if (n.left!=null) l = (n.left.left == null && n.left.right == null) ? n.left.val:sumOfLeftLeaves(n.left);
        if (n.right!=null) r = sumOfLeftLeaves(n.right);
        return l + r;
    }
}





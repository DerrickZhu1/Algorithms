public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
    private boolean isValidBST(TreeNode current, double min, double max) {
        if (current == null) {
            return true;
        }

        // 2147483647 (只有一个点)
        if (current.val <= min || current.val >= max) {
            return false;
        }
        return isValidBST(current.left, min, current.val) && isValidBST(current.right, current.val, max);
	}
}


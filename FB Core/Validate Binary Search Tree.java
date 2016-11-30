public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        // return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean isValidBST(TreeNode current, double min, double max) {
        if (current == null) {
            return true;
        }
        if (current.val <= min || current.val >= max) {
            return false;
        }
        return isValidBST(current.left, min, current.val) && isValidBST(current.right, current.val, max);
	}
}

inorder Traversal

public boolean isValidBST (TreeNode root){
    Stack<TreeNode> stack = new Stack<TreeNode> ();
    TreeNode cur = root ;
    TreeNode pre = null ;           
    while (!stack.isEmpty() || cur != null) {               
        if (cur != null) {
            stack.push(cur);
            cur = cur.left ;
        } else {                
            TreeNode p = stack.pop() ;
            if (pre != null && p.val <= pre.val) {                      
                    return false ;
            }                   
            pre = p ;                       
            cur = p.right ;
        }
    }
    return true ; 
    
}
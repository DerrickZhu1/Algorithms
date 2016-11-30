Implement an iterator over a binary search tree (BST). 
Your iterator will be initialized with the root node of a BST.
Calling next() will return the next smallest number in the BST.

preorder traverse 

public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        pushLeftChildren(root);
    }
    private void pushLeftChildren(TreeNode curr) {
        while (curr != null) {
            stack.add(curr);
            curr = curr.left;
        }
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        //if (!hasNext()) throw new NoSuchElementException("All nodes have been visited");
        
        TreeNode res = stack.pop();
        pushLeftChildren(res.right);
        return res.val;
    }
}
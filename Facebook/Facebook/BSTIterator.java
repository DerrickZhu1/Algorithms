54. LC上的同类题型173和252
public class BSTIterator {
    Stack<TreeNode> inorder = new Stack<>();
    public BSTIterator(TreeNode root) {
        toLeft(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !inorder.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = inorder.pop();
        if (node.right != null) {
            toLeft(node.right);
        }
        return node.val;
    }
    
    private void toLeft(TreeNode root) {
        while (root != null) {
            inorder.push(root);
            root = root.left;
        }
    }
}


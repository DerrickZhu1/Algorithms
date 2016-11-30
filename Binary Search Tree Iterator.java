public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tmpNode = stack.pop();
        pushAll(tmpNode.right);
        return tmpNode.val;
    }
    
    private void pushAll(TreeNode node) {
        for (; node != null; stack.push(node), node = node.left);
    }
    
    while (curr != null) {
            stack.add(curr);
            curr = curr.left;
    }
}

O(h) memory, hasNext() in O(1) time
"in average" O(1) time, which means amortized over all the next() calls.

The average time complexity of next() function is O(1) indeed in your case. 
As the next function can be called n times at most, and the number of right nodes
in self.pushAll(tmpNode.right) function is maximal n in a tree which has n nodes, 
so the amortized time complexity is O(1).

Inorder Successor in BST

Successor
public TreeNode successor(TreeNode root, TreeNode p) {
  if (root == null)
     return null;

  if (root.val <= p.val) {
     return successor(root.right, p);
  } else {
    TreeNode left = successor(root.left, p);
    return (left != null) ? left : root;
  }
}

Predecessor

public TreeNode predecessor(TreeNode root, TreeNode p) {
  if (root == null)
    return null;

  if (root.val >= p.val) {
    return predecessor(root.left, p);
  } else {
    TreeNode right = predecessor(root.right, p);
    return (right != null) ? right : root;
  }
}

public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    TreeNode succ = null;
    while (root != null) {
        if (p.val < root.val) {
            succ = root;
            root = root.left;
        }
        else
            root = root.right;
    }
    return succ;
}




















上面那种方法也可以写成递归形式，写法也比较简洁，但是需要把思路理清，当根节点值小于等于p节点值，
说明p的后继节点一定在右子树中，所以对右子节点递归调用此函数，如果根节点值大于p节点值，
那么有可能根节点就是p的后继节点，或者左子树中的某个节点是p的后继节点，所以先对左子节点递归调用此函数，如果返回空，
说明根节点是后继节点，返回即可，如果不为空，则将那个节点返回

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

题目给定根节点和目标节点。目标节点如果有右节点的情况比较好处理，我们只要返回它的右节点的最左边的节点就行了
（右节点自己没有左节点时则是右节点本身）。如果目标节点没有右节点，说明比目标节点稍大的节点应该在上面，
因为我们知道目标节点的左节点肯定是比目标节点要小的。
那怎么知道目标节点的上面是什么呢？这时就需要从根节点搜索到目标节点了。这里要注意的是，
目标节点的父亲不一定比目标节点大，因为有可能目标节点的是其父亲的右孩子。所以我们要找的上面，
实际上是从目标节点向根节点回溯时，第一个比目标节点大的节点。最差的情况下，如果回溯到根节点还是比目标节点要小的话，
说明目标节点就是整个数最大的数了，这时候返回空。
那怎么实现目标节点向根节点回溯，这里用一个栈就行了，在我们寻找目标节点时，把路径上的节点都压入栈中。


public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while (root != null && root.val != p.val) {
            if (root.val > p.val) {
            	// 边寻边记录
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        if (root == null) {
            return null;
        }
        if (root.right == null) {
            return successor;
        }
        //右子树不为空，所以返回右子树最小的点
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}









public class Solution {
    private Map<Integer, Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = inorder.length;
        if (len < 1)    return null;
    
        for (int i = 0; i < len; i++) {
            inorderMap.put(inorder[i], i);
        }
    
        return buildSubTree(preorder, 0, 0, len - 1);
    }
    
    private TreeNode buildSubTree(int[] preorder, int curr, int start, int end) {
         TreeNode root = new TreeNode(preorder[curr]);
         if (start > end) return null;
         //if (start == end) return root;
         int mid = inorderMap.get(preorder[curr]);
         if (mid > start)
             root.left = buildSubTree(preorder, curr + 1, start, mid - 1);
         if (mid < end)
             root.right = buildSubTree(preorder, curr + mid - start + 1, mid + 1, end);  // mid - start = # of left subtree nodes
    
         return root;
    }
}


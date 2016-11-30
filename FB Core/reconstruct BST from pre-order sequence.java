9. reconstruct BST from pre-order sequence. (preorder BST)
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=192346&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
'######-need iterative method-#########' T(N) = 2 * T(N /2) + O(N) = 4 T(N / 4) + 2 * O(N) = N + lgN * O(N)
'Time complexity: O(NlgN)'
class construcBST {
    public TreeNode constructFromPreorder(int[] preorder) {
        if (preorder.length == 0) {
            return null;
        }
        return constructorHelper(preorder, 0, preorder.length - 1);
    }
    private TreeNode constructorHelper(int[] preorder, int start, int end) {
        TreeNode root = new TreeNode(preorder[start]);
        if (start == end) {
            return root;
        }
        // find the start of right branch
        start++;
        int rightIndex = start;
        while (rightIndex <= end && preorder[rightIndex] < root.val) {
            rightIndex++;
        }
        TreeNode left = null;
        TreeNode right = null;
        if (rightIndex > start) {
            left = constructorHelper(preorder, start, rightIndex - 1);
        }
        if (rightIndex <= end) {
            right = constructorHelper(preorder, rightIndex, end);
        }
        root.left = left;
        root.right = right;
        return root;
    }
}
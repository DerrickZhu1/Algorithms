27. longest PATH(could be the path from leaf to leaf) in binary tree(BT longest path)
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=199567&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
class LongestPathInBT {
    public int findLongest(TreeNode root) {
        Pair length = checkNode(root);
        return length.longestPath;
    }

    // Post order
    private Pair checkNode(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }
        Pair left = checkNode(root.left);
        Pair right = checkNode(root.right);
        // across 是 left.depth + right.depth + 1
        int across = 1 + left.depth + right.depth;
        int longestPath = Math.max(across, Math.max(left.longestPath, right.longestPath));
        int depth = Math.max(left.depth, right.depth) + 1;
        return new Pair(depth, longestPath);
    }

    class Pair {
        int depth;
        int longestPath;
        public Pair(int depth, int longestPath) {
            this.depth = depth;
            this.longestPath = longestPath;
        }
    }
}


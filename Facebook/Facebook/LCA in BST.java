50. LCA in BST.输入是两个value,不是node.瞬秒，无bug. Follow up是统计问题，如果这两个值是随机从这颗树里面sample,问我的算法平均需要几次比较就可以得出结果
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=176941&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

#LCA BST lowest common Ancester binary Search Tree
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	if (root == null) return null;
    if (root.val > Math.max(p.val, q.val)) {
        return lowestCommonAncestor(root.left, p, q);
    }
    else if (root.val < Math.min(p.val, q.val)) {
        return lowestCommonAncestor(root.right, p, q);
    }
    return root;
}


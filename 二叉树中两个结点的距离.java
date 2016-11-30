//返回node节点在root中的第几层，-1表示没有在root子树下找到
    public static int findLevel(Node root, int node){
        if(root == null) return -1;
        if(root.key == node) return 0;
        //先在左子树查找
        int level = findLevel(root.left, node);
        //左子树没有找到则到右子树查找
        if(level == -1){
           level = findLevel(root.right, node);
        }
        if(level != -1)
            return level+1;
        return -1;
    }

    public static Node findLCA(Node root, int node1,int node2) {

        if(root == null) return null;
        //找到两个节点中的一个就返回
        if(root.key == node1 || root.key == node2){
            return root;
        }
 
        //分别在左右子树查找两个节点
        Node left_lca = findLCA(root.left, node1, node2);
        Node right_lca = findLCA(root.right, node1, node2);
 
        if (left_lca != null && right_lca != null){
            //此时说明，两个节点肯定是分别在左右子树中，当前节点比为LCA
            return root;
        }
        return left_lca != null ? left_lca : right_lca;
    }

Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2*Dist(root, lca) 





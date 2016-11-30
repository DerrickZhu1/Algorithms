Populating Next Right Pointers in Each Node
复制root

public class Solution {
    public void connect(TreeLinkNode root) {

        TreeLinkNode level_start = root;

        while (level_start != null) {
            TreeLinkNode cur = level_start;
            // current level
            while (cur != null) {
                if (cur.left != null) cur.left.next = cur.right;
                // .next.left 可能没有
                if (cur.right != null && cur.next != null) cur.right.next = cur.next.left;
                
                cur = cur.next;
            }
            // move to next level
            level_start = level_start.left;
        }
    }
}

What if the given tree could be any binary tree?

        1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL



public class Solution {
    public void connect(TreeLinkNode root) {
        
        while(root != null){
            TreeLinkNode tempChild = new TreeLinkNode(0);
            TreeLinkNode currentChild = tempChild;

            while(root!=null){
                if(root.left != null) { currentChild.next = root.left; currentChild = currentChild.next;}
                if(root.right != null) { currentChild.next = root.right; currentChild = currentChild.next;}
                root = root.next;
            }

            root = tempChild.next;
        }
    }
}

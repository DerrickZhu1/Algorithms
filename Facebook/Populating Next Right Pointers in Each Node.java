Populating Next Right Pointers in Each Node
复制root

public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode level_start=root;
        while (level_start!=null) {
            TreeLinkNode cur = level_start;
            // current level
            while (cur!=null) {
                if (cur.left!=null) cur.left.next = cur.right;
                if (cur.right!=null && cur.next!=null) cur.right.next = cur.next.left;
                
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


//based on level order traversal
public void connect(TreeLinkNode root) {

    TreeLinkNode head = null; //head of the next level
    TreeLinkNode prev = null; //the leading node on the next level
    TreeLinkNode cur = root;  //current node of current level

    while (cur != null) {
            
        while (cur != null) { //iterate on the current level
            // left child
            if (cur.left != null) {
                if (prev != null) {
                    prev.next = cur.left;
                } else {
                    // set head of next level
                    head = cur.left;
                }
                prev = cur.left;
            }
            // right child
            if (cur.right != null) {
                if (prev != null) {
                    prev.next = cur.right;
                } else {
                    head = cur.right;
                }
                prev = cur.right;
            }
            //move to next node
            cur = cur.next;
        }
            
        //move to next level
        cur = head;
        head = null;
        prev = null;
  }
}




root 可以变
public void connect(TreeLinkNode root) {
    TreeLinkNode dummyHead = new TreeLinkNode(0);
    TreeLinkNode pre = dummyHead;
    while (root != null) {
      if (root.left != null) {
        pre.next = root.left;
        pre = pre.next;
      }
      if (root.right != null) {
        pre.next = root.right;
        pre = pre.next;
      }
      root = root.next;
      if (root == null) {
        pre = dummyHead;
        root = dummyHead.next;
        dummyHead.next = null;
      }
    }
}















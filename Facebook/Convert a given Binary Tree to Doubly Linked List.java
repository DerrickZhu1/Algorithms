Given a Binary Tree (Bt), convert it to a Doubly Linked List(DLL). 
The left and right pointers in nodes are to be used as previous and next pointers respectively in converted DLL. 
The order of nodes in DLL must be same as Inorder of the given Binary Tree. 
The first node of Inorder traversal (leftmost node in BT) must be head node of the DLL.

Node bintree2listUtil(Node node) {
    // Base case
    if (node == null)
        return node;
  

1. If left subtree exists, process the left subtree
…..1.a) Recursively convert the left subtree to DLL.
…..1.b) Then find inorder predecessor of root in left subtree (inorder predecessor is rightmost node in left subtree).
…..1.c) Make inorder predecessor as previous of root and root as next of inorder predecessor.

    // Convert the left subtree and link to root
    if (node.left != null) {
        // Convert the left subtree
        Node left = bintree2listUtil(node.left);
  
        // Find inorder predecessor. After this loop, left
        // will point to the inorder predecessor

        // left 在中间
        for (; left.right != null; left = left.right);
  
        // Make root as next of the predecessor
        left.right = node;                  left -> node
  
        // Make predecssor as previous of root
        node.left = left;
    }
  
2. If right subtree exists, process the right subtree (Below 3 steps are similar to left subtree).
…..2.a) Recursively convert the right subtree to DLL.
…..2.b) Then find inorder successor of root in right subtree (inorder successor is leftmost node in right subtree).
…..2.c) Make inorder successor as next of root and root as previous of inorder successor.

    // Convert the right subtree and link to root
    if (node.right != null) {
        // Convert the right subtree
        Node right = bintree2listUtil(node.right);
  
        // Find inorder successor. After this loop, right
        // will point to the inorder successor
        for (; right.left != null; right = right.left);
  
        // Make root as previous of successor
        right.left = node;                    node -> right
  
        // Make successor as next of root
        node.right = right;
    }
  
        return node;
}

Node bintree2list(Node node) {
    // Base case
    if (node == null)
        return node;
  
    // Convert to DLL using bintree2listUtil()
    node = bintree2listUtil(node);
  
    // bintree2listUtil() returns root node of the converted
    // DLL.  We need pointer to the leftmost node which is
    // head of the constructed DLL, so move to the leftmost node
    while (node.left != null)
        node = node.left;
  
    return node;
}

1) Fix Left Pointers: In this step, we change left pointers to point to previous nodes in DLL. 
The idea is simple, we do inorder traversal of tree. In inorder traversal, we keep track of previous visited node
and change left pointer to the previous node. See fixPrevPtr() in below implementation.

2) Fix Right Pointers: The above is intuitive and simple. How to change right pointers to point to next node in DLL? 
The idea is to use left pointers fixed in step 1. We start from the rightmost node in Binary Tree (BT). 
The rightmost node is the last node in DLL. Since left pointers are changed to point to previous node in DLL,
we can linearly traverse the complete DLL using these pointers. The traversal would be from last to first node.
While traversing the DLL, we keep track of the previously visited node and change the right pointer to the previous node. 





















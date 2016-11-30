Pre-order: root-left-right
Use a Stack: Time ~ O(N), Space ~ O(N)
先找到最左节点，然后一层层往上返回，没返回一层节点，要进入其右子树遍历（重复该过程)。

// root-left-right
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null)   return list;
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;
    // curr 可以没有
    while (curr != null) {
        list.add(curr.val);
        stack.push(curr);
        curr = curr.left;
    }
        
    while (!stack.isEmpty()) {
        curr = stack.pop();
        curr = curr.right;
        while (curr != null) {
            list.add(curr.val);
            stack.push(curr);
            curr = curr.left;
        }
    }
        
    return list;
}

In-order : left-root-right
程序结构和pre-order几乎是一致的，仅是 list.add(curr.val) 的位置不同。
// left-root-right
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)   return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        
        while (!stack.isEmpty()) {
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
        }
        return list;
    }


Post-order: left-right-root
先用mirrored preorder：root-right-left
然后再reverse整个结果：left-right-root

// left-right-root
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)   return list;
        Stack<TreeNode> stackBack = new Stack<>();  // mirrored preorder
        Stack<Integer> stack = new Stack<>();       // store mirrored preorder results
        TreeNode curr = root;
        
        while (curr != null) {
            stack.push(curr.val);
            stackBack.push(curr);
            curr = curr.right;
        }
        
        while (!stackBack.isEmpty()) {
            curr = stackBack.pop();
            curr = curr.left;
            while (curr != null) {
                stack.push(curr.val);
                stackBack.push(curr);
                curr = curr.right;
            }
        }
        
        // reverse: root-left-right (preoder) => right-left-root (postorder)
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }


























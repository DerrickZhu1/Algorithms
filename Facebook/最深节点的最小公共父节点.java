dfs遍历，返回的时候返回lca和depth，每个node如果有大于一个子节点的depth相同就返回这个node，
如果有一个子节点depth更深就返回这个子节点lca，这个o(n)就可以了

http://www.1point3acres.com/bbs/thread-148413-1-1.html

TreeNode* findCommonAncestorOfDeepest(TreeNode *root) {
    if(!root || root->children.empty()) return NULL;
    int curLongestPath = 0, countOfLongestLength = 0;
    TreeNode *node = NULL;
    for(auto kid : root->children) 
        TreeNode *temp = findCommonAncestorOfDeepest(kid);
        if(temp == NULL) continue;
        else if(temp->longestPath > curLongestPath) 
            curLongestPath = temp->longestPath;
            node = temp;
            countOfLongestLength = 1;
        } else if(temp->longestPath == curLongestPath) countOfLongestLength++;
    }
    if (countOfLongestLength > 1) {
        root->longestPath = node->longestPath + 1;
        return root;
    } else if(countOfLongestLength == 1) {
        node->longestPath++;
        return node;
    } else if(countOfLongestLength == 0) {
        root->longestPath = 2;
        return root;
    }
}



用的是level traversal,找出最深层的head和tail节点，用一个map来track 节点到父节点的映射。
如果head 和tail相等，说明最深层就一个节点，如果不等，分别从map里向parent节点搜索，知道发现一个公共的节点即为LCA。
public int lcaBFS(TreeNode root) 
        if (root == null)        return -1;
        //<node -> parent node>. from: 1point3acres.com/bbs 
        Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();

        TreeNode head = null, tail = null;        // the head and tail node in a level
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        map.put(root, null);
        while(!que.isEmpty()) {
                head = null; tail = null;
                int sz = que.size();
                while(sz-- > 0) {
                       TreeNode curr = que.poll();
                       if(head == null)        head = curr;
                       if(sz == 0)        tail = curr;.1point3acres缃�
                       if(curr.left != null) {
                             map.put(curr.left, curr);. from: 1point3acres.com/bbs 
                             que.offer(curr.left);. 1point3acres.com/bbs
                       }
                       if(curr.right != null) {
                            map.put(curr.right, curr);
                            que.offer(curr.right);
                        }
                }
        }

        while (head != tail) {
                head = map.get(head); 鏉ユ簮涓€浜�.涓夊垎鍦拌鍧�. 
                tail = map.get(tail);. visit 1point3acres.com for more.
        }
        return head.val;
}
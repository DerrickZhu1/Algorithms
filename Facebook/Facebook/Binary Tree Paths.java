public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<String>();
        if (root == null){
           return ret;
        }
        dfs(root, new StringBuilder(), ret);
        return ret;
    }
    public void dfs(TreeNode root, StringBuilder sb, List<String> ret) {
        if (root.left == null && root.right == null){
            sb.append(root.val);
            ret.add(sb.toString());
            return;
        }
        sb.append(root.val);
        sb.append("->");
        if (root.left != null) {
           dfs(root.left, new StringBuilder(sb), ret);
        }
        if (root.right != null) {
           dfs(root.right, new StringBuilder(sb), ret);
        }
    }
}

print path to leaf (BT path leaf)

iterative method
private List<String> findPath(TreeNode root) {
    List<String> result = new ArrayList<>();
    if (root == null) {
        return result;
    }
    Stack<Pair> stack = new Stack<>();
    stack.push(new Pair(root, ""));
    while (!stack.isEmpty()) {
        Pair pair = stack.pop();
        TreeNode node = pair.node;
        String path = pair.path + "->" + Integer.toString(node.val);
        if (node.left == null && node.right == null) {
            result.add(path.substring(2));
        }
        if (node.left != null) {
            stack.push(new Pair(node.left, path));
        }
        if (node.right != null) {
            stack.push(new Pair(node.right, path));
        }
    }
}
    
class Pair {
    TreeNode node;
    String path;
    public Pair(TreeNode node, String path) {
        this.node = node;
        this.path = path;
    }
}



Word Break II
public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        int n = s.length();
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        for (int i = 1; i <= n; i++)
            for (int j = 0; j < i; j++)
                if (f[j] == true && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
        List<String> listSet = new ArrayList<>();
        if (f[n])   dfs(s, 0, wordDict, new StringBuilder(), listSet);
        return listSet;
    }
    // DFS
    private void dfs(String s, int j, Set<String> wordDict, StringBuilder str, List<String> listSet) {
        if (j == s.length()) {
           listSet.add(str.toString());
        } else {
           for (int i = j + 1; i <= s.length(); i++) {
              if (wordDict.contains(s.substring(j, i))) {
                int len = str.length();
                if (len != 0)   str.append(" ");
                str.append(s.substring(j, i));
                dfs(s, i, wordDict, str, listSet);
                str.delete(len, str.length());
              }
           }
        }
   }
}

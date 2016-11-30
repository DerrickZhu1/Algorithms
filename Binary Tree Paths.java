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


public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(res, root, sb);
        return res;
}
    
private void helper(List<String> res, TreeNode root, StringBuilder sb) {
    if (root == null) {
        return;
    }
    int len = sb.length();
    sb.append(root.val);
    if (root.left == null && root.right == null) {
        res.add(sb.toString());
    } else {
        sb.append("->");
        helper(res, root.left, sb);
        helper(res, root.right, sb);
    }
    sb.setLength(len);
}

Letter Combinations of a Phone Number

public class Solution {
    private static final Map<Character, Character[]> map = new HashMap<Character, Character[]>() {{
    put('2', new Character[]{'a', 'b', 'c'});
    put('3', new Character[]{'d', 'e', 'f'});
    put('4', new Character[]{'g', 'h', 'i'});
    put('5', new Character[]{'j', 'k', 'l'});
    put('6', new Character[]{'m', 'n', 'o'});
    put('7', new Character[]{'p', 'q', 'r', 's'});
    put('8', new Character[]{'t', 'u', 'v'});
    put('9', new Character[]{'w', 'x', 'y', 'z'});
    }};
    public List<String> letterCombinations(String digits) {
        List<String> set = new ArrayList<>();
        if (!digits.isEmpty())  addUp(0, digits, new StringBuilder(), set);
         return set;
    }
    private void addUp(int start, String digits, StringBuilder str, List<String> set) {
        if (str.length() == digits.length())    set.add(str.toString());
        else {
            for (int i = start; i < digits.length(); i++) {
                for (char c : map.get(digits.charAt(i))) {
                    str.append(c);
                    addUp(i + 1, digits, str, set);
                    str.deleteCharAt(str.length() - 1);
                }
            }
        }
    }
}



public List<String> binaryTreePaths(TreeNode root) {
    List<String> answer = new ArrayList<String>();
    if (root != null) searchBT(root, "", answer);
    return answer;
}
private void searchBT(TreeNode root, String path, List<String> answer) {
    if (root.left == null && root.right == null) answer.add(path + root.val);
    if (root.left != null) searchBT(root.left, path + root.val + "->", answer);
    if (root.right != null) searchBT(root.right, path + root.val + "->", answer);
}





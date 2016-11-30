public List<String> generateParenthesis(int n) {
    List<String> list = new ArrayList<>();
    addUp(n, 0, 0, new StringBuilder(), list);
    return list;
}
private void addUp(int n, int left, int right, StringBuilder str, List<String> list) {
    if (left == n) {
        while (right < n) {
            str.append(')');
            right++;
        }
        list.add(str.toString());
    } else if (left == right) { // the parenthese in str are pairs, only add '('
        addUp(n, left + 1, right, str.append('('), list);
    } else { // the parenthese in str are not pairs, we can either add '(' or ')'
        // try to add '('
        int len = str.length();
        addUp(n, left + 1, right, str.append('('), list);
        // try to add ')'
        str.delete(len, str.length()); // remove the parenthese generated in the previous line
        addUp(n, left, right + 1, str.append(')'), list);
    }
}

Since the depth of this tree is (obviously) at most 2count,
the space complexity is O(count)

Since every function call can either add a ( or a ), 
the time complexity is at most O(2^number of function calls) 
= O(2^2count).

But, since the calls are conditional,
the time complexity ends up being less,
more specifically, it appears to be around O(2^2count/count)




Longest Valid Parentheses
Given a string containing just the characters '(' and ')', 
find the length of the longest valid (well-formed) parentheses substring.
For "(()", the longest valid parentheses substring is "()", which has length = 2.

1. First Solution
Scan the string from beginning to end.
If current character is '(',
push its index to the stack. If current character is ')' and the
character at the index of the top of stack is '(', we just find a
matching pair so pop from the stack. Otherwise, we push the index of
')' to the stack.
After the scan is done, the stack will only
contain the indices of characters which cannot be matched. Then
lets use the opposite side - substring between adjacent indices
should be valid parentheses.
If the stack is empty, the whole input
string is valid. Otherwise, we can scan the stack to get longest
valid substring as described in step 3.

public int longestValidParentheses(String s) {
    Stack<Integer> stack = new LinkedList<>();
    int result = 0;
    stack.push(-1);
    for (int i = 0; i < s.length(); i++) {
    	// > 1
        if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '(') {
            stack.pop();
            result = Math.max(result, i - stack.peek());
        } else {
            stack.push(i);
        }
    }
    return result;
}


2. If s[i] is '(', set longest[i] to 0, because any string end with '(' cannot be a valid one.
Else if s[i] is ')'
    If s[i-1] is '(', longest[i] = longest[i-2] + 2

    Else if s[i-1] is ')' and s[i-longest[i-1]-1] == '(', longest[i] = longest[i-1] + 2 + longest[i-longest[i-1]-2]



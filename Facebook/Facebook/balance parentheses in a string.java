5. balance parentheses in a string
例子：
"(a)()" -> "(a)()"
"((bc)" -> "(bc)"
")))a((" -> "a"
"(a(b)" ->"(ab)" or "a(b)"

Note: balance的意思就是把原来string里unpaired的括号变成paired的形式。如果有多个可能的结果， 比如上述最后一种情况，我们就只需要输出一个对的结果即可，所以这点简化了题目的难度。
感受： 遍历string， 用一个stack存储每个open parenthesis的index，也就是'('的index, 每当遇到closed parenthesis就执行一次pop操作。
注意两种unbalanced的情况：
1. 出现多余的')':
    对应情况就是stack为空，但遇到了一个')'。
2. 出现多余的'(':
    对应情况就是遍历结束，stack未空

解决这两种情况即可。
对于java，我们需要把string转换成char array来做，因为在java中string is immutable.
follow-up:
Q：分析复杂度，问怎么不用stack来做
A：想了一会儿，感觉用two-pointer可行，一个指头， 一个指尾， 头index找'('， 找到就移动尾index找')'。
面试官虽然没说，但一开始反应有点惊讶，说明他头脑里准备的是另一个解法。这里就请各位大神不吝赐教了，你们的解法是什么
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=192179&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

// Use two loop to do this. First loop traverse from left to right, use a counter to count the valid 
// parenthese, meet '(' +1, meet ')' if count > 0 -1, else delete this ')'
// then all the invalid ')' will be deleted
// Second loop traverse from right to left. also use a counter to count valid parenthese
// meet ')' +1....
// Then all the invalid '(' will be deleted.

'Time complexity: O(n), space complexity: O(n)'
class balanceParentheses {
    public String findBalanceParentheses(String input) {
        String result = deleteCloseParenthes(input);
        // deleteOpenParenthes(result);
        result = deleteOpenParenthes(result);
        return result;
    }

    private String deleteCloseParenthes(String input) {
        int count = 0;
        StringBuilder result = new StringBuilder();
        for (char letter : input.toCharArray()) {
            result.append(letter);
            if (letter == '(') {
                count++;
            }
            else if (letter == ')') {
                if (count > 0) {
                    count--;
                }
                else {
                    result.deleteCharAt(result.length() - 1);
                }
            }
        }
        return result.toString();
    }

    private String deleteOpenParenthes(String input) {
        int count = 0;
        StringBuilder result = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            char letter = input.charAt(i);
            result.append(letter);
            if (letter == ')') {
                count++;
            }
            else if (letter == '(') {
                if (count > 0) {
                    count--;
                }
                else {
                    result.deleteCharAt(result.length() - 1);
                }
            }
        }
        return result.reverse().toString();
    }
}








Given a non-negative integer num represented as a string, remove k digits
from the number so that the new number is the smallest possible.

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. 
Note that the output must not contain leading zeroes.

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

使得栈中的数字尽可能保持递增顺序。
这道题让我们将给定的数字去掉k位，要使得留下来的数字最小，这题跟LeetCode上之前那道Create Maximum Number有些类似，
可以借鉴其中的思路，如果n是num的长度，我们要去除k个，那么需要剩下n-k个，我们开始遍历给定数字num的每一位，
对于当前遍历到的数字c，进行如下while循环，如果res不为空，且k大于0，且res的最后一位大于c，那么我们应该将res的最后一位移去，
且k自减1。当跳出while循环后，我们将c加入res中，最后我们将res的大小重设为n-k。根据题目中的描述，
可能会出现"0200"这样不符合要求的情况，所以我们用一个while循环来去掉前面的所有0，然后返回时判断是否为空，为空则返回“0”




public String removeKdigits(String num, int k) {
    int len = num.length();
    //corner case
    if (k == len)        
        return "0";
            
    Stack<Character> stack = new Stack<>();
    int i = 0;
    // 保证 n - k
    while (i < num.length()) {
        //whenever meet a digit which is less than the previous digit, discard the previous one
        while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
            stack.pop();
            k--;
        }
        stack.push(num.charAt(i));
        i++;
    }
        
    // corner case like "1111"
    while (k>0) {
        stack.pop();
        k--;            
    }
        
    //construct the number from the stack
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty())
        sb.append(stack.pop());
    sb.reverse();
        
    //remove all the 0 at the head
    while (sb.length() > 1 && sb.charAt(0) == '0')
        sb.deleteCharAt(0);
    return sb.toString();
}
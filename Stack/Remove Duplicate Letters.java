public class Solution {
    public String removeDuplicateLetters(String s) {
        if (s == null ||s.length() == 0)
            return s;
            
        // 记录每个字符出现的次数    
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        
        // 找出当前最小字符
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos))
                pos = i;
            
            // 避免无字符可用
            if (--cnt[s.charAt(i) - 'a'] == 0)
                break;
        }
        
        // 除去字符串中已经append的字符的所有重复值
        return s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
}


Given a string which contains only lowercase letters, remove duplicate letters so that 
every letter appear once and only once. You must make sure your result is the smallest in
lexicographical order among all possible results.

time: O(kn), space: O(k), k表示原字符串中unique字符的个数

方法二
其实跟上个方法差不多，但是可以优化下，用stack的话，最多每个字符过两遍就可以了。
读字符的过程中，把字符存到stack里，当发现stack之前存的字符中比当前字符大而且频率还大于0就可以把那个字符pop出去。
类似这种题目都可以用stack解决。基本思想就是在一定的限制条件下pop出比当前选择差的元素。

public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freqs = new int[256];
        
        // 统计字符频率
        for (int i = 0; i < s.length(); i++) {
            freqs[s.charAt(i)]++;
        }

        boolean[] visited = new boolean[256]; // 用来标记存在stack里的字符
        Stack<Character> stack = new Stack<>();    
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freqs[c]--;
            if (visited[c]) continue;

            // pop出stack当中比当前字符大但后面还存在的的字符，
            while (!stack.isEmpty() && stack.peek() > c && freqs[stack.peek()] > 0) {
                visited[stack.pop()] = false;
            }
            stack.push(c);
            visited[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
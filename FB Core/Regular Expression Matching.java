'.' Matches any single character.
'*' Matches zero or more of the preceding element.

Preceding element

isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true

关键在于如何处理这个'*'号。

状态：和Mininum Edit Distance这类题目一样。
dp[i][j]表示s[0:i-1]是否能和p[0:j-1]匹配。

递推公式：由于只有p中会含有regular expression，所以以p[j-1]来进行分类。

p[j-1] != '.' && p[j-1] != '*'：dp[i][j] = dp[i-1][j-1] && (s[i-1] == p[j-1])

p[j-1] == '.'：dp[i][j] = dp[i-1][j-1]

而关键的难点在于 p[j-1] = '*'。由于星号可以匹配0，1，乃至多个p[j-2]。
1. 匹配0个元素，即消去p[j-2]，此时p[0: j-1] = p[0: j-3]
dp[i][j] = dp[i][j-2]

2. 匹配1个元素，此时p[0: j-1] = p[0: j-2]
dp[i][j] = dp[i][j-1]

3. 匹配多个元素，此时p[0: j-1] = { p[0: j-2], p[j-2], ... , p[j-2] }
dp[i][j] = dp[i-1][j] && (p[j-2]=='.' || s[i-2]==p[j-2])



33. LeetCode regular expression matching

public boolean isMatch(String s, String p) {
    boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
    match[0][0] = true;// If s and p are "", isMathch() returns true;
    for (int i = 0; i <= s.length(); i++) {
        for (int j = 1; j <= p.length(); j++) {// j starts from 1, since dp[i][0] is false when i!=0;
            if (p.charAt(j - 1) != '*') {
            // The last character of s and p should match;
            // And, dp[i-1][j-1] is true;
                match[i][j] = i > 0 && match[i - 1][j - 1] && 
                (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.');
            }
            else {
            // Two situations:
            // (1) dp[i][j-2] is true, and there is 0 preceding element of '*';
            // (2) The last character of s should match the preceding element of '*';
            //     And, dp[i-1][j] should be true;
                match[i][j] = match[i][j - 2] || (匹配0个)
                                i > 0 && match[i - 1][j] && 
                                (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.');
            }
        }
    }
    return match[s.length()][p.length()];
}

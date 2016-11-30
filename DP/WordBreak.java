public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        // d[i]: s[0..i-1] is breakable
        // d(i) = d(j) && s[j, i], j = 0..i-1
        int n = s.length();
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        
        for (int i = 1; i <= n; i++)
            for (int j = 0; j < i; j++)
                if (f[j] == true && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
        return f[s.length()];
    }
}



public int numDecodings(String s) {
    if(s == null || s.length() == 0) {
            return 0;
    }
    int n = s.length();
    int[] dp = new int[n+1];
    dp[0] = 1;
    dp[1] = s.charAt(0) != '0' ? 1 : 0;
    for(int i = 2; i <= n; i++) {
        int first = Integer.valueOf(s.substring(i-1, i));
        int second = Integer.valueOf(s.substring(i-2, i));
        if(first >= 1 && first <= 9) {
            dp[i] += dp[i-1];  
        }
        if(second >= 10 && second <= 26) {
            dp[i] += dp[i-2];
        }
    }
    return dp[n];
}

public int numDecodings(String s) {
    if (s.length() == 0 || s.charAt(0) == '0') return 0;
    char[] c = s.toCharArray();
    // r2: decode ways of s[i-2] , r1: decode ways of s[i-1] 
    int r1 = 1, r2 = 1;
    
    for (int i = 1; i < c.length; i++) {
    // zero voids ways of the last because zero cannot be used separately
        if (c[i] == '0') r1 = 0;

        // possible two-digit letter, so new r1 is sum of both while new r2 is the old r1
        if (c[i - 1] == '1' || c[i - 1] == '2' && c[i] <= '6') {
            r1 = r2 + r1;
            r2 = r1 - r2;
         }

         // one-digit letter, no new way added
        else {
            r2 = r1;
        }
    }

    return r1;
}






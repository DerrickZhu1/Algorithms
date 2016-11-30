Decode ways
// Use a array to record how many ways we can decode in this number
// Traverse from the tail to head which could handle the situation "0"
// Always take two digits, if the number <= 26 
// Then count[i] = count[i + 1] + count[i + 2], means we can decode as one letter or two letters
// else count[i] = count[i + 1], means we can only decode as one letter
'space complexity:O(n)'

'A' -> 1
'B' -> 2
...
'Z' -> 26

"12", it could be decoded as "AB" (1 2) or "L" (12).

public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;
        
        int[] memo = new int[n+1];
        memo[n]  = 1;
        memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;
        
        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') continue;
            else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];
        
        return memo[0];
    }
}


Inplace way
'space complexity: O(1)'
public int numDecodings(String s) {
    int last = 0;
    int secondLast = 1;
    if (s.length() == 0) {
        return 0;
    }
    if (s.charAt(s.length() - 1) != '0') {
        last = 1;
    }
    for (int i = s.length() - 2; i >= 0; i--) {
        if (s.charAt(i) == '0') {
            secondLast = last;
            last = 0;
            continue;
        }
        int number = Integer.parseInt(s.substring(i, i + 2));
        if (number <= 26) {
            int temp = last;
            last = last + secondLast;
            secondLast = temp;
        }
        else {
            secondLast = last;
        }
    }
    return last;
}


Output the result of all decode string
'Time complexity: O(1.6 ^ n)'
class Decode {
    public List<String> decode(String num) {
        List<String> result = new ArrayList<>();
        helper(result, 0, num, "");
        return result;
    }

    private void helper(List<String> result, int pos, String num, String way) {
        if (pos == num.length()) {
            result.add(way);
            return;
        }
        String digits = num.substring(pos, pos + 1);
        int number = Integer.parseInt(digits);
        if (number == 0) {
            return;
        }
        helper(result, pos + 1, num, way + (char)(number + 'A' - 1));
        if (pos < num.length() - 1) {
            String digits2 = num.substring(pos, pos + 2);
            int number2 = Integer.parseInt(digits2);
            if (number <= 26) {
                helper(result, pos + 2, num, way + (char)(number2 + 'A' - 1));
            }
        }
    }
}




public class Solution {
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
}










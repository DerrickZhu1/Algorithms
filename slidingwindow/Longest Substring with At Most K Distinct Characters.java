Given a string, find the length of the longest substring T that contains at most k distinct characters.

For example, Given s = “eceba” and k = 2,

T is "ece" which its length is 3.


// k distinct chars
public int lengthOfLongestSubstringKDistinct(String s, int k) {
    int[] count = new int[256]; // ASCII
    int start = 0, numDistinct = 0, maxLen = 0;
    for (int i = 0; i < s.length(); i++) {
        if (count[s.charAt(i)] == 0) numDistinct++;
        count[s.charAt(i)]++;
        
        while (numDistinct > k) {
            count[s.charAt(start)]--;
            if (count[s.charAt(start)] == 0) numDistinct--;
            start++;
        }
        
        maxLen = Math.max(i - start + 1, maxLen);
    }
    return maxLen;
}


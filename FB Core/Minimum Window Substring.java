S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

public class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length())  return "";
    
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
             char c = t.charAt(i);
             if (!map.containsKey(c))    map.put(c, 1);
             else                        map.put(c, map.get(c) + 1);
        }
    
        int count = 0, prev = 0, minStart = 0, minLen = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
              char currChar = s.charAt(i);
              if (map.containsKey(currChar)) {    // if currChar exists in T
                    // record currChar (when all T's chars are found, all map's value <= 0)
                    map.put(currChar, map.get(currChar) - 1);
                   // stop adding length (count) if we have more currChar's than T does (map's value < 0)
                   if (map.get(currChar) >= 0)  count++;
            
                   // S[prev, i] contains all T's chars, now shrink the left end (prev)
                   while (count == t.length()) {
                        char prevChar = s.charAt(prev);
                        if (map.containsKey(prevChar)) {   // if prevChar exists in T
                            map.put(prevChar, map.get(prevChar) + 1); // recover map by adding the value back
                            if (map.get(prevChar) > 0) {   // S[pre, i] is the min substring ending at i
                                if (minLen > i - prev + 1) {
                                   minLen = i - prev + 1;
                                   minStart = prev;
                                }
                                count--;    // reduce count to end the while loop
                            }
                        }
                        prev++;
                    }
             }
        }
    
       if (minLen == Integer.MAX_VALUE)    return "";
       else    return s.substring(minStart, minStart + minLen);
    }
}
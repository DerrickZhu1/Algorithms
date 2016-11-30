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

Output only one result
// Use DFS
'Time complexity: O(2^(n/k))'
class WordBreak {
    public String wordBreak(Set<String> dict, String input) {
        List<String> path = new ArrayList<>();
        helper(path, dict, input, 0);
        StringBuilder result = new StringBuilder();
        for (String word : path) {
            result.append(word + " ");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    private boolean helper(List<String> path, Set<String> dict, String input, int index) {
        if (index == input.length()) {
            return true;
        }
        for (int i = index; i < input.length(); i++) {
            String word = input.substring(index, i + 1);
            if (dict.contains(word)) {
                path.add(word);
                if (helper(path, dict, input, i + 1)) {
                    return true;
                }
                path.remove(path.size() - 1);
            }
        }
        return false;
    }
}


public class Solution {
    HashMap<String,List<String>> map = new HashMap<String,List<String>>();
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() == 0) {
            return res;
        }
        if(map.containsKey(s)) {
            return map.get(s);
        }
        if(wordDict.contains(s)) {
            res.add(s);
        }
        for(int i = 1 ; i < s.length() ; i++) {
            String t = s.substring(i);
            if(wordDict.contains(t)) {
                List<String> temp = wordBreak(s.substring(0 , i) , wordDict);
                if(temp.size() != 0) {
                    for(int j = 0 ; j < temp.size() ; j++) {
                        res.add(temp.get(j) + " " + t);
                    }
                }
            }
        }
        map.put(s , res);
        return res;
   }
}











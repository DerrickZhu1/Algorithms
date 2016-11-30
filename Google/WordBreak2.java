public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        int n = s.length();
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        for (int i = 1; i <= n; i++)
            for (int j = 0; j < i; j++)
                if (f[j] == true && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
        List<String> listSet = new ArrayList<>();
        if (f[n])   dfs(s, 0, wordDict, new StringBuilder(), listSet);
        return listSet;
    }
    // DFS
    private void dfs(String s, int j, Set<String> wordDict, StringBuilder str, List<String> listSet) {
        if (j == s.length()) {
           listSet.add(str.toString());
        } else {
           for (int i = j + 1; i <= s.length(); i++) {
              if (wordDict.contains(s.substring(j, i))) {
                int len = str.length();
                if (len != 0)   str.append(" ");
                str.append(s.substring(j, i));
                dfs(s, i, wordDict, str, listSet);
                str.delete(len, str.length());
              }
           }
        }
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
            String t = s.substring(i);   // Break from "a"-"bcd" to "abc"-"d"
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













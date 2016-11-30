public class Solution {
    public boolean validWordSquare(List<String> words) {
        if (words == null || words.size() == 0){
            return true;
        }
        int n = words.size();
        for (int i=0; i<n; i++){
            for (int j=0; j<words.get(i).length(); j++){
                if (j >= n || words.get(j).length() <= i  || words.get(j).charAt(i) != words.get(i).charAt(j))
                    return false;
            }
        }
        return true;
    }
}

Given a set of words (without duplicates), find all word squares you can build from them.

Example: ["area","lead","wall","lady","ball"]
We know that the sequence contains 4 words because the length of each word is 4.
Every word can be the first word of the sequence, lets take "wall" for example.
Which word could be the second word? Must be a word start with "a" (therefore "area"), because it has to match the second letter of word "wall".
Which word could be the third word? Must be a word start with "le" (therefore "lead"), because it has to match the third letter of word "wall" and the third letter of word "area".
What about the last word? Must be a word start with "lad" (therefore "lady"). For the same reason above.

In order for this to work, we need to fast retrieve all the words with a given prefix. 
There could be 2 ways doing this:
Using a hashtable, key is prefix, value is a list of words with that prefix.
Trie, we store a list of words with the prefix on each trie node.

class TrieNode {
    List<String> startWith;
    TrieNode[] children;

    TrieNode() {
        startWith = new ArrayList<>();
        children = new TrieNode[26];
    }
}

class Trie {
    TrieNode root;

    Trie(String[] words) {
        root = new TrieNode();
        for (String w : words) {
            TrieNode cur = root;
            for (char ch : w.toCharArray()) {
                int idx = ch - 'a';
                if (cur.children[idx] == null)
                     cur.children[idx] = new TrieNode();
                cur.children[idx].startWith.add(w);
                cur = cur.children[idx];
            }
         }
     }
    
    // 找到所有有这个prefix的strings
    List<String> findByPrefix(String prefix) {
        List<String> ans = new ArrayList<>();
        TrieNode cur = root;
        for (char ch : prefix.toCharArray()) {
            int idx = ch - 'a';
            if (cur.children[idx] == null)
                return ans;

            cur = cur.children[idx];
        }
        ans.addAll(cur.startWith);
        return ans;
    }
}

private void search(int len, Trie tr, List<List<String>> ans, List<String> ansBuilder) {
    if (ansBuilder.size() == len) {
        ans.add(new ArrayList<>(ansBuilder));
        return;
    }

    int idx = ansBuilder.size();
    // idx = 1
    StringBuilder prefixBuilder = new StringBuilder();
    for (String s : ansBuilder)
        prefixBuilder.append(s.charAt(idx));

    List<String> startWith = tr.findByPrefix(prefixBuilder.toString());
    for (String sw : startWith) {
         ansBuilder.add(sw);
         search(len, tr, ans, ansBuilder);
         ansBuilder.remove(ansBuilder.size() - 1);
    }
}

public List<List<String>> wordSquares(String[] words) {
    List<List<String>> ans = new ArrayList<>();
    if (words == null || words.length == 0)
        return ans;

    int len = words[0].length();
    Trie trie = new Trie(words);
    List<String> ansBuilder = new ArrayList<>();
    for (String w : words) {
        ansBuilder.add(w);
        search(len, trie, ans, ansBuilder);
        ansBuilder.remove(ansBuilder.size() - 1);
    }

    return ans;
}







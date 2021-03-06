"The idea behind bidirectional search is to run two simultaneous searches — one forward from
the initial state and the other backward from the goal — hoping that the two searches meet in
the middle. The motivation is that b^(d/2) + b^(d/2) is much less than b^d. b is branch factor, d is depth."

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        Set<String> map = new HashSet<>(); // record visited words in dict so as not to modify dict
        Queue<String> word = new LinkedList<String>();
        Queue<Integer> depth = new LinkedList<Integer>();
        word.add(beginWord);
        depth.add(1);
        //wordDict.add(endWord);
        // BFS
        while (!word.isEmpty()) {
           String currWord = word.poll();
           int currDepth = depth.poll();
           // return depth if a match is found
           
           // change each letter of currWord
           for (int i = 0; i < currWord.length(); i++) {
              char[] currWordArr = currWord.toCharArray();
              // try every possible char and check if there's a match in dict
              for (char c = 'a'; c <= 'z'; c++) {
                  currWordArr[i] = c;
                  String newWord = new String(currWordArr);
                  if (newWord.equals(endWord))    return currDepth + 1;
                  if (wordDict.contains(newWord) && !map.contains(newWord)) {
                     word.add(newWord);
                     depth.add(currDepth + 1);
                     map.add(newWord);
                 }
              }
            }
         }
       return 0; // no match is found in dict
    }
}



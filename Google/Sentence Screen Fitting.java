Given a rows x cols screen and a sentence represented by a list of words, 
find how many times the given sentence can be fitted on the screen.

rows = 3, cols = 6, sentence = ["a", "bcd", "e"]
Output: 
2

Explanation:
a-bcd- 
e-a---
bcd-e-

public int wordsTyping(String[] sentence, int rows, int cols) {
    int[] nextIndex = new int[sentence.length];
    int[] times = new int[sentence.length];
    for (int i = 0;i < sentence.length;i++) {
         int curLen = 0;
         int cur = i;
         int time = 0;
         while (curLen + sentence[cur].length() <= cols) {
              curLen += sentence[cur++].length() + 1;
              if (cur == sentence.length) {
                  cur = 0;
                  time++;
              }
         }
         nextIndex[i] = cur;
         times[i] = time;
    }
    int ans = 0;
    int cur = 0;
    for (int i = 0; i < rows; i++) {
        ans += times[cur];
        cur = nextIndex[cur];
    }
    return ans;
}


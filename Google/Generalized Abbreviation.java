Given word = "word", return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", 
"w1r1", "1o2", "2r1", "3d", "w3", "4"]

public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> ret = new ArrayList<String>();
        backtrack(ret, word, 0, "", 0);

        return ret;
    }
    
    private void backtrack(List<String> ret, String word, int pos, String cur, int count) {
        if (pos == word.length()) {
            if (count > 0) cur += count;
            ret.add(cur);
        }
        else {
        	// 统计个数
            backtrack(ret, word, pos + 1, cur, count + 1);
            // 消耗count
            backtrack(ret, word, pos + 1, cur + (count > 0 ? count : "") + word.charAt(pos), 0);
        }
    }
}


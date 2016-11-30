import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class longestChain {
	
	static int longest_Chain(String[] w) {

        if (null == w || w.length == 0) return 0;

        // Index words by length. Key: length, value: set of words with given length. 
        // Use TreeMap so that the keys are sorted
        TreeMap<Integer, Set<String>> wordsLengthMap = new TreeMap<>();

        for (int i = 0; i < w.length; ++i) {
             
             String word = w[i];
             int wordLength = word.length();
             
             if (!wordsLengthMap.containsKey(wordLength)) {
            	 Set<String> words = new HashSet<>();
            	 wordsLengthMap.put(wordLength, words);
             }
             Set<String> words = wordsLengthMap.get(wordLength);
             words.add(word);
             wordsLengthMap.put(wordLength, words);
        }

        int longest = 1;

        //process the longest word first (using descendingMap)

        for (Map.Entry<Integer, Set<String>> entry : wordsLengthMap.descendingMap().entrySet()) {
                Set<String> words = entry.getValue();
                for (String word : words) {
                        int chainLenOfTheWord = getChainLenOfTheWord(word, wordsLengthMap);
                        longest = Math.max(longest, chainLenOfTheWord);
                }
        }

       return longest;
   }
	
	//Make recursive calls.  Remove visited (shorter) words for performance
	static private int getChainLenOfTheWord(String word, Map<Integer, Set<String>> wordsLengthMap) {

	     if (word.length() == 1) return 1;  //base case

	     int chainLenOfTheWord = 1;
	     for (int i = 0; i < word.length(); i++) {
	            StringBuilder sb = new StringBuilder(word);
	            sb.deleteCharAt(i);  //delete char at i
	            String shorterWord = sb.toString();

	            Set<String> words = wordsLengthMap.get(shorterWord.length());
	            if (words != null) {
	                 if (words.remove(shorterWord)) { // remove it, no need to visit it again
	                      int chainLenOfTheShorter = getChainLenOfTheWord(shorterWord, wordsLengthMap);
	                      chainLenOfTheWord = Math.max(chainLenOfTheWord, chainLenOfTheShorter + 1);
	                 }
	            }
	      }

	    return chainLenOfTheWord;
	}
	
	public static void main(String[] args) {
		String[] inputs = new String[]{"a", "b", "ba", "bca", "bda", "bdca"};
		int result = longest_Chain(inputs);
		System.out.println(result);
	}
	

}

Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, 
so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Given words = ["abcd", "dcba", "lls", "s", "sssll"]
Return [[0, 1], [1, 0], [3, 2], [2, 4]]
The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]

 public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ret = new ArrayList<>(); 
        if (words == null || words.length < 2) return ret;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i=0; i<words.length; i++) map.put(words[i], i);
        for (int i=0; i<words.length; i++) {
            // System.out.println(words[i]);
            for (int j=0; j<=words[i].length(); j++) { // notice it should be "j <= words[i].length()"
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                if (isPalindrome(str1)) {
                    String str2rvs = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(map.get(str2rvs));
                        list.add(i);
                        ret.add(list);
                        // System.out.printf("isPal(str1): %s\n", list.toString());
                    }
                }
               if (isPalindrome(str2)) {
                    String str1rvs = new StringBuilder(str1).reverse().toString();
                    // check "str.length() != 0" to avoid duplicates
                    if (map.containsKey(str1rvs) && map.get(str1rvs) != i && str2.length()!=0) { 
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(i);
                        list.add(map.get(str1rvs));
                        ret.add(list);
                        // System.out.printf("isPal(str2): %s\n", list.toString());
                     }
                }
            }
        }
        return ret;
    }
    
    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
           if (str.charAt(left++) !=  str.charAt(right--)) return false;
        }
        return true;
    }
}

The <= in for (int j=0; j<=words[i].length(); j++) is aimed to handle empty string in the input. Consider the test case of ["a", ""];
Since we now use <= in for (int j=0; j<=words[i].length(); j++) instead of <. There may be duplicates in the output 
(consider test case ["abcd", "dcba"]). Therefore I put a str2.length()!=0 to avoid duplicates.
Another way to avoid duplicates is to use Set<List<Integer>> ret = new HashSet<>(); and return new ArrayList<>(ret);



By examining the above process, I do find something that we may take advantage of to get rid of words that need to be checked. 
For example, let's say we want to append words to w0, which starts with character 'a'. 
Then we only need to consider words ending with character 'a', 
i.e., this will single out all words ending with character 'a'. 
If the second character of w0 is 'b' for instance, we can further 
reduce our candidate set to words ending with string "ba", etc. 
Our naive solution throws all the information away and repeats the comparison, 
which leads to the undesired O(n^2*k) complexity.

One point here is that we assume all the words contain lowercase letters only. 
This is not specified in the problem statement so you probably need to confirm 
with the interviewer (here I assume it is the case)

O(n*k^2)

["ba", "a", "aaa"]

  root (f)
     | 'a'
   n1 (t)
 ------------
'b' |    | 'a'
  n2 (t) n3 (f)
         | 'a'
         n4 (t)

class TrieNode {
	TrieNode[] next;
	int index;
	List<Integer> list;
	
	TrieNode() {
		next = new TrieNode[26];
		index = -1;
		list = new ArrayList<>();
	}
}

public List<List<Integer>> palindromePairs(String[] words) {
    List<List<Integer>> res = new ArrayList<>();
    
    TrieNode root = new TrieNode();
    
    for (int i = 0; i < words.length; i++) {
		addWord(root, words[i], i);
	}
    
    for (int i = 0; i < words.length; i++) {
    	search(words, i, root, res);
    }
    
    return res;
}


private void addWord(TrieNode root, String word, int index) {
	for (int i = word.length() - 1; i >= 0; i--) {
		if (root.next[word.charAt(i) - 'a'] == null) {
			root.next[word.charAt(i) - 'a'] = new TrieNode();
		}
		
		if (isPalindrome(word, 0, i)) {
			root.list.add(index);
		}
		
		root = root.next[word.charAt(i) - 'a'];
	}
	
	root.list.add(index);
	root.index = index;
}

private void search(String[] words, int i, TrieNode root, List<List<Integer>> list) {
	for (int j = 0; j < words[i].length(); j++) {	
		if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length() - 1)) {
			list.add(Arrays.asList(i, root.index));
		}
		
		root = root.next[words[i].charAt(j) - 'a'];
  		if (root == null) return;
	}
	
	for (int j : root.list) {
		if (i == j) continue;
		list.add(Arrays.asList(i, j));
	}
}

private boolean isPalindrome(String word, int i, int j) {
	while (i < j) {
		if (word.charAt(i++) != word.charAt(j--)) return false;
	}
	
	return true;
}



















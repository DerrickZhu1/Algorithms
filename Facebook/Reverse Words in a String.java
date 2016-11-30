Reverse Words in a String

Given s = "the sky is blue",
return "blue is sky the".

public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
			return "";
		}
		//split to words by space
		String[] arr = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = arr.length - 1; i >= 0; i--) {
			if (!arr[i].equals("")) {
				sb.append(arr[i]).append(" ");
			}
		}
		return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }
}

" 1" -> "", "1"

Given s = "the sky is blue",
return "blue is sky the".

public class Solution {
    public void reverseWords(char[] s) {
    	// 先reverse
        reverse(s, 0, s.length);
        // j <= s.length
        for (int i = 0, j = 0; j <= s.length; j++) {
            if (j == s.length || s[j] == ' ') {
                reverse(s, i, j);
                i = j + 1;
            }
        }
    }
    private void reverse(char[] s, int begin, int end) {
        for (int i = 0; i < (end - begin) / 2; i++) {
            char temp = s[begin + i];
            s[begin + i] = s[end - i - 1];
            s[end - i - 1] = temp;
        }
    }
}
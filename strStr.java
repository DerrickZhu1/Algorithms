public class Solution {
    public int strStr(String haystack, String needle) {
      for (int i = 0; ; i++) {
         for (int j = 0; ; j++) {
           if (j == needle.length()) return i;
           if (i + j == haystack.length()) return -1;
           if (needle.charAt(j) != haystack.charAt(i + j)) break;
         }
      }
    }
}


Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
for (int i = 0; i < n; i++) {
	int a = sc.nextInt()
	int b = sc.nextInt()
	

}

System.out.println()
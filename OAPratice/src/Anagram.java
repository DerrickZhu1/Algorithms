
public class Anagram {
	public static boolean no_name_one(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		}
		
		for (int x = 0; x < b.length(); x++) {
			if (a.charAt(0) == b.charAt(x)) {
				return no_name_one(no_name_two(a, 0), no_name_two(b, x));
			}
		}
		return b.length() == 0;
	}
	
	
	public static boolean no_name_one1(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		}
		while (b.length() != 0) {
			boolean no_exit = false;
			char c = a.charAt(0);
			for (int i = 0; i < b.length(); i++) {
				if (c == b.charAt(i)) {
					a = no_name_two(a, 0);
					b = no_name_two(b, i);
					no_exit = true;
					break;
				}
			}
			if (!no_exit)
				return false;
		}
		return b.length() == 0;
	}
	

	private static String no_name_two(String s, int j) {
		char[] ret = new char[s.length() - 1];
		int d = 0;
		for (int k = 0; k < s.length(); k++) {
			if (k == j) {
				d = 1;
			} else { 
				ret[k - d] = s.charAt(k);
			}
		}
		
		return new String(ret);
	}
	
	public static void main(String[] args) {
		System.out.println(no_name_one("abcde", "bdcae"));
		System.out.println(no_name_one("trfga", "fatfa"));
		System.out.println(no_name_one1("abcde", "bdcae"));
		System.out.println(no_name_one1("trfga", "fatfa"));
	}

	
}

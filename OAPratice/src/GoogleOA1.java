import java.util.List;
import java.util.ArrayList;


public class GoogleOA1 {
	public static int solution(int X) {
		StringBuilder number = new StringBuilder(String.valueOf(X));

		List<Integer> results = new ArrayList<>();

		for (int i = 0; i < number.length() - 1; i++) {
            StringBuilder fake = new StringBuilder(number.toString());
			int left = Integer.valueOf(number.charAt(i));
			int right = Integer.valueOf(number.charAt(i+1));
			
			int temp = 0;

			if (left < right) {
	           temp = Integer.valueOf(fake.deleteCharAt(i).toString());
	           results.add(temp);
			} else {
				temp = Integer.valueOf(fake.deleteCharAt(i+1).toString());
				results.add(temp);
			}
		}

		int min = Integer.MAX_VALUE;
		for (Integer value : results) {
			if (value < min) 
				min = value;
		}

	    return min;
	}
	
	public static void main(String[] args) {
		int result = solution(233614);
		System.out.println(result);
		System.out.println(Integer.valueOf('c'));
		String a = " aa bc";
		StringBuilder aa = new StringBuilder(a);
		
		aa.replace(0, 2, String.valueOf('b'));
		System.out.println(a.lastIndexOf(" "));
		
	}
}

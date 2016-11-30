import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PrimeProduct {
	public static List<Integer> primeProduct(int[] primes, int[] times) {
		List<Integer> res = new ArrayList<>();
		
		if (primes.length == 0) {
			res.add(1);
			return res;
		}
	
		backtrack(primes, times, res, 1, 0);
		return res;
	}
	
	private static void backtrack(int[] primes, int[] times, List<Integer> res, int num, int index) {
		if (index == primes.length) {
			res.add(num);
		} else {
			int p = 1;
			for (int i = 0; i <= times[index]; i++) {
				backtrack(primes, times, res, p*num, index+1);
				p = p*primes[i];
			}
		}
	}
	
	public static void main(String[] args) {
		int[] primes = {2, 3, 5, 7};
		int[] times = {1, 2, 1, 3};
		
		List<Integer> res = primeProduct(primes, times);
		Collections.sort(res);
		for (int i : res) {
			System.out.println(i);
		}
	}

}

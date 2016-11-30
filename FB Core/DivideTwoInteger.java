divisor * 2^N < dividend < divisor * 2^(N + 1)
Then,
result += 2^N;
dividend -= divisor * 2^N

Overflow (i.e., Integer.MIN_VALUE / -1 = Integer.MAX_VALUE)

public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0)   throw new IllegalArgumentException("divisor can't be 0!");
        if (divisor == 1)   return dividend;
        if (divisor == -1)  return (dividend == Integer.MIN_VALUE) ? Integer.MAX_VALUE : -dividend;
        // convert int to long, otherwise Math.abs(Integer.MIN_VALUE) will overflow
        long p = Math.abs((long) dividend);
        long q = Math.abs((long) divisor);
        long res = 0;
        while (p >= q) {
           int count = 0;
           while (p >= (q << count)) // q*2^n < p < q*2^(n+1)
              count++;
           res += (long)1 << (count - 1); // add 2^n
           p -= q << (count - 1);   // p <= p - q*2^n
        }
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))
           // return (res > Integer.MAX_VALUE) ? Integer.MAX_VALUE : (int) res;
           return (int)res
        else
           return (int)-res;
    }
}






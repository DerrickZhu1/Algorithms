1.00000
-2147483648

return 1

corner case:
n = 0
x = 1, return 1
x = -1, 1 or -1
n = Integer.MIN_VALUE  -n overflow  so return 0;

public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (x == 1) return 1;
        if (x == -1) {
            if (n % 2 == 0) return 1;
            else return -1;
        }
        if (n == Integer.MIN_VALUE) return 0;
        
        if (n < 0) {
           n = -n;
           x = 1 / x;
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}
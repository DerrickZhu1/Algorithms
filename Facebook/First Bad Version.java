Suppose you have n versions [1, 2, ..., n] and you want to find out 
the first bad one, which causes all the following ones to be bad.

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
               right = mid;
            } else {
               left = mid + 1;
            }
         }
        return left;
    }
}

public class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;
        int lo = 1, hi = x; // lo not start from 0 to avoid divided by 0
        while (lo < hi) {
           int mid = (lo + hi) / 2;
           int div = x / mid; // don't compare x with mid * mid that will overflow
           if      (div > mid) lo = mid + 1;
           else if (div < mid) hi = mid;
           else            return mid;
       }
      return  lo - 1;
    }
}


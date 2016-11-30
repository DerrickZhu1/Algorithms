public class Solution {
    public String addBinary(String a, String b) {
        int place = 2;  // 10: decimal, 2 - binary
        int na = a.length(), nb = b.length();
        int digit = 0, carry = 0;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < Math.max(na, nb); i++) {
           int da = (i < na) ? Character.getNumericValue(a.charAt(na - 1 - i)) : 0;
           int db = (i < nb) ? Character.getNumericValue(b.charAt(nb - 1 - i)) : 0;
           int sum = da + db + carry;
           digit = sum % place;
           carry = sum / place;
           str.append(digit);
       }
       if (carry > 0) str.append(carry);
         return str.reverse().toString();
    }
}
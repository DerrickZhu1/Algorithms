>> is arithmetic shift right, >>> is logical shift right.

In an arithmetic shift, the sign bit is extended to preserve the signedness of the number.
For example: -2 represented in 8 bits would be 11111110 (because the most significant bit 
has negative weight). Shifting it right one bit using arithmetic shift would give you 11111111, 
or -1. Logical right shift, however, does not care that the value could possibly represent a number;
it simply moves everything to the right and fills in from the left with 0s. Shifting our -2 right one 
bit using logical shift would give 01111111.

public class Solution {
    char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    public String toHex(int num) {
        if(num == 0) return "0";
        String result = "";
        while(num != 0){
            result = map[(num & 15)] + result; 
            num = (num >>> 4);
        }
        return result;
    }
}
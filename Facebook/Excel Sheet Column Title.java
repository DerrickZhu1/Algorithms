1 -> A
2 -> B
3 -> C
...
26 -> Z
27 -> AA
28 -> AB 

public class Solution {
    public String convertToTitle(int n) {
        return n == 0 ? "" : convertToTitle((n - 1) / 26) + (char) ((n - 1) % 26 + 'A');
    }
}

(char)

public String convertToTitle(int n) {
    StringBuilder result = new StringBuilder();
    while (n > 0) {
        char letter = (char)((n - 1) % 26 + 'A');
        result.append(letter);
        n = (n - 1) / 26;
    }
    return result.reverse().toString();
}

69. 字母和数字的转换 A = 1 B = 2 AA = 27 基本是26进制的转换， 他要我写了两个边的转换。 我写出来了不过最后我用的是

#letter to number, excel
public int titleToNumber(String s) {
    int result = 0;
    for (char letter : s.toCharArray()) {
        result = result * 26 + letter - 'A' + 1;
    }
    return result;
}

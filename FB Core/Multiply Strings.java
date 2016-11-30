public class Solution {
    public String multiply(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
    	num2 = new StringBuilder(num2).reverse().toString();
    	//the maximum length
        // 3 + 3 = 6 最大5  而这里最大4
    	int[] d = new int[num1.length() + num2.length()];
    	for (int i = 0; i < num1.length(); i++) {
    		int a = num1.charAt(i) - '0';
    		for (int j = 0; j < num2.length(); j++) {
    			int b = num2.charAt(j) - '0';
    			d[i + j] += a * b;
    		}
    	}
        // 处理了进位了
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < d.length; i++) {
    		int digit = d[i] % 10;
            // 最后一位是进上来的，所有carry是0
    		int carry = d[i] / 10;
    		sb.insert(0, digit);
    		if (i < d.length - 1)
    			d[i + 1] += carry;
    	}
    	//trim starting zeros
    	while (sb.length() > 1 && sb.charAt(0) == '0') {
    		sb.deleteCharAt(0);
    	}
    	return  sb.toString();
    }
}
"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []

public List<String> addOperators(String num, int target) {
    List<String> rst = new ArrayList<String>();
    if (num == null || num.length() == 0) return rst;
    helper(rst, "", num, target, 0, 0, 0);
    return rst;
}

public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed) {
    if (pos == num.length()) {
        if (target == eval)
            rst.add(path);
        return;
    }
    for (int i = pos; i < num.length(); i++) {
        if (i != pos && num.charAt(pos) == '0') break;
        // 0 sequence: because we can't have numbers with multiple digits started with zero, we have to deal with it too.
        long cur = Long.parseLong(num.substring(pos, i + 1));
        if (pos == 0) {
            helper(rst, path + cur, num, target, i + 1, cur, cur);
        }
        else {
             helper(rst, path + "+" + cur, num, target, i + 1, eval + cur , cur);
                
             helper(rst, path + "-" + cur, num, target, i + 1, eval - cur, -cur);
                
             helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);
        }
    }
}
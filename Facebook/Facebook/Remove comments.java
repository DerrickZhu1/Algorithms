Remove comments

class RemoveComment {
    public String remove(String code) {
        StringBuilder result = new StringBuilder();
        boolean singleLine = false;
        boolean multiLine = false;
        // i
        for (int i = 0; i < code.length(); i++) {
            if (singleLine && code.charAt(i) == '\n') {
                singleLine = false;
            }
            else if (multiLine && code.charAt(i) == '*' && code.charAt(i + 1) == '/') {
                multiLine = false;
                i++;
                // i++   code.charAt(i + 1)
            }
            else if (multiLine || singleLine) {
                continue;
            }
            else if (code.charAt(i) == '/' && code.charAt(i + 1) == '/') {
                singleLine = true;
                i++;
            }
            else if (code.charAt(i) == '/' && code.charAt(i + 1) == '*') {
                multiLine = true;
                i++;
            }
            else {
                result.append(code.charAt(i));
            }
        }
        return result.toString();
    }
}



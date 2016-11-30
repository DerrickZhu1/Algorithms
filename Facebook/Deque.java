Simplify Path

public String simplifyPath(String path) {
         Deque<String> deque = new LinkedList<String>();
         String[] splits = path.split("/");
         for (String split : splits) {
            // CATCH: must use "equals()" instead of "==",
            // because 'split' is a variable!
            // Also, 'split' could be empty string.
            if (split.equals(""))
                continue;
            else if (split.equals("."))
                continue;
            else if (split.equals(".."))
                deque.pollLast();
            else
                deque.addLast(split);
         }
         StringBuilder builder = new StringBuilder();
         while (!deque.isEmpty()) {
              String s = deque.pollFirst();
              builder.append("/").append(s);
          }
         if (builder.length() == 0)
             return "/";
         return builder.toString();
       
    }
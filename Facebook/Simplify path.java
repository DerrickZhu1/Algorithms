#Simplify path
public String simplifyPath(String path) {
   Stack<String> validPath = new Stack<>();
   Set<String> special = new HashSet<>(Arrays.asList("..", ".", ""));
   String[] directories = path.split("/");

   for (String directory : directories) {
       if (directory.equals("..") && !validPath.isEmpty()) {
           validPath.pop();
       }
       else if (!special.contains(directory)) {
           validPath.push(directory);
       }
   }

   StringBuilder result = new StringBuilder();
   // result(StringBuilder   .insert(0, "/" + validPath.pop()))
   while (!validPath.isEmpty()) {
       result.insert(0, "/" + validPath.pop());
   }
   if (result.length() == 0) {
       return "/";
   }
   return result.toString();
}


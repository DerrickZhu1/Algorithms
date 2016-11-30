Deque is an interface, so we cannot instantiate it by itself. Instead, we are using a LinkedList implementation.

Deque deque = new LinkedList<>();
// We can add elements to the queue in various ways

deque.add("Element 1 (Tail)"); // add to tail

deque.addFirst("Element 2 (Head)");

deque.addLast("Element 3 (Tail)");

deque.push("Element 4 (Head)"); //add to head

deque.offer("Element 5 (Tail)");

deque.offerFirst("Element 6 (Head)");

deque.offerLast("Element 7 (Tail)");

deque.peek()

deque.pop()


Iterator iterator = deque.iterator();
while (iterator.hasNext()) {

    System.out.println("\t" + iterator.next());
}

/**
 * Deque of strings (directories).
 * iterate path:
 *  if "/", continue,
 *  if ".", conitnue,
 *  if "..", poll last,
 *  else, add a new directory
 * in the end, build result from deque.
 */

Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".


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


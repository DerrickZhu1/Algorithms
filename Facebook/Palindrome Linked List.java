Palindrome Linked List

public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
		ListNode slow = head;
		Stack<Integer> stack = new Stack<Integer>();
		while (fast != null && fast.next != null) {
			stack.push(slow.val);
			slow = slow.next;
			fast = fast.next.next;
		}
		//If it has odd number of elements, skip the middle element
		if (fast != null) {
			slow = slow.next;
		}
		
		while (slow != null) {
			int top = stack.pop();
			//if they are different, so it's not a palindrome.
			if (top != slow.val)
				return false;
			slow = slow.next;
		}
		return true;
    }
}

O(n), O(1)

1 -> 1 -> 2 -> 1 -> null 
sf

1 -> 1 -> 2 -> 1 -> null 
          s          f
1 -> 1    null <- 2 <- 1           
h                      s

1 -> 1    null <- 2 <- 1             
     h            s
check if slow == null

public boolean isPalindrome(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;

    while(fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }
    if (fast != null) slow = slow.next;

    slow = reverse(slow);
    while(slow != null && head.val == slow.val) {
        head = head.next;
        slow = slow.next;
    }
    return slow == null;
}

private ListNode reverse(ListNode head) {
    ListNode prev = null;
    while (head != null) {
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
    }
    return prev;
}








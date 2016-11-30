While you are traversing the list, change the current nodes 
next pointer to point to its previous element. Since a node does
not have reference to its previous node, 

you must store its previous element beforehand. 
You also need another pointer to store the next node before
changing the reference. 

Do not forget to return the new head reference at the end!

public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
    	// store the next node
        ListNode nextTemp = curr.next;
        // link the next node to its previous node
        curr.next = prev;
        // move prev a node forward
        prev = curr;
        // move cur node a node forward
        curr = nextTemp;
    }
    return prev;
}

O(n)

The recursive version is slightly trickier and the key is to work backwards.
Assume that the rest of the list had already been reversed, now how do I reverse
the front part? Lets assume the list is: n1 → … → nk-1 → nk → nk+1 → … → nm → Ø

n1 → … → nk-1 → nk → nk+1 ← … ← nm

We want nk+1’s next node to point to nk.
So,
nk.next.next = nk;

Be very careful that n1s next must point to Ø. 
If you forget about this, your linked list has a cycle in it. 
This bug could be caught if you test your code with a linked list of size 2.

public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
}

逆序输出一个单链表，要求空间复杂度为O(lgn)
void printReverse(Node head) {
    if (head == null) return;

    // print list of head node
    printReverse(head.next);

    // After everything else is printed
    System.out.print(head.data+" ");
}


public static void printReverse(ListNode head){
        int len = 0;
        ListNode node = head;
        while(node != null){.鐣欏璁哄潧-涓€浜�-涓夊垎鍦�
              node = node.next;
              len++;
        }
        print(head, len);
}
 
public static void print(ListNode head, int len) {
        if (head == null){
            return;
        }
        if (len == 1){
           System.out.println(head.val);
           return;
        }
        ListNode node = head;
        int count = 0;
        while (node != null && count < len / 2){
              node = node.next;
              count++;
        }
        print(node, len - count);
        print(head, count);
}

O(nlogn)


























public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)   return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, PQ_ORDER);
        for (ListNode l : lists)
            if (l != null)
               pq.add(l);

        ListNode dummy = new ListNode(0);
        ListNode p = head;

        while (pq.size() > 0) {
            ListNode temp = pq.poll();
            if (temp.next != null)
               pq.add(temp.next);
            p.next = temp;            
            p = p.next;            
        }
        return dummy.next;
    }


public final Comparator<ListNode> PQ_ORDER = new Comparator<ListNode>() {
    public int compare(ListNode l1, ListNode l2) {
        if      (l1.val < l2.val)   return -1;
        else if (l1.val > l2.val)   return 1;
        else                        return 0;
    }
};


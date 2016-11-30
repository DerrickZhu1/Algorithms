#copy linked List with random pointer
public RandomListNode copyRandomList(RandomListNode head) {
    RandomListNode mover = head;

    // // First round: make copy of each node,
    // and link them together side-by-side in a single list.
    while (mover != null) {
        RandomListNode copy = new RandomListNode(mover.label);
        RandomListNode next = mover.next;
        mover.next = copy;
        copy.next = next;
        mover = copy.next;
    }

    // Second round: assign random pointers for the copy nodes.
    mover = head;
    while (mover != null) {
        if (mover.random != null) {
            // mover.next.random = mover.random.next;
            mover.next.random = mover.random.next;
        }
        mover = mover.next.next;
    }

    // Third round: restore the original list, and extract the copy list.
    RandomListNode fakeHead = new RandomListNode(0);
    RandomListNode copyMover = fakeHead;
    mover = head;
    while (mover != null) {
        copyMover.next = mover.next;
        mover.next = mover.next.next;
        // mover = mover.next;
        mover = mover.next;
        // copyMover = copyMover.next;
        copyMover = copyMover.next;
    }
    return fakeHead.next;
}


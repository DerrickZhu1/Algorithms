84. Min Queue, 跟Min Stack类似， 实现一个Queue， 然后O（1）复杂度获得这个Queue里最小的元素。
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=193703&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

#Min Queue
//Use queue to save the minimum number
// Every time add a new number, traverse the queue, remove the number 
// bigger than it, so in the deque there will leave the numbers that smaller than it
// add this number to the end of the deque
// by doing this, the minimum number will always at the head of the deque
'Time complexity of offer : O(len), space complexity: O(n)'

class MinQueue {
    private Queue<Integer> queue = new LinkedList<>();
    private Deque<Integer> min = new ArrayDeque<>();
    public void offer(int val) {
        while (!min.isEmpty() && min.peekLast() > val) {
            min.pollLast();
        }
        queue.offer(val);
        min.offer(val);
    }
    public int poll() {
        int result = queue.poll();
        if (result == min.peek()) {
            min.poll();
        }
        return result;
    }
    public int getMin() {
        return min.peek();
    }
}
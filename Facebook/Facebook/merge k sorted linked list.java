42. 貌似一个ABC，考了merge k sorted linked list
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=199232&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode fakeHead = new ListNode(0);
        ListNode mover = fakeHead;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new ComparatorImp());
        for (ListNode node : lists) {
            if (node == null) {
                continue;
            }
            pq.add(node);
        }
        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            mover.next = temp;
            mover = mover.next;
            if (temp.next != null) {
                pq.add(temp.next);
            }
            mover.next = null;
        }
        return fakeHead.next;
    }
}

class ComparatorImp implements Comparator<ListNode> {
    @Override
    public int compare(ListNode node1, ListNode node2) {
        return node1.val - node2.val;
    }
}



Given k sorted lists of O(n) integers each, implement an iterator that will yield all elements in sorted order。
http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=190778&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311

class MergeToIterator implements Iterator<Integer>{
    PriorityQueue<Number> minNumber;
    List<List<Integer>> lists;
    public MergeToIterator(List<List<Integer>> input) {
        this.minNumber = new PriorityQueue<>(input.size(), new Comparator<Number>() {
            @Override
            public int compare(Number num1, Number num2) {
                return num1.value - num2.value;
            }
        });
        this.lists = input;
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).size() == 0) {
                continue;
            }
            minNumber.add(new Number(input.get(i).get(0), 0, i));
        }
    }

    @Override
    public boolean hasNext() {
        return !minNumber.isEmpty();
    }

    @Override
    public Integer next() {
        Number min = minNumber.poll();
        if (lists.get(min.listIndex).size() - 1 > min.index) {
            minNumber.add(new Number(lists.get(min.listIndex).get(min.index + 1), min.index + 1, min.listIndex));
        }
        return min.value;
    }

    class Number {
        int value;
        int index;
        int listIndex;
        public Number(int value, int index, int listIndex) {
            this.value = value;
            this.index = index;
            this.listIndex = listIndex;
        }
    }
}












public class Solution {
    public static Iterable<Integer> mergeKSortedIterators(List<Iterator<Integer>> iterators) {
        List<Integer> result = new ArrayList<>();
        if (iterators == null || iterators.size() == 0) {
            return result;
        }
         
        PriorityQueue<MyIterator> pq = new PriorityQueue<>(iterators.size());
         
        for (Iterator<Integer> iterator : iterators) {
            if (iterator.hasNext()) {
                pq.add(new MyIterator(iterator.next(), iterator));
            }
        }
         
        while (!pq.isEmpty()) {
            MyIterator curr = pq.poll();
            result.add(curr.val);
            if (curr.hasNext()) {
                pq.add(curr);
            }
        }
         
        return result;
    }
     
    private static class MyIterator implements Comparable<MyIterator> {
        private Integer val;
        private Iterator<Integer> iterator;
         
        public MyIterator(Integer val, Iterator<Integer> iterator) {
            this.val = val;
            this.iterator = iterator;
        }
         
        public boolean hasNext() {
            if (iterator.hasNext()) {
                val = iterator.next();
                return true;
            } 
             
            return false;
        }
         
        public int compareTo(MyIterator that) {
            return this.val - that.val;
        } 
    }
     
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(5);
         
        List<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(4);
         
        List<Iterator<Integer>> iterators = new ArrayList<>();
        iterators.add(a.iterator());
        iterators.add(b.iterator());
         
        Iterable<Integer> result = mergeKSortedIterators(iterators);
         
        for (Integer num : result) {
            System.out.println(num);
        }
    }
}
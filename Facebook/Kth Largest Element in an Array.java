Find the kth largest element in an unsorted array. 
Note that it is the kth largest element in the sorted order, not the kth distinct element.

O(N lg N) running time + O(1) memory

public int findKthLargest(int[] nums, int k) {
    int N = nums.length;
    Arrays.sort(nums);
    return nums[N - k];
}

O(N lg K) running time + O(K) memory

public int findKthLargest(int[] nums, int k) {

    final PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int val : nums) {
        // 都加进去
        pq.offer(val);
         
        // poll 出小的
        if (pq.size() > k) {
            pq.poll();
        }
    }
    return pq.peek();
}


Quick sort
O(N) best case / O(N^2) worst case running time + O(1) memory

private void exch(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
}

private boolean less(int v, int w) {
    return v < w;
}

private int partition(int[] a, int lo, int hi) {

    int i = lo;
    // hi + 1
    int j = hi + 1;
    while (true) {
        while (i < hi && less(a[++i], a[lo]));   // 取lo为pivot
        while (j > lo && less(a[lo], a[--j]));
        if (i >= j) {
            break;
        }
        exch(a, i, j);
    }
    exch(a, lo, j); // important
    return j;
}

public int findKthLargest(int[] nums, int k) {

    k = nums.length - k;
    int lo = 0;
    int hi = nums.length - 1;
    while (lo < hi) {
        int j = partition(nums, lo, hi);
        if (j < k) {
            lo = j + 1;
        } else if (j > k) {
            hi = j - 1;
        } else {
            break;
        }
    }
    return nums[k];
}
















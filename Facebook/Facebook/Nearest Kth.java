Nearest Kth
// Use quickSelect to find the kth nearest point to the origin point
'Time complexity: average O(n), worst O(n^2) when always pick the most right one -- the time complexity of quick select'
class NearestKPoint {
    public Point findNearestKthPoint(Point[] points, int k) {
        if (k > points.length || k == 0) {
            throw new IllegalArgumentException("K's value is illegal\n");
        }
        return quickSelect(points, 0, points.length - 1, k - 1);
    }


    private Point quickSelect(Point[] points, int left, int right, int k) {
        Random rand = new Random();
        int pivotIndex = 0;
        if (right != 0) {
            pivotIndex = rand.nextInt(right) % (right - left + 1) + left;
        }
        pivotIndex = partition(pivotIndex, points, left, right);
        if (pivotIndex == k) {
            return points[k];
        }
        else if (pivotIndex > k) {
            return quickSelect(points, left, pivotIndex - 1, k);
        }
        else {
            return quickSelect(points, pivotIndex + 1, right, k);
        }
    }

    private int partition(int pivotIndex, Point[] points, int left, int right) {
        int i = left;
        int j = right;
        Point temp = points[pivotIndex];
        int tempDistance = distance(temp);
        swap(points, left, pivotIndex);
        while (i < j) {
            while (j > i && distance(points[j]) >= tempDistance) {
                j--;
            }
            points[i] = points[j];
            while (j > i && distance(points[i]) <= tempDistance) {
                i++;
            }
            points[j] = points[i];
        }
        points[i] = temp;
        return i;
    }

    private int distance(Point point) {
        return point.x * point.x + point.y * point.y;
    }

    private void swap (Point[] points, int index1, int index2) {
        Point temp = points[index1];
        points[index1] = points[index2];
        points[index2] = temp;
    }
}

class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

// Use max Heap
// maintain a max heap with size K,
// every time meet a new point, check if its distance is 
// smaller than the heap.peek()
// if yes, pop out the peek, push this point into heap
// in the end we will have K points which are the nearest points
'Time complexity: O(nlgk), space complexity:O(k)'
public List<Point> findNearestKPoints(Point[] points, int k) {
    if (k <= 0 || k > points.length) {
        throw new IllegalArgumentException("K's value is illegal.\n");
    }
    List<Point> result = new ArrayList<>();
    PriorityQueue<Point> maxPoints = new PriorityQueue<>(k, new Comparator<Point>() {
        @Override
        public int compare(Point poi1, Point poi2) {
            // 从大到小
            return distance(poi2) - distance(poi1);
        }
    });
    for (Point point : points) {
        if (maxPoints.size() < k) {
            maxPoints.add(point);
        }
        else if (distance(maxPoints.peek()) > distance(point)) {
            maxPoints.poll();
            maxPoints.add(point);
        }
    }
    while (!maxPoints.isEmpty()) {
        result.add(maxPoints.poll());
    }
    return result;
}



# kth largest
class findKthLargest {
    // Use quickSelect
    public int kthLargest(int[] input, int k) {
        if (input.length < k || k == 0) {
            throw new IllegalArgumentException("K's value is illegal.\n");
        }
        return quickSelect(input, 0, input.length - 1, input.length - k);

    }

    private int quickSelect(int[] input, int left, int right, int k) {
        Random rand = new Random();
        int pivotIndex = 0;
        if (right != 0) {
            pivotIndex = rand.nextInt(right) % (right - left + 1) + left;
        }
        pivotIndex = partition(input, left, right, pivotIndex);
        if (pivotIndex == k) {
            return input[k];
        }
        else if (pivotIndex < k) {
            return quickSelect(input, pivotIndex + 1, right, k);
        }
        else {
            return quickSelect(input, left, pivotIndex - 1, k);
        }
    }

    private int partition(int[] input, int left, int right, int pivotIndex) {
        int i = left;
        int j = right;
        int temp = input[pivotIndex];
        swap(input, left, pivotIndex);
        while (i < j) {
            while (i < j && input[j] >= temp) {
                j--;
            }
            input[i] = input[j];
            while (i < j && input[i] <= temp) {
                i++;
            }
            input[j] = input[i];
        }
        input[i] = temp;
        return i;
    }

    private void swap(int[] input, int index1, int index2) {
        int temp = input[index1];
        input[index1] = input[index2];
        input[index2] = temp;
    }
    // When the input is too big
    // Use priorityQueue
    'Time complexity: O(nlgk), space complexity: O(k)'
    public int kthLargestWithHeap(int[] input, int k) {
        if (input.length < k || k == 0) {
            throw new IllegalArgumentException("K's value is illegal.\n");
        }
        PriorityQueue<Integer> window = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer int1, Integer int2) {
                return int1 - int2;
            }
        });
        for (int num : input) {
            if (window.size() < k) {
                window.add(num);
            }
            else if (num > window.peek()) {
                window.poll();
                window.add(num);
            }

        }
        return window.poll();
    }
}









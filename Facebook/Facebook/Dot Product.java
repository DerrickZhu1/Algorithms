22. Dot Product.
 A={a1, a2, a3,...}
 B={b1, b2, b3,...}
 dot_product = a1 * b1 + a2 * b2 + a3 * b3 ＋。。。
 如果数组很稀疏，例如
 A={a1, ...., a300, ...., a5000}
 B={...., b100, ..., b300, ..., b1000, ...}

  里面有很多0，用什么数据结构表示能节省空间。我开始说用hashmap，但是hashmap不能做有顺序的iteration。然后改用list和array，两个都可以。后面做题的时用的array。
  题目是：
  input A=[[1, a1], [300, a300], [5000, a5000]]
          B=[[100, b100], [300, b300], [1000, b1000]]
  求 dot product. 问了时间复杂度。
  Follow up:
  如果length(B) >>> length(A)，即B非常长，怎么做能减少时间复杂度。对A里面的每个数，用binary search找B中相对应的值，这样时间复杂度是O(nlogm) (n = len(A), m =len(B)).时间不够没写代码， 就说了一下思路和复杂度。
   
  第三题的输入就是稀疏数组的非0的数列出来了，A=[[1, a1], [300, a300], [5000, a5000]]的意思就是A中第1个数是a1,第300个是a300,第5000个是a5000，其他都是0.

  http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=199709&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311


class DotProduct {
    // Pair[1] - value, Pair[0] - index
    public int dotProduct(int[][] A, int[][] B) {
        int sum = 0;
        for (int[] pair : A) {
            int index = pair[0];
            int indexB = binarySearch(B, index);
            if (indexB != -1) {
                sum += pair[1] * B[indexB][1];
            }
        }
        return sum;
    }
    private int binarySearch(int[][] B, int index) {
        int low = 0;
        int high = B.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (B[mid][0] >= index) {
                high = mid;
            }
            else {
                low = mid;
            }
        }
        if (B[low][0] == index) {
            return low;
        }
        else if (B[high][0] == index) {
            return high;
        }
        return -1;
    }

    'Time complexity: O(max(LenA, LenB))'
    public int dotProduc(int[][] A, int[][] B) {
        int indexA = 0;
        int indexB = 0;
        int product = 0;
        while (indexA < A.length && indexB < B.length) {
            if (A[indexA][0] == B[indexB][0]) {
                product += A[indexA][1] * B[indexB][1];
                indexA++;
                indexB++;
            }
            else if (A[indexA][0] > B[indexB][0]) {
                indexB++;
            }
            else {
                indexA++;
            }
        }
        return product;
    }
}


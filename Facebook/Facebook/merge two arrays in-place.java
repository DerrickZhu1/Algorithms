4. merge two arrays in-place
例子：
a = [2,4,6,8, _, _, _, _]
b = [1,3,5,7]


public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end = m + n - 1;
        m--;
        n--;
        while (n >= 0) {
           if (m < 0 || nums1[m] < nums2[n])   nums1[end--] = nums2[n--];
           else                        nums1[end--] = nums1[m--];
        }
    }
}


Note：_代表空的位置，用以merge。a的actual length与b一样，并且a的空余位置足够放入b。a, b都是sorted array，要求in-place merge两个array。
感受：题目条件明确，简单思路就是从两个数列的尾部（这个例子中对于a是从8开始）比较，哪个更大就放在a的末端。需要注意到当a被遍历完后，要将b剩下的数字照搬到a的前端。
// merge from the tail
public void merge(int[] nums1, int m, int[] nums2, int n) {
    int index = m + n - 1;
    int poi1 = m - 1;
    int poi2 = n - 1;
    while (poi1 >= 0 && poi2 >= 0) {
        if (nums1[poi1] >= nums2[poi2]) {
            nums1[index] = nums1[poi1];
            poi1--;
        }
        else {
            nums1[index] = nums2[poi2];
            poi2--;
        }
        index--;
    }
    while (poi2 >= 0) {
        nums1[index--] = nums2[poi2--];
    }
}
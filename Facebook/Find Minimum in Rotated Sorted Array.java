public int findMin(int[] num) {
    int lo = 0, hi = num.length - 1;
    while (lo < hi && num[lo] > num[hi]) {
        int mid = (lo + hi) / 2;
        if (num[mid] > num[hi]) lo = mid + 1;
        else                    hi = mid;
    }
    return num[lo];
}

num[mid] > num[lo], num[mid] > num[hi]：mid 和 lo 在一侧，则移动 lo；
num[mid] < num[lo], num[mid] < num[hi]：mid 和 hi 在一侧，则移动 hi。

大就移动小
小就移动大

contains duplicates

不论 mid 在哪一侧：num[mid] == num[lo] or num[mid] == num[hi]，
则将 hi 后移一位（也可将 lo 前移一位）

public int findMin(int[] num) {
    int lo = 0, hi = num.length - 1;
    while (lo < hi && num[lo] >= num[hi]) {
        int mid = (lo + hi) / 2;
        if (num[mid] > num[hi])         lo = mid + 1;
        else if (num[mid] < num[hi])    hi = mid;
        else                            hi--;
    }
    return num[lo];
}





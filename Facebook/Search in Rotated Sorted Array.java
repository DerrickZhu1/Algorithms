Notice that there is always a half of the array sorted, so we only
need to see whether the target is in the sorted part or rotated part.

public int search(int[] A, int target) {
    int lo = 0;
    int hi = A.length - 1;
    while (lo < hi) {
        int mid = (lo + hi) / 2;
        if (A[mid] == target) return mid;
        
        if (A[lo] <= A[mid]) {
            if (target >= A[lo] && target < A[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        } else {
            if (target > A[mid] && target <= A[hi]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
    }
    return A[lo] == target ? lo : -1;
}

public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0)
        return -1;
    int l = 0;
    int r = nums.length - 1;
    while (l <= r) {
    	int m = (l + r) / 2;
    	if (target == nums[m])
    		return m;
    	if (nums[m] < nums[r]) {
    		if (target > nums[m] && target <= nums[r])
    			l = m + 1;
    		else
    		    r = m - 1;
    	} else {
    		if (target >= nums[l] && target < nums[m])
    			r = m - 1;
    		else
    			l = m + 1;
    	}
    }
    return -1;
}

What if duplicates are allowed ?

public boolean search(int[] A, int target) {
    int lo = 0, hi = A.length - 1;
    while (lo < hi) {
        int mid = (lo + hi) / 2;
        if (A[mid] == target)   return true;
        if (A[mid] < A[hi]) {   // [mid..hi] is inorder
            if (A[mid] < target && A[hi] >= target) lo = mid + 1;
            else                                    hi = mid;
        } else if (A[mid] > A[hi]) {    // [lo..mid] is inorder
            if (A[lo] <= target && A[mid] > target) hi = mid;
            else                                    lo = mid + 1;
        } else /* if (A[mid] == A[hi]) */ { // add this part for the duplicated case
            hi--;
        }
    }
    if (A[lo] == target)    return true;
    else                    return false;
}





















Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.

public int[] intersect(int[] nums1, int[] nums2) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    List<Integer> result = new ArrayList<Integer>();
    for (int i = 0; i < nums1.length; i++) {
        if (map.containsKey(nums1[i])) map.put(nums1[i], map.get(nums1[i]) + 1);
        else map.put(nums1[i], 1);
    }
    
    for (int i = 0; i < nums2.length; i++) {
        if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
            result.add(nums2[i]);
            // Minus 1
            map.put(nums2[i], map.get(nums2[i]) - 1);
         }
    }
    
    int[] r = new int[result.size()];
    for (int i = 0; i < result.size(); i++) {
           r[i] = result.get(i);
    }
    
    return r;
}


8. Longest consecutive sequence
// Use a hashMap to record the length of a consecutice sequence
// When meet a new number, lookup into hashMap for the adjcent number
// if exits, then we merge this number into consecutive sequence
// We only need to update the length at the end and start of the sequence
public int longestConsecutive(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int result = 1;
    for (int num : nums) {
        if (map.containsKey(num)) {
            continue;
        }
        int left = map.containsKey(num - 1) ? map.get(num - 1) : 0;
        int right = map.containsKey(num + 1) ? map.get(num + 1) : 0;
        int len = left + right + 1;
        map.put(num, len);
        map.put(num - left, len);
        map.put(num + right, len);
        result = Math.max(result, len);
    }
    return result;
}
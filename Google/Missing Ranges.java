public class Solution {
    public List<String> findMissingRanges(int[] A, int lower, int upper) {
        List<String> result = new ArrayList<String>();
        int pre = lower - 1;
        for (int i = 0 ; i <= A.length; i++) {
            int after = i == A.length ? upper + 1 : A[i]; 
            if (pre + 2 == after) {
                result.add(String.valueOf(pre + 1));
            } else if(pre + 2 < after){
                result.add(String.valueOf(pre + 1) + "->" + String.valueOf(after - 1));
            }
            pre = after;
        }
        return result;
    }
}

List<String> result = new ArrayList<>();
int pre = lower - 1;
for (int i = 0; i <= A.length; i++)
int after = i == A.length ? upper + 1 : A[i];
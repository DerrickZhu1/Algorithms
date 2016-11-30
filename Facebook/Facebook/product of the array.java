30. product of the array   给定一个array，返回里面元素乘积的所有可能值。 例如给定array:[1,2,3,4]   应该返回 [1, 2, 3, 4, 6, 8, 12, 24].
http://www.1point3acres.com/bbs/thread-199253-1-1.html

// Just Like find the subset of the array
'Time complexity: O(2^n)--number of subsets, space complexity: O(Len(input))'
class Product {
    public List<Integer> product(int[] input) {
        Set<Integer> result = new HashSet<>();
        Arrays.sort(input);
        helper(result, 1, 0, input, true);
        return new ArrayList<Integer>(set);
    }

    private void helper(Set<Integer> result, int curProduct, int pos, int[] input, boolean first) {
        if (!first) {
            result.add(curProduct);
        }
        first = false;
        for (int i = pos; i < input.length; i++) {
            if (i != pos && input[i] == input[i - 1]) {
                continue;
            }
            if (input[i] == 0) {
                result.add(0);
                continue;
            }
            curProduct *= input[i];
            helper(result, curProduct, i + 1, input, first);
            curProduct /= input[i];

        }
    }
}


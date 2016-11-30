Given a nested list of integers, return the sum of all integers in 
the list weighted by their depth.
Each element is either an integer, or a list -- whose 
elements may also be integers or other lists.

Given the list [[1,1],2,[1,1]], return 10. (four 1 s at depth 2, one 2 at depth 1)

Given the list [1,[4,[6]]], return 27. 
(one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)

public int depthSum(List<NestedInteger> nestedList) {
    return depthSum(nestedList, 1);
}

public int depthSum(List<NestedInteger> list, int depth) {
    int sum = 0;
    for (NestedInteger n : list) {
        if (n.isInteger()) {
            sum += n.getInteger() * depth;
        } else {
            sum += depthSum(n.getList(), depth + 1);
        }
    }
    return sum;
}

Different from the previous question where weight is increasing from root to leaf, 
now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, 
and the root level integers have the largest weight.

public class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
       return helper(nestedList, 0);
    }
    
    private int helper(List<NestedInteger> niList, int intSum) {
        //int intSum = prev;
        List<NestedInteger> levelBreak = new ArrayList<>();
        
        for (NestedInteger ni : niList) {
            if (ni.isInteger()) {
                intSum += ni.getInteger();
            } else {
                levelBreak.addAll(ni.getList());
            }
        }
        
        int listSum = levelBreak.isEmpty()? 0 : helper(levelBreak, intSum);
        
        return listSum + intSum;
    }
}


















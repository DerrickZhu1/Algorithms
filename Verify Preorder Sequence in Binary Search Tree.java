二叉搜索树先序遍历序列的特点是降序的部分一定是向左走的，一旦开始升序说明开始向右走了，
则上一个降序的点则限定了后面的数的最小值。
如果继续降序，说明又向左走了，这样等到下次向右走的时候也要再次更新最小值。
    10
   /  \
  5    12
 / \
2   6

如这个例子，我们在10的位置是没有最小值限定的，然后降序走到5，依然没有最小值，降序走到2，
依然没有，然后开始升序了，遇到6，这时候之后的数字一定大于2，同时也大于5，所以最小值更新为之前遍历过的，且比当前数稍微小一点的那个数。
这里我们可以用一个栈来暂存之前的路径，
所以升序时就是将栈中元素不断pop出来直到栈顶大于当前数，而最小值就是最后一个pop出来的数，
最后再把该数push进去。对于降序的时候，直接向里面push就行了。这样，序列无效的条件就是违反了这个最小值的限定。

public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stk = new Stack<Integer>();
        // 初始化最小值为最小整数
        int min = Integer.MIN_VALUE;
        for(int num : preorder){
            // 违反最小值限定则是无效的
            if(num < min) return false;
            // 将路径中所有小于当前的数pop出来并更新最小值
            while(!stk.isEmpty() && num > stk.peek()){
                min = stk.pop();
            }
            // 将当前值push进去
            stk.push(num);
        }
        return true;
    }
}

这里栈顶指针应初始化为-1，这样栈第一个元素加入时，i++后不会超界

public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        // 用i标记栈顶
        int i = -1, min = Integer.MIN_VALUE;
        for(int num : preorder){
            if(num < min) return false;
            // 同样的解法，但是复用了数组作为栈，每pop一次相当于i--
            while(i >= 0 && num > preorder[i]){
                min = preorder[i--];
            }
            // push相当于i++
            preorder[++i] = num;
        }
        return true;
    }
}

Q：如何验证中序序列？A：中序序列是有序的，只要验证其是否升序的就行了。

Q：如何验证后序序列？
A：后序序列的顺序是left - right - root，而先序的顺序是root - left - right。
我们同样可以用本题的方法解，不过是从数组的后面向前面遍历，因为root在后面了。
而且因为从后往前看是先遇到right再遇到left，所以我们要记录的是限定的最大值，而不再是最小值，
栈pop的条件也变成pop所有比当前数大的数。栈的增长方向也是从高向低了。

public boolean IsValidPostOrderBst(int[] nums) {
    int i = nums.length;
    int max = Integer.MAX_VALUE;
    for (int j = nums.length - 1; j >= 0; j--) {
        if (nums[j] > max) return false;
        while (i <= nums.length - 1 && nums[j] > nums[i])
            max = nums[i++];
        nums[--i] = nums[j];
    }
    return true;
}


















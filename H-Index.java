Sort First!

时间 O(NlogN) 空间 O(1)

public class Solution {
    public int hIndex(int[] citations) {
        // 排序
        Arrays.sort(citations);
        int h = 0;
        for (int i = 0; i < citations.length; i++) {
            // 得到当前的H指数
            int currH = Math.min(citations[i], citations.length - i);
            if (currH > h) {
                h = currH;
            }
        }
        return h;
    }
}

数组映射法
复杂度
时间 O(N) 空间 O(N)

public class Solution {
    public int hIndex(int[] citations) {
        int[] stats = new int[citations.length + 1];
        int n = citations.length;
        // 统计各个引用次数对应多少篇文章
        for(int i = 0; i < n; i++){
            stats[citations[i] <= n ? citations[i] : n] += 1;
        }
        int sum = 0;
        // 找出最大的H指数
        for(int i = n; i > 0; i--){
            // 引用大于等于i次的文章数量，等于引用大于等于i+1次的文章数量，加上引用等于i次的文章数量 
            sum += stats[i];
            // 如果引用大于等于i次的文章数量，大于引用次数i，说明是H指数
            if(sum >= i){
                return i;
            }
        }
        return 0;
    }
}


Preferred!
public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int l = 0, r = citations.length;
        int n = citations.length;
        while(l < r){
            int mid = l + (r - l) / 2;
            if(citations[mid] == n - mid) return n - mid;
            if(citations[mid] < citations.length - mid) l = mid + 1;
            else r = mid;
        }
        return n - l;
    }
}


public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if(n == 0) return 0;
        int min = 0, max = citations.length - 1;
        while(min <= max){
            int mid = (min + max) / 2;
            // 如果该点是有效的H指数，则最大H指数一定在右边
            if(citations[mid] < n - mid){
                min = mid + 1;
            // 否则最大H指数在左边
            } else {
                max = mid - 1;
            }
        }
        // n - min是min点的H指数
        return n - min;
    }
}













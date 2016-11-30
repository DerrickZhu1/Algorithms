There are n coins with different value in a line. 
Two players take turns to take one or two coins from left side until 
there are no more coins left. The player who take the coins with the most value wins.


定义dp[i]表示从i到end能取到的最大值

1.若取values[i]，对方可以取values[i+1] 或者values[i+1] + values[i+2]
当对方取values[i+1] 后 ，我们只能从 i+2 到end内取，我们所取得最大值是dp[i+2], 
注意：对方所选取的结果一定是使得我们以后选取的值最小
当对方取values[i+1] + values[i+2]后，我们只能从i+3到end内取，我们所取得最大值是dp[i+3]。
此时：dp[i] = values[i] + min(dp[i+2],dp[i+3]) , 注意：对方所选取的结果一定是使得我们以后选取的值最小

2.若取values[i] + values[i+1],对方可取values[i+2] 或者values[i+2] + values[i+3]
当对方取values[i+2]后，我们只能从i+3到end内取，我们取得最大值是dp[i+3]
当对方取values[i+2]+values[i+3]后，我们只能从i+4到end内去，我们取得最大值是dp[i+4]
此时：dp[i] = values[i] + values[i+1]+min(dp[i+3],dp[i+4])

最后我们可以取上面两个dp[i]的最大值，就是答案，这里意思是：对方留得差的方案中，我们选取的最大值。


public boolean firstWillWin(int[] values) {
    // write your code here
    if (values == null || values.length == 0) return false;
     int n = values.length;
     if (n < 3) return true;
     int[] dp = new int[n+1];
     dp[n] = 0;
     dp[n-1] = values[n-1];
     dp[n-2] = values[n-1]+values[n-2];
     dp[n-3] = values[n-2]+values[n-3];
     for (int i = n-4; i >= 0; i--) {
        dp[i] = Math.max(values[i] + Math.min(dp[i+2], dp[i+3]), values[i] + values[i+1] + Math.min(dp[i+3], dp[i+4]));
     }
     int sum = 0;
     for (int v: values) sum += v;
     return dp[0] > sum - dp[0];
}


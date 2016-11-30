Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction 
(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

public int maxProfit(int[] prices) {
    // d(i) = max{d(i - 1), current profit}
    int N = prices.length;
    if (N < 2)  return 0;
    int profit = 0, min = prices[0];
    for (int i = 1; i < N; i++) {
        min = Math.min(min, prices[i]);
        profit = Math.max(profit, prices[i] - min);
    }
    return profit;
}

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions 
as you like (ie, buy one and sell one share of the stock multiple times). 
However, you may not engage in multiple transactions at the same time 
(ie, you must sell the stock before you buy again).


// if pricse keep increase, the result will be the same as buy at first day and 
// sell at last day

public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0)
		return 0;
	int res = 0;
	for (int i = 0; i < prices.length - 1; i++) {
		int diff = prices[i + 1] - prices[i];
		// 当天卖当天买
		if (diff > 0)
			res += diff;
	}
	return res;
}

可以随便交易很多次，可以同时买很多股票，但是一旦卖就要把手里的股票全部卖了，问怎样最大化收益。比如[1, 2, 3], 前2天都买，第三天全部卖，收益就是(3-1)+(3-2).
stock sell all
public int maxProfit(int[] prices) {
    int max = 0;
    int profit = 0;
    for (int i = prices.length - 1; i >= 0; i--) {
        if (max > prices[i]) {
            profit += max - prices[i];
            System.out.println(profit);
        }
        else {
            max = prices[i];
        }
    }
    return profit;
}



Design an algorithm to find the maximum profit. 
You may complete at most k transactions.

/**
 * dp[i, j] represents the max profit up until prices[j] using at most i transactions. 
 * dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
 *          = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
 * dp[0, j] = 0; 0 transactions makes 0 profit
 * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
 */

public int maxProfit(int k, int[] prices) {
	int n = prices.length;
	if (n <= 1)
		return 0;
	
	//if k >= n/2, then you can make maximum number of transactions.
	if (k >=  n/2) {
		int maxPro = 0;
		for (int i = 1; i < n; i++) {
			if (prices[i] > prices[i-1])
				maxPro += prices[i] - prices[i-1];
		}
		return maxPro;
	}
	
    int[][] dp = new int[k+1][n];
    for (int i = 1; i <= k; i++) {
    	int localMax = dp[i-1][0] - prices[0];
    	for (int j = 1; j < n; j++) {
    		dp[i][j] = Math.max(dp[i][j-1],  prices[j] + localMax);
    		localMax = Math.max(localMax, dp[i-1][j] - prices[j]);
    	}
    }
    return dp[k][n-1];
}


Design an algorithm to find the maximum profit. 
You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)

https://discuss.leetcode.com/topic/30431/easiest-java-solution-with-explanations

buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);   
sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);

b0 = Math.max(b1, s2 - prices[i]);
s0 = Math.max(s1, b1 + prices[i]);

public int maxProfit(int[] prices) {
    if(prices == null || prices.length <= 1) return 0;
  
    int b0 = -prices[0], b1 = b0;
    int s0 = 0, s1 = 0, s2 = 0;
 
    for(int i = 1; i < prices.length; i++) {
    	b0 = Math.max(b1, s2 - prices[i]);
    	s0 = Math.max(s1, b1 + prices[i]);
    	b1 = b0; s2 = s1; s1 = s0; 
    }
    return s0;
}






















package dynamicProgramming;

//the Cooldown is k days instead of 1;
public class BuySellStockCooldownII {
	//  buy[i] = Math.max(buy[i - 1], sell[i - k - 1] - prices[i]);
	// sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
	public int maxProfit(int[] prices, int k) {
		int n = prices.length;
		int[] buy = new int[n];
		int[] sell = new int[n];
		buy[0] = -prices[0];
		for (int i = 1; i < n; i++) {
			buy[i] = Math.max(buy[i - 1], (i - k - 1 < 0 ? 0 : sell[i - k - 1]) - prices[i]);
			sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
		}
		return sell[n - 1];
	}

}

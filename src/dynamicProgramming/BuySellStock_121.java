package dynamicProgramming;


public class BuySellStock_121 {
	// runtime exception when length is large
	public int maxProfit(int[] prices) {
		if (prices.length == 0)
			return 0;
		int max = 0;

		for (int j = 0; j < prices.length; j++) {
			int buy = prices[j];
			for (int i = j + 1; i < prices.length; i++) {
				if (prices[i] > buy)
					max = Math.max(max, prices[i] - buy);

			}
		}
		return max;

	}

	// 就是 max subarray problem问题 的变形
	// 当把数组改成每天的涨跌情况 就是求 max subarray problem 使和最大
	// Input: [7, 1, 5, 3, 6, 4] => [0,-6,4,-2,3,-2]
	// 用Kadane算法 只遍历一遍数组
	// 当前面那些差加起来小于0 就不要了
	public int maxProfit2(int[] prices) {
		int sum = 0, maxSoFar = 0;
		for (int i = 1; i < prices.length; i++) {
			sum += prices[i] - prices[i - 1];
			if (sum < 0)
				sum = 0;
			maxSoFar = Math.max(sum, maxSoFar);
		}
		return maxSoFar;
	}

	// 然后用Kadane算法 的思想 针对这道题更容易理解的方法
	// 当发现了比之前最小的那个数更小的数 之前那个就不要了
	// 思想！！！
	public int maxProfit3(int[] prices) {
		if (prices.length == 0)
			return 0;
		int max = 0;
		int sofarmin = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > sofarmin)
				max = Math.max(max, prices[i] - sofarmin);
			else
				sofarmin = prices[i];
		}

		return max;

	}
}

package dynamicProgramming;


public class BuySellStock_121 {
	// public int maxProfit(int[] prices) {
	// 不敢相信我竟然写出这么傻逼的代码
	// TreeSet<Integer> set;
	// TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<Integer,
	// TreeSet<Integer>>();
	// for (int i = 0; i < prices.length; i++) {
	//
	// if (!map.containsKey(prices[i]))
	// set = new TreeSet<Integer>();
	// else
	// set = map.get(prices[i]);
	// set.add(i);
	// map.put(prices[i], set);
	// }
	// //leetcode中没有Entry 这个算法虽然我的思路是清晰的 但是看起来太丑了
	// Entry<Integer, TreeSet<Integer>> s,l;
	// s= map.firstEntry();
	// l=map.lastEntry();
	// while(true)
	// {int a=0,b=0;
	// if (s.getValue().first() < l.getValue().last())
	// return l.getKey() - s.getKey();
	// else {
	//
	// if (map.higherEntry(s.getKey()).getValue().first() < l.getValue().last())
	//
	// a= l.getKey() - map.higherEntry(s.getKey()).getKey();
	//
	// if (s.getValue().first()<map.lowerEntry(l.getKey()).getValue().last())
	// b=map.lowerEntry(l.getKey()).getKey() - s.getKey();
	//
	// if (a==00&&b==0)
	// {s=map.higherEntry(s.getKey());
	// l=map.lowerEntry(l.getKey()); }
	// else return Math.max(a, b);
	// }
	// }
	// }

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
		int maxCur = 0, maxSoFar = 0;
		for (int i = 1; i < prices.length; i++) {
			maxCur += prices[i] - prices[i - 1];
			if (maxCur < 0)
				maxCur = 0;
			maxSoFar = Math.max(maxCur, maxSoFar);
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

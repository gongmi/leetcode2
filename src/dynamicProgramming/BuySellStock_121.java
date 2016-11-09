package dynamicProgramming;


public class BuySellStock_121 {
	// public int maxProfit(int[] prices) {
	// ���������Ҿ�Ȼд����ôɵ�ƵĴ���
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
	// //leetcode��û��Entry ����㷨��Ȼ�ҵ�˼·�������� ���ǿ�����̫����
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

	// ���� max subarray problem���� �ı���
	// ��������ĳ�ÿ����ǵ���� ������ max subarray problem ʹ�����
	// Input: [7, 1, 5, 3, 6, 4] => [0,-6,4,-2,3,-2]
	// ��Kadane�㷨 ֻ����һ������
	// ��ǰ����Щ�������С��0 �Ͳ�Ҫ��
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

	// Ȼ����Kadane�㷨 ��˼�� ����������������ķ���
	// �������˱�֮ǰ��С���Ǹ�����С���� ֮ǰ�Ǹ��Ͳ�Ҫ��
	// ˼�룡����
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

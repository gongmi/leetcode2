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

	// ���� max subarray problem���� �ı���
	// ��������ĳ�ÿ����ǵ���� ������ max subarray problem ʹ�����
	// Input: [7, 1, 5, 3, 6, 4] => [0,-6,4,-2,3,-2]
	// ��Kadane�㷨 ֻ����һ������
	// ��ǰ����Щ�������С��0 �Ͳ�Ҫ��
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

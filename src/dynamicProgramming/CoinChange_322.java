package dynamicProgramming;

import java.util.Arrays;
//��Ϊ������������  ���Զ��ڿ����ظ�(Permutation)�Ͳ������ظ�(Combination)��˵ ��������һ���� 
//���Ը���CombinationSum4_377(Permutation)��CoinChange2_518(Combination)�������Ĵ���һ����

public class CoinChange_322 {
	// ��ǰ�Ĵ� ����CombinationSum4_377����
	// top��Ҳ��������
	public int coinChange(int[] coins, int amount) {
		int[] res = new int[amount + 1];
		for (int i = 1; i <= amount; i++)
			res[i] = -1;

		for (int i = 1; i <= amount; i++) {
			int min = Integer.MAX_VALUE;
			for (int coin : coins)
				if (i >= coin && res[i - coin] != -1) {
					res[i] = Math.min(res[i - coin] + 1, min);
					min = res[i];
				}
		}
		return res[amount];
	}

	// ����CoinChange2_518֮��� ��ȫ������
	// dp[i][j] ��ʾ ʹ��ǰi��coin ����� amount j ��Ҫ������coin����
	// ����Ϊdp[i][j] =min(1 + dp[i][j - w[i]], dp[i-1][j])

	// ��������ע����� ʹ��ǰi��coin ��������� amount j
	// ��������������dp[i][j]= Integer.MAX_VALUE-1������ ������
	// ��ʼ����Ϊ
	// dp[0][j]= Integer.MAX_VALUE-1; j��1��amount ����˵ ��û��coin �޷���� amount
	// ���� dp[0][0]=0;�� 0��coin ���amountΪ0 ��Ҫ������coin����Ϊ0
	// ��ά��������Ա�Ϊ
	// dp[j] =min(1 + dp[j - w[i]], dp[j])
	public int coinChange2(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, Integer.MAX_VALUE - 1);
		dp[0] = 0;
		for (int coin : coins) {
			for (int j = coin; j <= amount; j++) {
				dp[j] = Math.min(dp[j], 1 + dp[j - coin]);
			}
		}
		return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];

	}
}

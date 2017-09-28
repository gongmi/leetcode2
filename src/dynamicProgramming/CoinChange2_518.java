package dynamicProgramming;

//������CombinationSum4_377����
//ֻ��CombinationSum4_377 �ǿ������ظ���(Permutation) ֻҪ˳��һ��
//���������ȥ�ص� Ҳ���� (Combination)
//����һ����ȫ��������
//����Ϊdp[i][j] = dp[i-1][j]+dp[i][j - w[i]]
//dp[i][j] ��ʾ ʹ��ǰi��coin  ����� amount j �ж����ַ�ʽ
//���Ա�Ϊdp[j] = dp[j] + dp[j - w[i]]; ����j��С����
//��ϸ�۲��������CombinationSum4_377�Ĳ�֮ͬ�� ���Է��� ��������
//����forѭ����λ��
//��ϸ���� �·�������������е�����
public class CoinChange2_518 {
	public int change(int amount, int[] coins) {
		int[] dp = new int[amount + 1];
		dp[0] = 1;
		for (int coin : coins) {
			for (int j = coin; j <= amount; j++) {
				dp[j] = dp[j] + dp[j - coin];
			}
		}
		return dp[amount];

	}
}

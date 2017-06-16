package dynamicProgramming;

//������CombinationSum4_377����
//ֻ��CombinationSum4_377�����ж��������
//��������� ���ٵĸ���
//��top��һ��
public class CoinChange_322 {
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
}

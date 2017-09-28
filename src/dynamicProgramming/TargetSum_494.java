package dynamicProgramming;

//��һ�ַ��� backTracking ���Ǻ��� 
//����ⲻ��Ҫ���ÿ�־������ ֻ��Ҫһ���� ˵������dp
public class TargetSum_494 {
	int res = 0;

	public int findTargetSumWays(int[] nums, int S) {
		helper(nums, 0, S);
		return res;
	}

	private void helper(int[] nums, int k, int S) {
		if (k == nums.length) {
			if (S == 0)
				res++;
			return;
		}
		helper(nums, k + 1, S + nums[k]);
		helper(nums, k + 1, S - nums[k]);
	}

	// 01 ���� ����ת��Ϊһ�� ��������ѡ���ɸ��� ��Ϊtarget �м��ַ���
	// ��CoinChange2_518����
	// ����CoinChange2_518����ȫ���� ��ÿ��������ʹ�ö��
	// ��PartitionEqualSubsetSum_416����
	// ����PartitionEqualSubsetSum_416�����Ƿ���� �����������
	// dp[i][j] = dp[i-1][j]+dp[i-1][j - w[i]]
	public int findTargetSumWays2(int[] nums, int S) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum < S)
			return 0;
		int target = (sum + S);
		if ((target & 1) == 1)
			return 0;
		target /= 2;

		int[] dp = new int[target + 1];
		dp[0] = 1;
		for (int num : nums) {
			for (int j = target; j >= num; j--)
				dp[j] += dp[j - num];
		}
		return dp[target];
	}
}

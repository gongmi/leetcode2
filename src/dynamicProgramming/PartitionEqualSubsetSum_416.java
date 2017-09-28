package dynamicProgramming;

public class PartitionEqualSubsetSum_416 {
	// ��dp[i][j]��ʾǰi�����Ƿ���ܵõ�weightΪj
	// ������ value��weight ��ʵ����nums��ֵ
	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if (sum % 2 != 0)
			return false;
		sum /= 2;
		int weight = sum;
		boolean[][] dp = new boolean[nums.length + 1][weight + 1];
		for (int i = 0; i <= nums.length; i++) {
			dp[i][0] = true;
		}
		for (int i = 1; i <= nums.length; i++) {
			for (int j = 1; j <= weight; j++) {
				if (nums[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
				} else
					dp[i][j] = dp[i - 1][j];
			}
		}
		return dp[nums.length][weight];
	}

	// �Ѷ�ά��dp�����Ż�Ϊ��һά��
	// ���ǵڶ���ѭ������Ӵ�С
	// ��Ϊ��dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];

	// ��ô ��i-1 ʱ ������ dp[i-1][j] j��0 ��len
	// ��iѭ����i ʱ ��������ʽ�ȼ�
	// dp[j] = dp[j] || dp[j - nums[i]]
	// dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]]

	// Ҳ����˵ dp[j]�� dp[j - nums[i]] ����֮ǰi-1ʱ�������dp
	// ��������Ҵ�С����ȥ����j��ô dp[j - nums[i]] �����Ҹո����С��j
	// �� dp[i][j] = dp[i - 1][j] || dp[i][j - nums[i]]
	// �����Ͳ�����
	public boolean canPartition2(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if (sum % 2 != 0)
			return false;
		sum /= 2;
		boolean[] dp = new boolean[sum + 1];
		dp[0] = true;

		for (int num : nums) {
			// �Ӵ�С
			for (int j = sum; j >= num; j--) {
				dp[j] = dp[j] || dp[j - num];
				if (dp[sum])
					return true;
			}

		}
		return false;
	}
}

package dynamicProgramming;

public class PartitionEqualSubsetSum_416 {
	// http://www.cnblogs.com/shinning/p/6027743.html
	// 01��������
	// ������0-1�����������ơ�������dp[i][j]����ʾ���������jʱ��ǰi��Ԫ�ص����͡�
	// �ɵó����ƹ�ʽΪ
	// dp[i][j] = Math.max(dp[i - 1][j - nums[i]] + nums[i], dp[i -1][j]),
	// ����j >= nums[i].��dp[i][sum] = sum��������װ��ʱ���򷵻�true��
	
//	��ϸ�������֣��ڱ�������У�ÿ��ѭ��dp[i][j]ֻ����һ��ѭ���õ���dp[i -1][x]�йأ�
//	��ֻ��Ҫһά���飬ÿ�θ�������ֵ���ɡ�
//	����������¡�ע��ڶ���ѭ����jҪ�Ӵ�С������
//	ԭ�����ڸ�������Ĺ����б���ʹ�õ����θ��µ�����Ԫ�ء�
	public class Solution {
		public boolean canPartition(int[] nums) {
			int sum = 0;
			for (int i = 0; i < nums.length; i++) {
				sum += nums[i];
			}
			if (sum % 2 != 0)
				return false;
			sum /= 2;
			boolean[] dp = new boolean[sum + 1];
			dp[0] = true;
			
			for (int i = 0; i < nums.length; i++) {
				for (int j = sum; j >= nums[i]; j--) {
					dp[j] = dp[j] || dp[j - nums[i]];
					if (dp[sum])
						return true;
				}
			}
			return false;
		}
	}
}

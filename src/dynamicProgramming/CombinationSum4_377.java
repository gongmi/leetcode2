package dynamicProgramming;

//��70��¥���ǵ�����һ����˼· �ҳ�һ���ݹ��ϵʽ��Ȼ���ñ����ķ�ʽ
//�����ҳ�����ݹ��ϵʽ�Ͳ��� ��ʵһ��ʼ���뵽�˵� ���ǻ��Ƕ��Լ�û������ 
// bottom-up �Ե����� 
public class CombinationSum4_377 {
	public int combinationSum4(int[] nums, int target) {

		int[] res = new int[target + 1];
		res[0] = 1;
		for (int i = 1; i <= target; i++)
			for (int num : nums)
				if (i - num >= 0)
					res[i] += res[i - num];

		return res[target];
	}
	// ���˵��Զ�����
	// private int[] dp;

	// public int combinationSum4(int[] nums, int target) {
	// dp = new int[target + 1];
	// Arrays.fill(dp, -1);
	// dp[0] = 1;
	// return helper(nums, target);
	// }
	//
	// private int helper(int[] nums, int target) {
	// if (dp[target] != -1) {
	// return dp[target];
	// }
	// int res = 0;
	// for (int i = 0; i < nums.length; i++) {
	// if (target >= nums[i]) {
	// res += helper(nums, target - nums[i]);
	// }
	// }
	// dp[target] = res;
	// return res;
	// }
}

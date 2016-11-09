package dynamicProgramming;
//��70��¥���ǵ�����һ����˼· �ҳ�һ���ݹ��ϵʽ��Ȼ���ñ����ķ�ʽ
//�����ҳ�����ݹ��ϵʽ�Ͳ��� ��ʵһ��ʼ���뵽�˵� ���ǻ��Ƕ��Լ�û������ 
// bottom-up �Ե����� 
public class CombinationSum4_377 {
	public int combinationSum4(int[] nums, int target) {

		int sum[] = new int[target + 1];
		sum[0] = 1;
		for (int j = 1; j < target + 1; j++) {
			sum[j] = 0;
			for (int i = 0; i < nums.length; i++)
				if (j >= nums[i])
					sum[j] = sum[j] + sum[j - nums[i]];

		}
		return sum[target];
	}
//���˵��Զ�����	
//	private int[] dp;

//	public int combinationSum4(int[] nums, int target) {
//	    dp = new int[target + 1];
//	    Arrays.fill(dp, -1);
//	    dp[0] = 1;
//	    return helper(nums, target);
//	}
//
//	private int helper(int[] nums, int target) {
//	    if (dp[target] != -1) {
//	        return dp[target];
//	    }
//	    int res = 0;
//	    for (int i = 0; i < nums.length; i++) {
//	        if (target >= nums[i]) {
//	            res += helper(nums, target - nums[i]);
//	        }
//	    }
//	    dp[target] = res;
//	    return res;
//	}
}

package dynamicProgramming;

//第一种方法 backTracking 但是很慢 
//这道题不需要输出每种具体情况 只需要一个数 说明是用dp
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
}

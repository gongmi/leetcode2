package dynamicProgramming;

//与70爬楼梯那道题是一样的思路 找出一个递归关系式，然后用备忘的方式
//但是找出这个递归关系式就不简单 其实一开始我想到了的 但是还是对自己没有信心 
// bottom-up 自底向上 
//其实就是Permutation 因为与顺序有关
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
	// 别人的自顶向下
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

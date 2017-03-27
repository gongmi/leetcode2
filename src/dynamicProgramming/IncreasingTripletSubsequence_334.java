package dynamicProgramming;

public class IncreasingTripletSubsequence_334 {
	// 模仿LongestIncreasingSubsequence_300 的方法
	// 只是不需要用binarysearch了 因为只比较两个数
	// 并且要注意 相等时也替换 因为这样可以简化判断条件 可以节约时间
	public boolean increasingTriplet(int[] nums) {
		if (nums.length < 3)
			return false;
		int dp1 = nums[0];
		int dp2 = Integer.MAX_VALUE;
		int len = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] <= dp1)
				dp1 = nums[i];
			else if (nums[i] <= dp2)
				dp2 = nums[i];
			else
				return true;
		}
		return false;
	}

	// 第二次做的答案 仿佛更简化一些
	public boolean increasingTriplet2(int[] nums) {
		int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
		for (int num : nums) {
			if (num <= first)
				first = num;
			else if (num <= second)
				second = num;
			else
				return true;
		}
		return false;
	}
}

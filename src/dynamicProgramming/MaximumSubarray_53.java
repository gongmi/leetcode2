package dynamicProgramming;

public class MaximumSubarray_53 {
	// 用Kadane算法 只遍历一遍数组
	// 当前面那些差加起来小于0 就不要了
	// 但是和传统的最大子数组不一样的地方是 子数组长度至少为1 就是说至少要选一个
	// 所以当全为负数时 0是不对的 应该是负数当中的最大数 就这个地方不一样 所以多加一个max来保存数组中最大的数
	public int maxSubArray(int[] nums) {

		int max = Integer.MIN_VALUE;
		int maxSoFar = 0;
		int maxCur = 0;
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
			maxCur = maxCur + nums[i];
			if (maxCur < 0)
				maxCur = 0;
			if (maxCur > maxSoFar)
				maxSoFar = maxCur;
		}
		if (max < 0)
			return max;
		return maxSoFar;
	}

	// 受MaximumSubarrayProduct_152启发的第二版答案
	// 因为这道题必须选一个！
	// 所以一开始先选一个
	// sum = Math.max(sum + nums[i], nums[i]);
	// 并且sum要么是一个 要么是这个加上前面的多个

	// 剑指offer p173有公式

	public int maxSubArray2(int[] nums) {
		int sum = nums[0];
		int maxSofar = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sum = Math.max(sum + nums[i], nums[i]);
			maxSofar = Math.max(sum, maxSofar);
		}
		return maxSofar;
	}

	// 2017.08.22 与上面一样的思路
	public int maxSubArray3(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int max = nums[0];
		int res = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (max < 0) {
				max = nums[i];
			} else {
				max = max + nums[i];
			}
			res = Math.max(res, max);
		}
		return res;
	}
}

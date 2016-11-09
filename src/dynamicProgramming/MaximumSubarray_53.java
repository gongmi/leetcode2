package dynamicProgramming;
//	// 用Kadane算法 只遍历一遍数组
// 当前面那些差加起来小于0 就不要了
//但是和传统的最大子数组不一样的地方是 子数组长度至少为1 就是说至少要选一个
//所以当全为负数时 0是不对的 应该是负数当中的最大数  就这个地方不一样
public class MaximumSubarray_53 {
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
}

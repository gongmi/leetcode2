package dynamicProgramming;
//	// 用Kadane算法 只遍历一遍数组
// 当前面那些差加起来小于0 就不要了
//但是和传统的最大子数组不一样的地方是 子数组长度至少为1 就是说至少要选一个
//所以当全为负数时 0是不对的 应该是负数当中的最大数  就这个地方不一样 所以多加一个max来保存数组中最大的数
public class MaximumSubarray_53 {
	public int maxSubArray(int[] nums) {

		int max = Integer.MIN_VALUE;
		int maxSoFar = 0;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
			sum = sum + nums[i];
			if (sum < 0)
				sum = 0;
			if (sum > maxSoFar)
				maxSoFar = sum;
		}
		if (max < 0)
			return max;
		return maxSoFar;
	}
}

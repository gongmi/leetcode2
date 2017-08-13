package twoPointers;

public class MinimumSizeSubarraySum_209 {
	public int minSubArrayLen(int s, int[] nums) {
		int i = 0, j = 0, sum = 0, res = Integer.MAX_VALUE;

		while (true) {
			if (sum < s) {
				if (j < nums.length)
					sum += nums[j++];
				else
					break;
			} else {
				res = Math.min(j - i, res);
				if (res == 1)
					break;
				sum -= nums[i++];
			}
		}
		return res == Integer.MAX_VALUE ? 0 : res;
	}

	// top答案 思想一样只是在减的时候 他用的while 用的好
	public int minSubArrayLen2(int s, int[] nums) {
		int i = 0, j = 0, sum = 0, res = Integer.MAX_VALUE;

		while (j < nums.length) {
			sum += nums[j++];

			while (sum >= s) {
				res = Math.min(res, j - i);
				sum -= nums[i++];
			}
		}

		return res == Integer.MAX_VALUE ? 0 : res;
	}
}

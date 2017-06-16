package twoPointers;

public class MinimumSizeSubarraySum_209 {
	public int minSubArrayLen(int s, int[] nums) {
		int left = 0, right = 0, val = 0, res = Integer.MAX_VALUE;

		while (true) {
			if (val < s) {
				if (right < nums.length)
					val += nums[right++];
				else
					break;
			} else {
				res = Math.min(right - left, res);
				if (res == 1)
					break;
				val -= nums[left++];
			}
		}
		return res == Integer.MAX_VALUE ? 0 : res;
	}

	// top答案 思想一样只是在减的时候 他用的while 用的好
	public int minSubArrayLen2(int s, int[] a) {
		int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

		while (j < a.length) {
			sum += a[j++];

			while (sum >= s) {
				min = Math.min(min, j - i);
				sum -= a[i++];
			}
		}

		return min == Integer.MAX_VALUE ? 0 : min;
	}
}

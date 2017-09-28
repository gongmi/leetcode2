package Array;

import java.util.Arrays;

//这道题应该叫LongestIncreasingSubArray 才对
public class LongestContinuousIncreasingSubsequence_674 {
	// 我的答案 就是两个指针动动 嘛 和MinimumSizeSubarraySum_209相似
	// 这个题还更简单
	public int findLengthOfLCIS(int[] nums) {
		if (nums.length <= 1)
			return nums.length;
		int left = 0;
		int right = 1;
		int res = 1;
		while (right < nums.length) {
			if (nums[right] > nums[right - 1])
				right++;
			else {
				res = Math.max(res, right - left);
				left = right;
				right = left + 1;
			}
		}
		res = Math.max(res, right - left);
		return res;
	}

	// top
	public int findLengthOfLCIS2(int[] nums) {
		int res = 0, cnt = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0 || nums[i - 1] < nums[i])
				res = Math.max(res, ++cnt);
			else
				cnt = 1;
		}
		return res;
	}
}

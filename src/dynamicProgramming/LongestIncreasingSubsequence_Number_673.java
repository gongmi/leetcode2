package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
// 就是用的LongestIncreasingSubsequence_300的第一种
// 动态规划 时间复杂度为O(n*n)
// 就是再加上另一个数组 用来存放当前这个位置的LIS的个数

public class LongestIncreasingSubsequence_Number_673 {

	public int findNumberOfLIS(int[] nums) {
		int[] maxLen = new int[nums.length];
		int[] numbers = new int[nums.length];
		Arrays.fill(maxLen, 1);
		int maxLength = 1;
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j])
					maxLen[i] = Math.max(maxLen[i], maxLen[j] + 1);
			}
			maxLength = Math.max(maxLength, maxLen[i]);
		}

		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (maxLen[i] == 1) {
				numbers[i] = 1;
			} else {
				for (int j = 0; j < i; j++) {
					if (nums[i] > nums[j] && maxLen[i] == maxLen[j] + 1)
						numbers[i] += numbers[j];
				}
			}
			if (maxLen[i] == maxLength)
				res += numbers[i];
		}
		return res;
	}
}

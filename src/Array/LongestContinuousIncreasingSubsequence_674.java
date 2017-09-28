package Array;

import java.util.Arrays;

//�����Ӧ�ý�LongestIncreasingSubArray �Ŷ�
public class LongestContinuousIncreasingSubsequence_674 {
	// �ҵĴ� ��������ָ�붯�� �� ��MinimumSizeSubarraySum_209����
	// ����⻹����
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

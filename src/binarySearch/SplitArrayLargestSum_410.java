package binarySearch;

public class SplitArrayLargestSum_410 {
	public int splitArray(int[] nums, int m) {
		int sum = 0;
		int max = 0;
		for (int num : nums) {
			sum += num;
			max = Math.max(num, max);
		}
		int left = max;
		int right = sum;

		while (left < right) {
			int mid = left + (right - left) / 2;
			if (valid(nums, mid, m)) {
				right = mid;

			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	// 段数大于m 返回false 说明 mid太小
	// 段数小于等于m 返回true 说明 mid可能太大
	private boolean valid(int[] nums, int target, int m) {
		int cur = 0;
		int count = 1;
		for (int num : nums) {
			if (cur + num <= target)
				cur += num;
			else {
				count++;
				cur = num;
			}
		}
		return count <= m;
	}
}

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

	// ��������m ����false ˵�� mid̫С
	// ����С�ڵ���m ����true ˵�� mid����̫��
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

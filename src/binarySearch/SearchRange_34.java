package binarySearch;
//就是剑指offer 34
//用的书上的思路 只不过 两个辅助函数是用的循环 而不是书上的递归
public class SearchRange_34 {
	public int[] searchRange(int[] nums, int target) {
		int start = First(nums, target, 0, nums.length - 1);
		int end = Last(nums, target, 0, nums.length - 1);
		if (start == -1)
			return new int[] { -1, -1 };
		return new int[] { start, end };
	}

	private int First(int[] nums, int target, int left, int right) {
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < target)
				left = mid + 1;
			else if (nums[mid] > target)
				right = mid - 1;
			else if (mid == 0 || nums[mid - 1] != target)
				return mid;
			else
				right = mid - 1;
		}
		return -1;
	}

	private int Last(int[] nums, int target, int left, int right) {
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < target)
				left = mid + 1;
			else if (nums[mid] > target)
				right = mid - 1;
			else if (mid == nums.length - 1 || nums[mid + 1] != target)
				return mid;
			else
				left = mid + 1;
		}
		return -1;
	}
}

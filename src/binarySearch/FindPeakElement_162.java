package binarySearch;

public class FindPeakElement_162 {
	public int findPeakElement(int[] nums) {
		if (nums.length == 1)
			return 0;
		int left = 0;
		int right = nums.length - 1;
		int mid = 0;
		if (nums[right] > nums[right - 1])
			return right;

		if (nums[left] > nums[left + 1])
			return left;

		while (left < right) {
			mid = (left + right) / 2;
			if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
				return mid;

			else if (nums[mid] < nums[mid - 1])
				right = mid;
			else if (nums[mid] < nums[mid + 1])
				left = mid;
		}

		return mid;
	}
}

package binarySearch;

public class RotatedSortedArraySearchII_81 {
	// RotatedSortedArraySearch_33+RotatedSortedArrayFindMinII_154
	// 用简单粗暴的方式解决duplicate产生的问题
	public boolean search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target)
				return true;

			
			if (nums[mid] < nums[right]) {
				if (nums[mid] > target || target > nums[right])
					right = mid - 1;
				else
					left = mid + 1;
			} else if (nums[mid] > nums[right]) {
				if (nums[mid] < target || target < nums[left])
					left = mid + 1;
				else
					right = mid - 1;
			} else
				right--;

		}
		return false;
	}

}

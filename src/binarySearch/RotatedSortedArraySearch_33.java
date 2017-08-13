package binarySearch;

public class RotatedSortedArraySearch_33 {
	
	//也是基于RotatedSortedArrayFindMin_153的解法 用了一次binarysearch
	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int res = -1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				res = mid; 
				return res;
			}

			if (nums[mid] < nums[right]) {
				if (nums[mid] > target || target > nums[right])
					right = mid - 1;
				else
					left = mid + 1;
			} else {
				if (nums[mid] < target || target < nums[left])
					left = mid + 1;
				else
					right = mid - 1;
			}
		}
		return res;
	}
//	别人的法2  先用RotatedSortedArrayFindMin_153找到min的位置 
//	然后再用普通的二分法来分段寻找
 
}

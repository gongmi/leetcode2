package binarySearch;

public class SearchInsertPosition_35 {
	public int searchInsert(int[] nums, int target) {
		int start = 0;
		int end = nums.length;
		int mid = 0;

		while (start <= end) {
			mid = start + (end - start) / 2;

			if (start == end) {
				if (mid < nums.length && nums[mid] < target)
					mid = mid + 1;
				break;
			}
			if (target < nums[mid])
				end = mid - 1;
			else if (target > nums[mid])
				start = mid + 1;
			else
				break;
		}
		return mid;

	}

	// 2017.07.25 感觉这个题目看起来很简单 但是还是有很多细节要去抠的
	public int searchInsert2(int[] nums, int target) {
		int left = 0, right = nums.length - 1;

		int mid = 0;
		while (left < right) {
			mid = left + (right - left) / 2;
			if (nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				return mid;
			}
		}
		return nums[left] >= target ? left : left + 1;

	}

	// 根据LongestIncreasingSubsequence_300中 自定义的binarySearch优化后的答案
	// 其实就是和LongestIncreasingSubsequence_300中的一样的
	// 返回left 其实最标准的二分查找 就是
	// while (left <= right) 然后left = mid + 1; right = mid - 1;
	public int searchInsert3(int[] nums, int target) {
		int left = 0, right = nums.length - 1;

		int mid = 0;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				return mid;
			}
		}
		return left;

	}

}

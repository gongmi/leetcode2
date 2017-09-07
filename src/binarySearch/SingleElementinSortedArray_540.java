package binarySearch;

public class SingleElementinSortedArray_540 {
	// 我的答案 就是讨论一些情况
	public int singleNonDuplicate(int[] nums) {
		int left = 0, right = nums.length - 1;
		int mid = left + (right - left) / 2;
		while (left < right) {
			mid = left + (right - left) / 2;
			if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
				return nums[mid];
			} else if (nums[mid] == nums[mid - 1]) {
				if (((mid - left) & 1) == 0)
					right = mid;
				else
					left = mid + 1;
			} else {
				if (((mid - left) & 1) == 0)
					left = mid;
				else
					right = mid - 1;
			}
		}

		return nums[left];
	}

	// top
	public int singleNonDuplicate2(int[] nums) {
		int lo = 0, hi = nums.length - 1;
		while (lo < hi) {
			int mid = (lo + hi) >>> 1;
			if (nums[mid] == nums[mid ^ 1])
				lo = mid + 1;
			else
				hi = mid;
		}
		return nums[lo];
	}
}

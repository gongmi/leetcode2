package binarySearch;

public class RotatedSortedArrayFindMin_153 {
//	这道题我排除了很多边界情况 可是别人的代码却很简单
//	在right和left的值时 不一定就是 mid-1与 mid+1 应该怎么选择这是个问题!
	public int findMin(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < nums[right]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return nums[left];
	}
}

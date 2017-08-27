package binarySearch;

public class RotatedSortedArrayFindMin_153 {
	// 这道题我排除了很多边界情况 可是别人的代码却很简单

	// 在right和left的值时 不一定就是 mid-1与 mid+1（二分法就是的）
	// 应该怎么选择这是个问题! 为什么这里选择mid 与 mid+1
	// 剑指offer第八题 可是书上的code没有这个好
	public int findMin(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < nums[right]) {
				right = mid;  // 因为 nums[mid]可能是最小值 所以不能mid-1
			} else {
				left = mid + 1; // 因为 nums[mid]不可能是最小值 所以
			}
		}
		return nums[left];
	}

	// 2017.08.21第二版答案
	// 其实关于right和left是否是 mid-1与 mid+1需要分情况来开
	// 这道题 我先判断nums[left] <= nums[right] 这种情况 就是 已经是顺序 说明就在第一个
	// 然后不是顺序的话 就要看 中间
	// 如果左边<=中间 说明中间不可能是最小值 因为左边肯定比它更有可能是最小值 所以mid+1
	// 但是如果左边>中间 说明中间有可能是最小值 所以mid
	public int findMin2(int[] nums) {
		int left = 0, right = nums.length - 1;
		int mid = 0;
		while (left <= right) {
			if (nums[left] <= nums[right]) {
				return nums[left];
			}
			mid = left + (right - left) / 2;
			if (nums[left] <= nums[mid]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return 0;
	}
}

package Array;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray_581 {
	// 我的答案 用排序
	public int findUnsortedSubarray(int[] nums) {
		int[] nums2 = Arrays.copyOf(nums, nums.length);
		Arrays.sort(nums2);
		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			if (nums[left] == nums2[left])
				left++;
			if (nums[right] == nums2[right])
				right--;
			if (nums[left] != nums2[left] && nums[right] != nums2[right])
				break;
		}
		return left == right ? 0 : right - left + 1;
	}
//	top答案 很神奇的
//	从左到右一个一个的找max 在找的过程中 如果发现后面有比max更小的 说明后面是end
//	从右到左一个一个的找min 在找的过程中 如果发现前面有比min更大的 说明前面是begin
	public int findUnsortedSubarray2(int[] A) {
	    int n = A.length, beg = -1, end = -2, min = A[n-1], max = A[0];
	    for (int i=1;i<n;i++) {
	      max = Math.max(max, A[i]);
	      min = Math.min(min, A[n-1-i]);
	      if (A[i] < max) end = i;
	      if (A[n-1-i] > min) beg = n-1-i; 
	    }
	    return end - beg + 1;
	}
}

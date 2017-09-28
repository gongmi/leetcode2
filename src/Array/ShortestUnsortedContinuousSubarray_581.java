package Array;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray_581 {
	// �ҵĴ� ������
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
//	top�� �������
//	������һ��һ������max ���ҵĹ����� ������ֺ����б�max��С�� ˵��������end
//	���ҵ���һ��һ������min ���ҵĹ����� �������ǰ���б�min����� ˵��ǰ����begin
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

package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum_15 {
	// ������TwoSumII_167 ��2pointer ����
	// ���ǰ�target����������������ÿ��Ԫ�� ʱ�临�Ӷ�O��n*n��
	// ����
	public List<List<Integer>> threeSum(int[] nums) {
		int[] sorted_nums = nums;
		Arrays.sort(sorted_nums);
		// ���ﻻ����arraylist����ͨ�� ��Ϊԭ����linkedlist ��ʱ contains�����Ǻ����� array�����ö��ַ�

		List<List<Integer>> res = new ArrayList<List<Integer>>();

		int start = 0;
		int end = nums.length - 1;

		for (int i = 0; i < nums.length; i++) {
			if (i != 0 && nums[i] == nums[i - 1])
				continue;
			start = i + 1;
			end = nums.length - 1;

			while (start < end) {

				if (nums[start] + nums[end] + nums[i] < 0) {
					while (start < end && nums[start] == nums[start + 1])
						start++;// whileѭ�����ù����ظ���ȥ����
					start++;
				} else if (nums[start] + nums[end] + nums[i] > 0) {
					while (start < end && nums[end] == nums[end - 1])
						end--;  // whileѭ�����ù����ظ���ȥ����
					end--;
				} else {
					// List<Integer> list=new LinkedList<Integer>();
					// list.add(sorted_nums[i]);
					// list.add(sorted_nums[start]);
					// list.add(sorted_nums[end]);
					// if (!res.contains(list))
					// res.add(list);
					
					
					res.add(Arrays.asList(nums[i], nums[start], nums[end]));
					start++;
					end--;
					// ������ĸĳ�����Ŀ���� whileѭ�����ظ���ȥ���� �Ͳ����ж�contains��
					while (start < end && nums[start] == nums[start - 1])
						start++;
					while (start < end && nums[end] == nums[end + 1])
						end--;
				
				}
			}

		}
		return res;
	}
}
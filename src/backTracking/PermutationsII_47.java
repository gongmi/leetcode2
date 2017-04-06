package backTracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationsII_47 {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> list = new LinkedList<>();
		Arrays.sort(nums);// 必须排序
		backtrack(list, new LinkedList<Integer>(), nums, new boolean[nums.length]);
		return list;
	}
	
	// 第一个条件 ： 当这个num已经用在list中
	// 第二个条件： 当前一个num与这个num一样时 并且前一个num还没用时
	// 因为以一样的num作为第一个的排列其实是一样的 所以直接跳过
	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums,
			boolean[] used) {
		for (int i = 0; i < nums.length; i++) {
			if (used[i] || (i > 0 && !used[i - 1] && nums[i - 1] == nums[i]))
				continue;
			tempList.add(nums[i]);
			used[i] = true;
			if (tempList.size() == nums.length)
				list.add(new LinkedList<>(tempList));
			else
				backtrack(list, tempList, nums, used);
			tempList.remove(tempList.size() - 1);
			used[i] = false;
		}
	}
}

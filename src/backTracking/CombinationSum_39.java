package backTracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum_39 {
	// ²»ÓÃÅÅĞò
	public List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> list = new LinkedList<>();
		backtrack(list, new LinkedList<Integer>(), nums, target, 0);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
		if (remain < 0)
			return;

		if (remain == 0) {
			list.add(new LinkedList<>(tempList));
		} else {
			for (int i = start; i < nums.length; i++) {
				tempList.add(nums[i]);
				backtrack(list, tempList, nums, remain - nums[i], i);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}

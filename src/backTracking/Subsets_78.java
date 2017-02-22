package backTracking;

import java.util.LinkedList;
import java.util.List;

public class Subsets_78 {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new LinkedList<>();
		list.add(new LinkedList<Integer>());
		backtrack(list, new LinkedList<Integer>(), nums, 0);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList,
			int[] nums, int start) {
		for (int i = start; i < nums.length; i++) {
			tempList.add(nums[i]);
			list.add(new LinkedList<>(tempList));
			backtrack(list, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}
}

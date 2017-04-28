package backTracking;

import java.util.LinkedList;
import java.util.List;

public class Permutations_46 {
//	 用了模板 时间很慢 因为tempList.contains(nums[i])线性时间查找
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new LinkedList<>();
		backtrack(list, new LinkedList<Integer>(), nums);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList,
			int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (tempList.contains(nums[i]))// element already exists, skip
				continue; 
			tempList.add(nums[i]);
			if (tempList.size() == nums.length)
				list.add(new LinkedList<>(tempList));
			else
				backtrack(list, tempList, nums);
			tempList.remove(tempList.size() - 1);
		}
	}
}

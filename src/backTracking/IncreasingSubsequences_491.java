package backTracking;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
//典型的backTracking
//不需要用used  因为只能往后找 不能往前

public class IncreasingSubsequences_491 {
	Set<List<Integer>> res = new HashSet<>();

	public List<List<Integer>> findSubsequences(int[] nums) {
		helper(nums, new LinkedList<Integer>(), 0);
		return new LinkedList<List<Integer>>(res);
	}

	private void helper(int[] nums, List<Integer> temp, int k) {
		for (int i = k; i < nums.length; i++)
			if (temp.size() == 0 || nums[i] >= temp.get(temp.size() - 1)) {
				temp.add(nums[i]);

				if (temp.size() > 1)
					res.add(new LinkedList<Integer>(temp));

				helper(nums, temp, i + 1);
				temp.remove(temp.size() - 1);
			}
	}
}

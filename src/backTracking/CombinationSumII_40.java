package backTracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII_40 {
	// 一定要排序 因为 与CombinationSum_39相比
	// 数字在candidates中有重复
	// 如果不排序 set中的list可能有一样的 只是数字位置不同
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> list = new LinkedList<>();
		Arrays.sort(candidates);
		backtrack(list, new LinkedList<Integer>(), candidates, target, 0);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList,
			int[] candidates, int remain, int start) {
		for (int i = start; i < candidates.length && remain >= candidates[i]; i++) {
			if (i > start && candidates[i] == candidates[i - 1])
				continue;
			tempList.add(candidates[i]);
			if (remain == candidates[i])
				list.add(new LinkedList<>(tempList));
			else
				backtrack(list, tempList, candidates, remain - candidates[i],
						i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}
	// 我为了避免 重复
	// 比如说 1 1 2 5 6 7 10
	// 第二个1会算出 之前那个1 算出过的答案 我用set来解决的 明显上面的方法更好 更快

	// public List<List<Integer>> combinationSum2(int[] candidates, int target)
	// {
	// Set<List<Integer>> set = new HashSet<>();
	// Arrays.sort(candidates);
	// backtrack(set, new LinkedList<Integer>(), candidates, target, 0);
	// return new LinkedList<List<Integer>>(set);
	// }
	//
	// private void backtrack(Set<List<Integer>> set, List<Integer> tempList,
	// int[] candidates, int remain, int start) {
	// for (int i = start; i < candidates.length && remain >= candidates[i];
	// i++) {
	// tempList.add(candidates[i]);
	// if (remain == candidates[i])
	// set.add(new LinkedList<>(tempList));
	// else
	// backtrack(set, tempList, candidates, remain - candidates[i], i+1);
	// tempList.remove(tempList.size() - 1);
	// }
	// }

}
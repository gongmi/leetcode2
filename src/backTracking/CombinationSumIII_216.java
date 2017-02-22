package backTracking;

import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII_216 {
//	
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> list = new LinkedList<>();
		backtrack(list, new LinkedList<Integer>(), k, n, 1);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList,
			int k, int remain, int start) {
		if (tempList.size() > k) {
            return;
        }
		if (tempList.size() == k && remain == 0) {
			list.add(new LinkedList<>(tempList));
			return;
		}
		for (int i = start; i < 10 && remain >= i; i++) {
			tempList.add(i);
			backtrack(list, tempList, k, remain - i, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}
}

package backTracking;

import java.util.LinkedList;
import java.util.List;
//Arraylist 比Linkedlist快多了 因为remove（index）
public class Combinations_77 {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> list = new LinkedList<>();
		backtrack(list, new LinkedList<Integer>(), k, n, 1);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList,
			int k, int n, int start) {
		if (tempList.size() == k) {
			list.add(new LinkedList<Integer>(tempList));
			return;
		}
		for (int i = start; i < n + 1; i++) {
			tempList.add(i);
			backtrack(list, tempList, k, n, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}
}

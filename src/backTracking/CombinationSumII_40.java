package backTracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII_40 {
	// һ��Ҫ���� ��Ϊ ��CombinationSum_39���
	// ������candidates�����ظ�
	// ��������� set�е�list������һ���� ֻ������λ�ò�ͬ
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
	// ��Ϊ�˱��� �ظ�
	// ����˵ 1 1 2 5 6 7 10
	// �ڶ���1����� ֮ǰ�Ǹ�1 ������Ĵ� ����set������� ��������ķ������� ����

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
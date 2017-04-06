package backTracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationsII_47 {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> list = new LinkedList<>();
		Arrays.sort(nums);// ��������
		backtrack(list, new LinkedList<Integer>(), nums, new boolean[nums.length]);
		return list;
	}
	
	// ��һ������ �� �����num�Ѿ�����list��
	// �ڶ��������� ��ǰһ��num�����numһ��ʱ ����ǰһ��num��û��ʱ
	// ��Ϊ��һ����num��Ϊ��һ����������ʵ��һ���� ����ֱ������
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

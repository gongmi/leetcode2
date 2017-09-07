package twoPointers;

import java.util.*;

public class FindAllNumbersDisappeared_448 {
	// ȡ���� ��top��һ��

	public List<Integer> findDisappearedNumbers(int[] nums) {
		LinkedList<Integer> res = new LinkedList<Integer>();
		for (int num : nums) {
			num = Math.abs(num) - 1;// ��Ϊ�Ǵ�1��n������ ����Ҫ�ȼ�1 ����������index��0��n-1
			if (nums[num] > 0) {
				nums[num] = -nums[num];
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				res.add(i + 1);
			}
		}
		return res;
	}
}

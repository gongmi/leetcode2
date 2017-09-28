package hashTable;

import java.util.*;

public class ContinuousSubarraySum_523 {
//tagû��hash ����Ӧ����hash
	// ������SubarraySumEqualsK_MaxSize_325����
	// ֻ������ k�ı��� ��sum%K����
	// ֻ��Ҫ�Ҵ治���� ������hashset����
	// ���� ����Ҫ��HashMap ��Ϊ����Ϊ1�Ĳ��� ����Ҫ��
	// <preSum,index>
	public boolean checkSubarraySum(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0;

		for (int i = 0; i < nums.length; i++) {
			if (k == 0)
				sum += nums[i];
			else
				sum = (sum + nums[i]) % k;
			int prevIndex = map.getOrDefault(sum, i);
			if (prevIndex < i - 1)
				return true;
			if (prevIndex == i)
				map.put(sum, i);

		}
		return false;

	}
}

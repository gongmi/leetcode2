package hashTable;

import java.util.*;

public class ContiguousArray_525 {
	// һ��ʼ������� dp ��Ϊ�Ҿ��� ������LongestPalindromicSubsequence_516����
	// ������ϸ���벻һ�� ��Ϊ������м䲻���пյ� ���������ȷʵ�����������

	// ������MaximumSizeSubarraySum_325����
	// �Ȱ����е�0�����-1
	// K=0
	// ����sum - k=sum
	// ���Կ����Ż�һ��
	public int findMaxLength(int[] nums) {
		if (nums.length <= 1)
			return 0;
		for (int i = 0; i < nums.length; i++)
			if (nums[i] == 0)
				nums[i] = -1;

		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0;
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum))
				res = Math.max(i - map.get(sum), res);
			else
				map.put(sum, i);
		}
		return res;
	}

}

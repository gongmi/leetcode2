package hashTable;

import java.util.*;

public class ContiguousArray_525 {
	// һ��ʼ������� dp ��Ϊ�Ҿ��� ������LongestPalindromicSubsequence_516����
	// ������ϸ���벻һ�� ��Ϊ������м䲻���пյ� ���������ȷʵ�����������

	// ������PathSumIII_437���� ����һ�������ĺ� ֻ����
	// �����ǹ涨�� target
	// ������������target
	// �Ȱ����е�0�����-1
	// map<sum,index>���sum�Ǵӿ�ʼ��i��sum
	// �����map.containsKey(sum) ˵��֮ǰ��ĳ��index��sum�����ڵ�sumһ��
	// ˵������֮���sum����0
	// ˵������֮���0��1��һ���� Ϊʲô���벻���أ�
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
			sum = sum + nums[i];
			if (map.containsKey(sum))
				res = Math.max(i - map.get(sum), res);
			else
				map.put(sum, i);
		}
		return res;
	}

}

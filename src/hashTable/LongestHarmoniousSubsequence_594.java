package hashTable;

import java.util.HashMap;

public class LongestHarmoniousSubsequence_594 {
	// �ҵĵ�һ���
	public int findLHS(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int res = 0;
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		for (int key : map.keySet()) {
			int freq = map.get(key);
			int other = Math.max(map.getOrDefault(key - 1, 0), map.getOrDefault(key + 1, 0));
			if (other != 0)
				res = Math.max(res, other + freq);
		}
		return res;
	}

	// top ����ͬʱ�� ����1 ��С��1 ֻ��Ҫ��һ���Ϳ�����
	// ����1 2 3
	// ���ͬʱ�� ��ô 1��2
	// 2�� 1 �� 3 ���ظ�����
	// ΪʲôҪ��long
	// to handle this :
	// findLHS(new int[]{-2147483648 , 2147483647});
	// 2147483647 + 1 = -2147483648 , and we don't want that.
	// ��������Ĳ������ӻ�û�ӽ�ȥ �����ҵĴ�ͨ����
	public int findLHS2(int[] nums) {
		HashMap<Long, Integer> map = new HashMap<>();
		for (long num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		int result = 0;
		for (long key : map.keySet()) {
			if (map.containsKey(key + 1)) {
				result = Math.max(result, map.get(key + 1) + map.get(key));
			}
		}
		return result;
	}
}

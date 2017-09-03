package hashTable;

import java.util.HashMap;

public class LongestHarmoniousSubsequence_594 {
	// 我的第一版答案
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

	// top 不用同时找 大于1 和小于1 只需要找一个就可以了
	// 比如1 2 3
	// 如果同时找 那么 1找2
	// 2找 1 和 3 就重复找了
	// 为什么要用long
	// to handle this :
	// findLHS(new int[]{-2147483648 , 2147483647});
	// 2147483647 + 1 = -2147483648 , and we don't want that.
	// 但是上面的测试例子还没加进去 所以我的答案通过了
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

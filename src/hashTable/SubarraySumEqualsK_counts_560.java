package hashTable;

import java.util.HashMap;

//这道题的思路 与PathSumIII_437一样 
//都是用一个hashmap来存储<presum,freq>

public class SubarraySumEqualsK_counts_560 {
	public int subarraySum(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int sum = 0;
		int res = 0;
		for (int num : nums) {
			sum += num;
			res += map.getOrDefault(sum - k, 0);
			map.put(sum, map.getOrDefault(sum, 0) + 1);

		}
		return res;
	}
}

package hashTable;

import java.util.HashMap;
import java.util.Map;
// 与TwoSumII_167不同 这里的array没有排序 所以不适合用two pointer
// 而且不能粗鲁的排序  因为排序后 index就没有了
// 用hashmap 时间复杂度只有O（n）
// 因为hashmap的put 与contains只需要O（1）
public class TwoSum_1 {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> index = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int left = target - nums[i];
			if (index.containsKey(left) && index.get(left) != i)
				return new int[] { index.get(left), i };
			index.put(nums[i], i);
		}
		return new int[2];
	}
}

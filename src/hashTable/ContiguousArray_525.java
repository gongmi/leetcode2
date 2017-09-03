package hashTable;

import java.util.*;

public class ContiguousArray_525 {
	// 一开始我想成了 dp 因为我觉得 这道题和LongestPalindromicSubsequence_516很像
	// 但是仔细想想不一样 因为这个是中间不能有空的 但是上面的确实可以随便跳的

	// 这道题和MaximumSizeSubarraySum_325很像
	// 先把所有的0都变成-1
	// K=0
	// 所以sum - k=sum
	// 所以可以优化一点
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

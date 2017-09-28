package hashTable;

import java.util.*;

public class ContinuousSubarraySum_523 {
//tag没有hash 但是应该是hash
	// 这道题和SubarraySumEqualsK_MaxSize_325很像
	// 只不过是 k的倍数 存sum%K即可
	// 只需要找存不存在 所以用hashset即可
	// 不行 还是要用HashMap 因为长度为1的不行 所以要用
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

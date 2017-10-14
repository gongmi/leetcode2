package tree;

import java.util.*;

public class ContainsDuplicateIII_220 {
	// 这道题其实不难 就是219. Contains Duplicate II 的变种
	// 只不过这道题 不是nums[i] = nums[j]
	// 那道题用的是HashSet 滑动窗口
	// 而是abs(nums[i] -nums[j]) <=t
	// 所以 就用TreeSet 滑动窗口 用ceiling 和floor来找这个数 附近的两个数

	// 时间复杂度 O(NlogK)
	TreeSet<Integer> set = new TreeSet<>();

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		for (int i = 0; i < nums.length; i++) {
			Integer higher = set.ceiling(nums[i]);
			Integer lower = set.floor(nums[i]);
			// 为了防止 [-1,2147483647] 产生的溢出 所以用long
			if (higher != null && (long) higher - (long) nums[i] <= t)
				return true;
			if (lower != null && (long) nums[i] - (long) lower <= t)
				return true;
			set.add(nums[i]);
			if (i >= k)
				set.remove(nums[i - k]);
		}
		return false;
	}

	// top答案是用的桶法 每个数都放在 num/t的位置上 被映射到同一个位置的num一定是满足要求的
	// 再看看 num-1与 num+1的位置上的数满不满足 即可
	public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
		if (k < 1 || t < 0)
			return false;
		Map<Long, Long> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
			long bucket = remappedNum / ((long) t + 1);
			if (map.containsKey(bucket)
					|| (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
					|| (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
				return true;
			if (map.entrySet().size() >= k) {
				long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
				map.remove(lastBucket);
			}
			map.put(bucket, remappedNum);
		}
		return false;
	}
}

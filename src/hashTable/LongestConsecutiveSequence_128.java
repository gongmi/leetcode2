package hashTable;
import java.util.*;
//这道题的tag是union find  但是它却和union find 不一样
//因为它只需要找到最大的一个union 并不在乎有多少个union 
//所以 对应的value 不是这个group 的root  而是group的size


//这题我想到了思路
//因为只能用线性时间 那么说明肯定要用空间
//线性时间通常存在hashmap中 因为hash的get set是O(1)

//但是我最后卡在了 [100, 4, 200, 1,0,-1 , 3, 2] 
//当2 最后进入时 它要更新4和3 和1 0 -1所对应的value
//这样去慢慢的更新的话时间复杂度就不能保证o(n)
//可是其实只需要更新-1和4 就可以了 因为 像中间的  2 3 不会在用到了 
//因为如果再有重复的 2 3 进来 do nothing  如果以后 有 5 或者 -2 什么的
//只会波及到4 和-1  因此中间的就不用更新了


public class LongestConsecutiveSequence_128 {
	public int longestConsecutive(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				int left = map.getOrDefault(nums[i] - 1, 0);
				int right = map.getOrDefault(nums[i] + 1, 0);
				int sum = left + right + 1;
				res = Math.max(res, sum);
				map.put(nums[i], sum);

				map.put(nums[i] - left, sum);
				map.put(nums[i] + right, sum);
			}
		}
		return res;
	}
}

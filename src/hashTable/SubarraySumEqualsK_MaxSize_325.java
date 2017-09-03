package hashTable;

import java.util.HashMap;

//看名字 与MinimumSizeSubarraySum_209很像
//但是并不一样  那道题是只有正数  并且找的是最小的size
//所以可以两个指针  大于了target 就丢掉左边的 小于了target 就加上右边的
//但这道题 有负数 所以 不一定大于了target 就要丢掉 可能后面有负数 加上之后就等于target了
//与SubarraySumEqualsK_560相似 的思想 还是用HashMap
//不过放的是<preSum,index>
//但是后面出现相同的preSum 就不管了
//因为后面出现的 一定没有前面出现的 得到的长度大
public class SubarraySumEqualsK_MaxSize_325 {

	public int subarraySum(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0;
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			res = Math.max(res, i - map.getOrDefault(sum - k, i));
			map.putIfAbsent(sum, i);
		}
		return res;
	}
}

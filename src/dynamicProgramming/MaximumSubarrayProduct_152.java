package dynamicProgramming;

// 和Kadane算法相似的思想 只遍历一遍数组
// 只不过要用两个变量max 与 min 来维护罢了
public class MaximumSubarrayProduct_152 {
	public int maxProduct(int[] nums) {
		int maxPre = nums[0];
		int minPre = nums[0];
		int maxSofar = nums[0], max = 0, min = 0;
		for (int i = 1; i < nums.length; i++) {
			max = Math.max(Math.max(maxPre * nums[i], minPre * nums[i]), nums[i]);
			min = Math.min(Math.min(maxPre * nums[i], minPre * nums[i]), nums[i]);
			maxSofar = Math.max(max, maxSofar);
			maxPre = max;
			minPre = min;
		}
		return maxSofar;
	}
}

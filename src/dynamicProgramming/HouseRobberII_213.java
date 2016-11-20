package dynamicProgramming;

public class HouseRobberII_213 {
	// 和HouseRobber相似
	// 只用分别考虑 第0个房间robbed 第0个房间不被robbed
	// 两种情况下的普通数组HouseRobber
	//自己总是不敢想  想不到这里 总是把问题想复杂 要大胆
	public int rob(int[] nums) {

		return Math.max(rob(nums, 1, nums.length - 1),
				rob(nums, 2, nums.length - 2) + nums[0]);
	}

	public int rob(int[] nums, int l, int h) {
		int prevNo = 0;
		int prevYes = 0;
		for (int i = l; i <= h; i++) {
			int temp = prevNo;
			prevNo = Math.max(prevNo, prevYes);
			prevYes = nums[i] + temp;
		}
		return Math.max(prevNo, prevYes);
	}
}

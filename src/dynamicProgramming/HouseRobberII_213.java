package dynamicProgramming;

public class HouseRobberII_213 {
	// ��HouseRobber����
	// ֻ�÷ֱ��� ��0������robbed ��0�����䲻��robbed
	// ��������µ���ͨ����HouseRobber
	//�Լ����ǲ�����  �벻������ ���ǰ������븴�� Ҫ��
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

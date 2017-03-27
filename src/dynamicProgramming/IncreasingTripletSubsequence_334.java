package dynamicProgramming;

public class IncreasingTripletSubsequence_334 {
	// ģ��LongestIncreasingSubsequence_300 �ķ���
	// ֻ�ǲ���Ҫ��binarysearch�� ��Ϊֻ�Ƚ�������
	// ����Ҫע�� ���ʱҲ�滻 ��Ϊ�������Լ��ж����� ���Խ�Լʱ��
	public boolean increasingTriplet(int[] nums) {
		if (nums.length < 3)
			return false;
		int dp1 = nums[0];
		int dp2 = Integer.MAX_VALUE;
		int len = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] <= dp1)
				dp1 = nums[i];
			else if (nums[i] <= dp2)
				dp2 = nums[i];
			else
				return true;
		}
		return false;
	}

	// �ڶ������Ĵ� �·����һЩ
	public boolean increasingTriplet2(int[] nums) {
		int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
		for (int num : nums) {
			if (num <= first)
				first = num;
			else if (num <= second)
				second = num;
			else
				return true;
		}
		return false;
	}
}

package dynamicProgramming;
//	// ��Kadane�㷨 ֻ����һ������
// ��ǰ����Щ�������С��0 �Ͳ�Ҫ��
//���Ǻʹ�ͳ����������鲻һ���ĵط��� �����鳤������Ϊ1 ����˵����Ҫѡһ��
//���Ե�ȫΪ����ʱ 0�ǲ��Ե� Ӧ���Ǹ������е������  ������ط���һ�� ���Զ��һ��max������������������
public class MaximumSubarray_53 {
	public int maxSubArray(int[] nums) {

		int max = Integer.MIN_VALUE;
		int maxSoFar = 0;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
			sum = sum + nums[i];
			if (sum < 0)
				sum = 0;
			if (sum > maxSoFar)
				maxSoFar = sum;
		}
		if (max < 0)
			return max;
		return maxSoFar;
	}
}

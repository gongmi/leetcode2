package dynamicProgramming;
//	// ��Kadane�㷨 ֻ����һ������
// ��ǰ����Щ�������С��0 �Ͳ�Ҫ��
//���Ǻʹ�ͳ����������鲻һ���ĵط��� �����鳤������Ϊ1 ����˵����Ҫѡһ��
//���Ե�ȫΪ����ʱ 0�ǲ��Ե� Ӧ���Ǹ������е������  ������ط���һ��
public class MaximumSubarray_53 {
	public int maxSubArray(int[] nums) {

		int max = Integer.MIN_VALUE;
		int maxSoFar = 0;
		int maxCur = 0;
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
			maxCur = maxCur + nums[i];
			if (maxCur < 0)
				maxCur = 0;
			if (maxCur > maxSoFar)
				maxSoFar = maxCur;
		}
		if (max < 0)
			return max;
		return maxSoFar;
	}
}

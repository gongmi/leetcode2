package dynamicProgramming;

public class MaximumSubarray_53 {
	// ��Kadane�㷨 ֻ����һ������
	// ��ǰ����Щ�������С��0 �Ͳ�Ҫ��
	// ���Ǻʹ�ͳ����������鲻һ���ĵط��� �����鳤������Ϊ1 ����˵����Ҫѡһ��
	// ���Ե�ȫΪ����ʱ 0�ǲ��Ե� Ӧ���Ǹ������е������ ������ط���һ�� ���Զ��һ��max������������������
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

	// ��MaximumSubarrayProduct_152�����ĵڶ����
	// ��Ϊ��������ѡһ����
	// ����һ��ʼ��ѡһ��
	// sum = Math.max(sum + nums[i], nums[i]);
	// ����sumҪô��һ�� Ҫô���������ǰ��Ķ��

	// ��ָoffer p173�й�ʽ

	public int maxSubArray2(int[] nums) {
		int sum = nums[0];
		int maxSofar = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sum = Math.max(sum + nums[i], nums[i]);
			maxSofar = Math.max(sum, maxSofar);
		}
		return maxSofar;
	}

	// 2017.08.22 ������һ����˼·
	public int maxSubArray3(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int max = nums[0];
		int res = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (max < 0) {
				max = nums[i];
			} else {
				max = max + nums[i];
			}
			res = Math.max(res, max);
		}
		return res;
	}
}

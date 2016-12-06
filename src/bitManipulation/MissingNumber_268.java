package bitManipulation;

import java.util.Arrays;

public class MissingNumber_268 {
	// bit manipulation ��ʵ�������һ����˼��
	public int missingNumber(int[] nums) {
		int n = 0;
		int i = 0;
		for (i = 0; i < nums.length; i++) {
			n = n ^ i ^ nums[i]; //��nums.length-1��nums�����xor
		}
		return n ^ i;//��nums.length����xor
	}

	// 2 ���
	public int missingNumber2(int[] nums) {
		int n = nums.length;
		int sum = n * (n + 1) / 2;
		for (int num : nums) {
			sum = sum - num;
		}
		return sum;
	}

	// ���˵����
	public static int missingNumber3(int[] nums) {
		int sum = nums.length;
		for (int i = 0; i < nums.length; i++)
			sum += i - nums[i];
		return sum;
	}
}

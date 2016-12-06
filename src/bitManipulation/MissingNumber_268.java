package bitManipulation;

import java.util.Arrays;

public class MissingNumber_268 {
	// bit manipulation 其实和求和是一样的思想
	public int missingNumber(int[] nums) {
		int n = 0;
		int i = 0;
		for (i = 0; i < nums.length; i++) {
			n = n ^ i ^ nums[i]; //与nums.length-1个nums里的数xor
		}
		return n ^ i;//与nums.length个数xor
	}

	// 2 求和
	public int missingNumber2(int[] nums) {
		int n = nums.length;
		int sum = n * (n + 1) / 2;
		for (int num : nums) {
			sum = sum - num;
		}
		return sum;
	}

	// 别人的求和
	public static int missingNumber3(int[] nums) {
		int sum = nums.length;
		for (int i = 0; i < nums.length; i++)
			sum += i - nums[i];
		return sum;
	}
}

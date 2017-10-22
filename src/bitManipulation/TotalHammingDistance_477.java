package bitManipulation;

import java.util.HashMap;

public class TotalHammingDistance_477 {
	// 第一版答案超时 时间复杂度是O(N*N)

	public int totalHammingDistance(int[] nums) {
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				res += countBitOnes(nums[i] ^ nums[j]);
			}
		}
		return res;
	}

	private int countBitOnes(int num) {
		int count = 0;
		while (num > 0) {
			num = num & (num - 1);
			count++;
		}
		return count;
	}

	// 第二版答案 考虑用一个32位的数组来存放之前的num每一位为1的个数
	public int totalHammingDistance2(int[] nums) {
		int[] count = new int[32]; // 代表前i个num 第k位为1的个数
		int res = 0;
		for (int i = 0; i < nums.length; i++) {

			int bit1 = 1;
			for (int k = 0; k < 31; k++) {
				int curBit1 = nums[i] & bit1;
				if (i != 0) {
					res += curBit1 == 0 ? count[k] : i - count[k];
				}
				count[k] += curBit1 == 0 ? 0 : 1;
				bit1 = bit1 << 1;
			}
		}
		return res;
	}

	// top 答案 其实和我的思路是一样的
	// 但是它是先循环32 就是每一位先处理完所有的num 这样就不需要用一个数组来存
	// 而且对于某一位 如果这一位有 m个1 n个0 那么说明在这一位 Hamming Distance 就是m*n
	// 因为每个这一位为1的num和每个这一位为0的num都能够组成Hamming Distance=1
	// 其实就是相当于讨论32位这种情况罢了
	public int totalHammingDistance3(int[] nums) {
		int total = 0, n = nums.length;
		for (int j = 0; j < 32; j++) {
			int bitCount = 0;
			for (int i = 0; i < n; i++)
				bitCount += (nums[i] >> j) & 1;
			total += bitCount * (n - bitCount);
		}
		return total;
	}
}

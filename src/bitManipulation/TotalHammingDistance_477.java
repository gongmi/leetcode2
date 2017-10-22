package bitManipulation;

import java.util.HashMap;

public class TotalHammingDistance_477 {
	// ��һ��𰸳�ʱ ʱ�临�Ӷ���O(N*N)

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

	// �ڶ���� ������һ��32λ�����������֮ǰ��numÿһλΪ1�ĸ���
	public int totalHammingDistance2(int[] nums) {
		int[] count = new int[32]; // ����ǰi��num ��kλΪ1�ĸ���
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

	// top �� ��ʵ���ҵ�˼·��һ����
	// ����������ѭ��32 ����ÿһλ�ȴ��������е�num �����Ͳ���Ҫ��һ����������
	// ���Ҷ���ĳһλ �����һλ�� m��1 n��0 ��ô˵������һλ Hamming Distance ����m*n
	// ��Ϊÿ����һλΪ1��num��ÿ����һλΪ0��num���ܹ����Hamming Distance=1
	// ��ʵ�����൱������32λ�����������
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

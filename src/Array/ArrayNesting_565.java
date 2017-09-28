package Array;

import java.util.Arrays;

public class ArrayNesting_565 {
	// ��һ��� ��һ��groups��������ŵ�ǰ����������ĸ���
	// �����ͳ��һ���ĸ���ĸ������
	public int arrayNesting(int[] nums) {
		int[] groups = new int[nums.length];
		Arrays.fill(groups, -1);
		for (int i = 0; i < nums.length; i++) {
			int idx = i;
			while (groups[idx] == -1) {
				groups[idx] = i;
				idx = nums[idx];
			}
		}
		int[] freq = new int[nums.length];
		int res = 0;
		for (int i : groups) {
			freq[i]++;
			res = Math.max(res, freq[i]);
		}
		return res;
	}

	// ������һ��ʱ��count
	// ��FindAllDuplicates_442���� ȡ��
	public int arrayNesting2(int[] nums) {
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			int count = 0;
			while (nums[i] != -1) {
				count++;
				int temp = nums[i];
				nums[i] = -1;
				i = temp;

			}
			res = Math.max(res, count);
		}
		return res;
	}
}

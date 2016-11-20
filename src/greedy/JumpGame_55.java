package greedy;

import java.util.Arrays;

public class JumpGame_55 {
	// ��һ�������������е��ܵ���ĵط� ��ʱ
	// [40,39,38,37,36,35,34,33,32,31,
	// 30,29,28,27,26,25,24,23,22,21,
	// 20,19,18,17,16,15,14,13,12,11,
	// 10, 9, 8, 7, 6, 5, 4, 3, 2, 1,1,0,0]
	public boolean canJump(int[] nums) {
		boolean[] Bnums = new boolean[nums.length];
		Arrays.fill(Bnums, false);
		Bnums[0] = true;
		for (int i = 0; i < nums.length - 1; i++) {
			if (Bnums[i] == true)
				for (int j = nums[i]; j >= 1; j--) {
					if (i + j == nums.length - 1)
						return true;
					if (i + j < nums.length - 1 && !Bnums[i + j])
						Bnums[i + j] = true;
				}
		}
		return Bnums[nums.length - 1];
	}

	// Ӧ�ôӺ���ǰ ֻ��Ҫ��һ��int���浱ǰ��ǰ���Ե������Ǹ�λ��
	// ����ʱ��ܰ� �������� �ܶ�𰸶��Ǐ�ǰ���� ���X���ҵĸ���
	public boolean canJump2(int[] nums) {
		int small = nums.length - 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] + i >= small)
				small = i;
		}
		return (small == 0);
	}
}

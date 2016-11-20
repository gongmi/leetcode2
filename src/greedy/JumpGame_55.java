package greedy;

import java.util.Arrays;

public class JumpGame_55 {
	// 用一个数组来存所有的能到达的地方 超时
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

	// 应该从后往前 只需要用一个int来存当前最前可以到最后的那个位置
	// 而且时间很棒 我真厉害 很多答案都是從前往後 我覺得我的更好
	public boolean canJump2(int[] nums) {
		int small = nums.length - 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] + i >= small)
				small = i;
		}
		return (small == 0);
	}
}

package dynamicProgramming;

import java.util.Arrays;

public class PredictTheWinner_486 {
	// 其实就是递归的求解 要带上备忘 因为很多重叠子问题
	int[][] memo;

	public boolean PredictTheWinner(int[] nums) {
		memo = new int[nums.length][nums.length];
		for (int i = 0; i < nums.length; i++) {
			Arrays.fill(memo[i], -1);
		}

		int diff = help(nums, 0, nums.length - 1);
		return diff >= 0;
	}

	private int help(int[] array, int i, int j) {
		if (memo[i][j] != -1)
			return memo[i][j];
		if (i == j)
			return array[i];
		int front = array[i] - help(array, i + 1, j);
		int end = array[j] - help(array, i, j - 1);
		memo[i][j] = Math.max(front, end);
		return memo[i][j];
	}
}

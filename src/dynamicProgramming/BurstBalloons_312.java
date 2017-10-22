package dynamicProgramming;

public class BurstBalloons_312 {
	// 这个解法与HouseRobber_198 我写的 自底向上 bottom-top很像
	// S[start][end] = Math.max(S[start][end],
	// new_nums[start]* new_nums[k] * new_nums[end]+ S[start][k] + S[k][end]);
	// 注意这里的思想很重要
	// 这里的k表示的是最后一爆炸的气球
	// 最后一个爆炸的气球爆炸的时候的金币就是new_nums[start]* new_nums[k] * new_nums[end]
	// 因为S[start][end]中 start 与end 都是边界 都是不能爆炸的
	// 当k作为最后一个爆炸的时候 就可以把S[start][end]分为
	// S[start][k]与两部分S[k][end] 这两部分都是以k作为边界的 因为k是最后一个爆的 所以边界是不能爆的！
	//
	public int maxCoins(int[] nums) {
		int l = nums.length;
		int[] new_nums = new int[l + 2];
		int n = 1;
		for (int i : nums)
			if (i > 0) { // burst all the zero balloons in the first round
				new_nums[n] = i;
				n++;
			}
		new_nums[0] = new_nums[n++] = 1; // 把两边都加上1作为边界 因为边界是不能爆的 所以这两个1 是辅助

		int[][] S = new int[n][n];
		for (int length = 2; length < n; length++)

			for (int start = 0; start + length < n; start++) {
				int end = start + length;
				for (int k = start + 1; k < end; k++)
					S[start][end] = Math.max(S[start][end], new_nums[start] * new_nums[k]
							* new_nums[end] + S[start][k] + S[k][end]);
			}
		return S[0][n - 1];

	}

	// 这是自顶向下 带memo的
	public int maxCoins2(int[] iNums) {
		int[] nums = new int[iNums.length + 2];
		int n = 1;
		for (int x : iNums)
			if (x > 0)
				nums[n++] = x;
		nums[0] = nums[n++] = 1;

		int[][] memo = new int[n][n];
		return burst(memo, nums, 0, n - 1);
	}

	public int burst(int[][] memo, int[] nums, int left, int right) {
		if (left + 1 == right)
			return 0;
		if (memo[left][right] > 0)
			return memo[left][right];
		int ans = 0;
		for (int i = left + 1; i < right; ++i)
			ans = Math.max(ans, nums[left] * nums[i] * nums[right] + burst(memo, nums, left, i)
					+ burst(memo, nums, i, right));
		memo[left][right] = ans;
		return ans;
	}
}

package dynamicProgramming;

public class BurstBalloons_312 {
	//这个解法与HouseRobber_198 我写的 自底向上 bottom-top很像
	//但是我就是不敢确定是不是
//	S[start][end] = Math.max(S[start][end], 
//	new_nums[start]* new_nums[k] * new_nums[end]+ S[start][k] + S[k][end]);
//	思想都是这种思想 就是先把短的算出来 长的可以用短的
	public int maxCoins(int[] nums) {
		int l = nums.length;
		int[] new_nums = new int[l + 2];
		int n = 1;
		for (int i : nums)
			if (i > 0) {
				new_nums[n] = i;
				n++;
			}
		new_nums[0] = new_nums[n++] = 1;

		int[][] S = new int[n][n];
		for (int length = 2; length < n; length++)

			for (int start = 0; start + length < n; start++) {
				int end = start + length;
				for (int k = start + 1; k < end; k++)
					S[start][end] = Math.max(S[start][end], 
							new_nums[start]* new_nums[k] * new_nums[end]
							+ S[start][k] + S[k][end]);
			}
		return S[0][n - 1];

	}
	//这是自顶向下 带memo的
	public int maxCoins2(int[] iNums) {
	    int[] nums = new int[iNums.length + 2];
	    int n = 1;
	    for (int x : iNums) if (x > 0) nums[n++] = x;
	    nums[0] = nums[n++] = 1;


	    int[][] memo = new int[n][n];
	    return burst(memo, nums, 0, n - 1);
	}

	public int burst(int[][] memo, int[] nums, int left, int right) {
	    if (left + 1 == right) return 0;
	    if (memo[left][right] > 0) return memo[left][right];
	    int ans = 0;
	    for (int i = left + 1; i < right; ++i)
	        ans = Math.max(ans, nums[left] * nums[i] * nums[right] 
	        + burst(memo, nums, left, i) + burst(memo, nums, i, right));
	    memo[left][right] = ans;
	    return ans;
	}
}

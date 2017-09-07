package DFS;

public class LongestIncreasingPath_329 {
	int row;
	int col;
	int[][] dp;
	int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	// 其实就是dfs 只不过用另一个数组来保存了值 就是DP with memorization嘛
	public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		row = matrix.length;
		col = matrix[0].length;
		dp = new int[row][col];

		int max = 0;
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				max = Math.max(max, build(matrix, r, c, Integer.MIN_VALUE));
			}
		}
		return max;
	}

	private int build(int[][] matrix, int r, int c, int prev) {
		if (r < 0 || r == row || c < 0 || c == col || prev >= matrix[r][c]) {
			return 0;
		}
		if (dp[r][c] != 0) {
			return dp[r][c];
		}
		for (int[] d : dirs) {
			dp[r][c] = Math.max(dp[r][c], build(matrix, r + d[0], c + d[1], matrix[r][c]));
		}
		dp[r][c]++;
		return dp[r][c];
	}

}

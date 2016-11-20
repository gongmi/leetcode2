package dynamicProgramming;

public class MinimumPathSum_64 {
	// 我思考了一会儿想出来了 其实就是2维的
//与别人的unique paths的第二种方法类似
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		if (m == 0)
			return 0;
		int n = grid[0].length;

		for (int i = 1; i < m; i++)
			grid[i][0] += grid[i - 1][0];

		for (int i = 1; i < n; i++)
			grid[0][i] += grid[0][i - 1];

		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++)
				grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j])
						+ grid[i][j];

		return grid[m - 1][n - 1];
	}
}

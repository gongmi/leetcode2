package DFS;

public class MaxAreaOfIsland_695 {
	int res = 0;
	int count = 0;
	int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public int maxAreaOfIsland(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					count = 0;
					dfs(grid, i, j);
				}
			}
		}
		return res;
	}

	private void dfs(int[][] grid, int i, int j) {
		if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == 0)
			return;
		count++;
		grid[i][j] = 0;
		res = Math.max(res, count);
		for (int[] dir : dirs) {
			dfs(grid, i + dir[0], j + dir[1]);
		}
	}
}

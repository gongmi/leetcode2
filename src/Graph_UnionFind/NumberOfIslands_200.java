package Graph_UnionFind;

//union find  或DFS  但是就这道题来说 似乎DFS更加直观

//这是union find
public class NumberOfIslands_200 {
	
	int[][] dirs = { { 0, 1 }, { 1, 0 } };
	//这边只需要下和右就可以了！！ 因为它会从左到右从上到下遍历每个结点的 所以
//	但是DFS必须上下左右都找
	public int numIslands0(char[][] grid) {
		int r = grid.length;
		if (r == 0)
			return 0;
		int c = grid[0].length;
		int res = 0;
		int[] roots = new int[r * c];
		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++)
				if (grid[i][j] == '1') {
					roots[i * c + j] = i * c + j;
					res++;
				}

		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++)
				if (grid[i][j] == '1') {
					int idx = i * c + j;
					int root = find(roots, idx);
					for (int[] dir : dirs) {
						int x = i + dir[0];
						int y = j + dir[1];
						int idx2 = x * c + y;
						if (x < 0 || x >= r || y < 0 || y >= c || grid[x][y] == '0')
							continue;

						int rootNb = find(roots, idx2);
						if (root != rootNb) {
							roots[root] = rootNb;
							root = rootNb;
							res--;
						}
					}
				}
		return res;
	}

	private int find(int[] roots, int id) {
		while (roots[id] != id) {
			roots[id] = roots[roots[id]];
			id = roots[id];
		}
		return id;
	}

	// 我的答案 用visited来表示有没有到过
	boolean[][] visited = null;

	public int numIslands(char[][] grid) {
		int r = grid.length;
		if (r == 0)
			return 0;
		int c = grid[0].length;
		visited = new boolean[r][c];
		int res = 0;
		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++)
				if (helper(grid, r, c, i, j))
					res++;
		return res;
	}

	private boolean helper(char[][] grid, int r, int c, int i, int j) {
		if (i < 0 || j < 0 || i == r || j == c || visited[i][j])
			return false;

		visited[i][j] = true;
		if (grid[i][j] == '1') {
			helper(grid, r, c, i, j - 1);
			helper(grid, r, c, i, j + 1);
			helper(grid, r, c, i - 1, j);
			helper(grid, r, c, i + 1, j);
			return true;
		} else
			return false;
	}

	// 别人的top答案 用grid[i][j] = '0'
	// 即置grid[i][j]为0来相当于我的visited[i][j] = true; 多么聪明
	// 没有额额外的space开销
	private int n;
	private int m;

	public int numIslands2(char[][] grid) {
		int count = 0;
		n = grid.length;
		if (n == 0)
			return 0;
		m = grid[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				if (grid[i][j] == '1') {
					DFSMarking(grid, i, j);
					++count;
				}
		}
		return count;
	}

	private void DFSMarking(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1')
			return;
		grid[i][j] = '0';
		DFSMarking(grid, i + 1, j);
		DFSMarking(grid, i - 1, j);
		DFSMarking(grid, i, j + 1);
		DFSMarking(grid, i, j - 1);
	}
}

package DFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow_417 {
	// 第一版答案 自己想出来的哈哈
	// top答案有 bfs 和dfs 两种方法 思路和我的是一样的 只不过 我都放在了同一个数组中PA 当找到满足条件的 直接返回到res
	// 而他是分为两个数组 最后再来看是否有重合的
	private List<int[]> res = new LinkedList<>();
	private int row;
	private int col;
	private int[][] PA; // 1代表是P 2代表是A
	int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public List<int[]> pacificAtlantic(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return res;
		row = matrix.length;
		col = matrix[0].length;
		PA = new int[row][col];
		for (int r = 0; r < row; r++) {
			dfs(matrix, r, 0, true, 0);
		}
		for (int c = 0; c < col; c++) {
			dfs(matrix, 0, c, true, 0);
		}
		for (int r = 0; r < row; r++) {
			dfs(matrix, r, col - 1, false, 0);
		}
		for (int c = 0; c < col; c++) {
			dfs(matrix, row - 1, c, false, 0);
		}
		return res;
	}

	private void dfs(int[][] matrix, int r, int c, boolean flag, int prev) {
		if (r < 0 || c < 0 || r == row || c == col)
			return;
		if (flag) { // 用flag来表明是P的还是A的dfs
			if (PA[r][c] == 1 || matrix[r][c] < prev) // 说明此点是A曾到达过了 或者此点比之前的点小
														// 不能回流
				return;

			PA[r][c] = 1;
			for (int[] d : dirs) {
				dfs(matrix, r + d[0], c + d[1], true, matrix[r][c]);
			}

		} else {
			if (PA[r][c] == 2 || matrix[r][c] < prev)// 说明此点是A曾到达过了 或者此点比之前的点小
														// 不能回流
				return;
			if (PA[r][c] == 1) {
				res.add(new int[] { r, c });
			}
			PA[r][c] = 2;
			for (int[] d : dirs) {
				dfs(matrix, r + d[0], c + d[1], false, matrix[r][c]);
			}
		}
	}
}
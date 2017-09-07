package DFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow_417 {
	// ��һ��� �Լ�������Ĺ���
	// top���� bfs ��dfs ���ַ��� ˼·���ҵ���һ���� ֻ���� �Ҷ�������ͬһ��������PA ���ҵ����������� ֱ�ӷ��ص�res
	// �����Ƿ�Ϊ�������� ����������Ƿ����غϵ�
	private List<int[]> res = new LinkedList<>();
	private int row;
	private int col;
	private int[][] PA; // 1������P 2������A
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
		if (flag) { // ��flag��������P�Ļ���A��dfs
			if (PA[r][c] == 1 || matrix[r][c] < prev) // ˵���˵���A��������� ���ߴ˵��֮ǰ�ĵ�С
														// ���ܻ���
				return;

			PA[r][c] = 1;
			for (int[] d : dirs) {
				dfs(matrix, r + d[0], c + d[1], true, matrix[r][c]);
			}

		} else {
			if (PA[r][c] == 2 || matrix[r][c] < prev)// ˵���˵���A��������� ���ߴ˵��֮ǰ�ĵ�С
														// ���ܻ���
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
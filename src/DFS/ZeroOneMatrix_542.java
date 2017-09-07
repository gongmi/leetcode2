package DFS;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix_542 {
	// 法1
	// In the 1 sweep,
	// we visit each entry in natural order
	// answer[i][j] =
	// min(Integer.MAX_VALUE, answer[i - 1][j]+ 1 ,answer[i][j -1]) + 1)
	// in the 2 sweep,
	// we visit each entry in reverse order
	// answer[i][j] =
	// min(answer[i][j], answer[i + 1][j]+ 1 ,answer[i][j +1]) + 1)
	public int[][] updateMatrix(int[][] matrix) {
		int row = matrix.length, col = matrix[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 1) {
					matrix[i][j] = Integer.MAX_VALUE;
					if (i - 1 >= 0 && matrix[i - 1][j] != Integer.MAX_VALUE)
						matrix[i][j] = Math.min(matrix[i][j], 1 + matrix[i - 1][j]);
					if (j - 1 >= 0 && matrix[i][j - 1] != Integer.MAX_VALUE)
						matrix[i][j] = Math.min(matrix[i][j], 1 + matrix[i][j - 1]);
				}
			}
		}
		for (int i = row - 1; i >= 0; i--) {
			for (int j = col - 1; j >= 0; j--) {
				if (i + 1 < row && matrix[i + 1][j] != Integer.MAX_VALUE)
					matrix[i][j] = Math.min(matrix[i][j], 1 + matrix[i + 1][j]);
				if (j + 1 < col && matrix[i][j + 1] != Integer.MAX_VALUE)
					matrix[i][j] = Math.min(matrix[i][j], 1 + matrix[i][j + 1]);
			}
		}
		return matrix;
	}

	// If newly calculated distance >= current distance
	// then we don't need to explore that cell again.
	// 即 如果这个node+1 比人家本来的还要大 说明 人家已经算过了 所以就放过人家了
	public int[][] updateMatrix2(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					queue.offer(new int[] { i, j });
				} else {
					matrix[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		while (!queue.isEmpty()) {
			int[] cell = queue.poll();
			for (int[] d : dirs) {
				int r = cell[0] + d[0];
				int c = cell[1] + d[1];
				if (r < 0 || r >= m || c < 0 || c >= n
						|| matrix[r][c] <= matrix[cell[0]][cell[1]] + 1)
					continue;
				queue.add(new int[] { r, c });
				matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
			}
		}

		return matrix;
	}

}
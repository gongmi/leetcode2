package Other;

import java.util.*;

public class SpiralMatrix_54 {
	List<Integer> res = new ArrayList<Integer>();

	public List<Integer> spiralOrder(int[][] matrix) {
		int rows = matrix.length;
		if (rows == 0)
			return res;
		int cols = matrix[0].length;
		helper(matrix, cols, rows, 0);
		return res;
	}

	private void helper(int[][] matrix, int cols, int rows, int start) {
		if (start >= rows || start >= cols)
			return;

		for (int i = start; i < cols; i++)
			res.add(matrix[start][i]);

		for (int i = start + 1; i < rows; i++)
			res.add(matrix[i][cols - 1]);

		if (rows - 1 > start)
			for (int i = cols - 2; i >= start; i--)
				res.add(matrix[rows - 1][i]);

		if (cols - 1 > start)
			for (int i = rows - 2; i > start; i--)
				res.add(matrix[i][start]);

		helper(matrix, cols - 1, rows - 1, start + 1);
	}

	// 别人的循环
	public List<Integer> spiralOrder2(int[][] matrix) {

		List<Integer> res = new ArrayList<Integer>();
		if (matrix.length == 0)
			return res;

		int rowBegin = 0;
		int rowEnd = matrix.length - 1;
		int colBegin = 0;
		int colEnd = matrix[0].length - 1;

		while (rowBegin <= rowEnd && colBegin <= colEnd) {
			// Traverse Right
			for (int j = colBegin; j <= colEnd; j++) {
				res.add(matrix[rowBegin][j]);
			}
			rowBegin++;

			// Traverse Down
			for (int j = rowBegin; j <= rowEnd; j++) {
				res.add(matrix[j][colEnd]);
			}
			colEnd--;

			if (rowBegin <= rowEnd) {
				// Traverse Left
				for (int j = colEnd; j >= colBegin; j--) {
					res.add(matrix[rowEnd][j]);
				}
			}
			rowEnd--;

			if (colBegin <= colEnd) {
				// Traver Up
				for (int j = rowEnd; j >= rowBegin; j--) {
					res.add(matrix[j][colBegin]);
				}
			}
			colBegin++;
		}

		return res;
	}
}

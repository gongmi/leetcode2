package dynamicProgramming;

public class RangeSumQuery2D_304 {

	// 沿用了RangeSumQuery_303的方法constructor中 每行都按照一维数组求和 然后sumRegion中哪些行 取出来 加起来
	// 这是editorial的法3
	// private int[][] S_NumMatrix;

	// public RangeSumQuery2D_304(int[][] matrix) {
	// int row = matrix.length;
	// if (row == 0)
	// return;
	// int col = matrix[0].length;
	// S_NumMatrix = new int[row][col + 1];
	// for (int i = 0; i < row; i++)
	// for (int j = 1; j < col + 1; j++)
	// S_NumMatrix[i][j] = S_NumMatrix[i][j - 1] + matrix[i][j - 1];
	// }
	//
	// public int sumRegion(int row1, int col1, int row2, int col2) {
	// int sum = 0;
	// for (int i = row1; i < row2 + 1; i++)
	// sum = sum + S_NumMatrix[i][col2 + 1] - S_NumMatrix[i][col1];
	// return sum;
	// }

	// 这是更好的方法 editorial的法4 时间更快 2D的动态规划
	private int[][] S_NumMatrix;

	public RangeSumQuery2D_304(int[][] matrix) {
		int row = matrix.length;
		if (row == 0)
			return;
		int col = matrix[0].length;
		S_NumMatrix = new int[row + 1][col + 1];
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				S_NumMatrix[i + 1][j + 1] = S_NumMatrix[i][j + 1]
						+ S_NumMatrix[i + 1][j] + matrix[i][j]
						- S_NumMatrix[i][j];
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return S_NumMatrix[row2 + 1][col2 + 1] + S_NumMatrix[row1][col1]
				- S_NumMatrix[row2 + 1][col1] - S_NumMatrix[row1][col2 + 1];
	}
}

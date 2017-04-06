package binarySearch;

//剑指offer第三题
public class Search2DMatrixII_240 {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0)
			return false;
		int col = 0, row = matrix.length - 1;
		while (0 <= row && col < matrix[0].length) {
			if (matrix[row][col] > target)
				row--;
			else if (matrix[row][col] < target)
				col++;
			else
				return true;
		}
		return false;
	}
}

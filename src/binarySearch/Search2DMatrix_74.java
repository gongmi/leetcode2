package binarySearch;

public class Search2DMatrix_74 {
	// Don't treat it as a 2D matrix, just treat it as a sorted list
//	二维数组实质上就是一维数组嘛
	
	public boolean searchMatrix(int[][] matrix, int target) {
		 int row=matrix.length;
		if (row == 0)
			return false;
		int col = matrix[0].length;
		int count = row * col;
		int left = 0, right = count - 1;
		int mid = 0;

		while (left <= right) {
			mid = (left + right) / 2;
			if (matrix[mid / col][mid % col] < target)
				left = mid + 1;
			else if (matrix[mid / col][mid % col] > target)
				right = mid - 1;
			else
				return true;

		}
		return false;

	}
}

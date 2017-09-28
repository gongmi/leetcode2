package Array;

public class RotateImage_48 {
//	我的答案   移动 1397  2684 
	/*
	 * 1 2 3     7 8 9     7 4 1
	 * 4 5 6  => 4 5 6  => 8 5 2
	 * 7 8 9     1 2 3     9 6 3
	 * */
	public void rotate(int[][] matrix) {
		int temp = 0;
		int n = matrix.length;
		if (n == 0)
			return;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - 1 - i; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = temp;
			}
		}
	}
	/*
	 * clockwise rotate
	 * first reverse up to down, then swap the symmetry 
	 * 1 2 3     7 8 9     7 4 1
	 * 4 5 6  => 4 5 6  => 8 5 2
	 * 7 8 9     1 2 3     9 6 3
	*/
	public void rotate2(int[][] matrix) {
	    int s = 0, e = matrix.length - 1;
	    while(s < e){
	        int[] temp = matrix[s];
	        matrix[s] = matrix[e];
	        matrix[e] = temp;
	        s++; e--;
	    }

	    for(int i = 0; i < matrix.length; i++){
	        for(int j = i+1; j < matrix[i].length; j++){
	            int temp = matrix[i][j];
	            matrix[i][j] = matrix[j][i];
	            matrix[j][i] = temp;
	        }
	    }
	}

	/*
	 * anticlockwise rotate
	 * first reverse left to right, then swap the symmetry
	 * 1 2 3     3 2 1     3 6 9
	 * 4 5 6  => 6 5 4  => 2 5 8
	 * 7 8 9     9 8 7     1 4 7
	*/

}

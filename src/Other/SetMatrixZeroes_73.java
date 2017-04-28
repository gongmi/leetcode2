package Other;

//- 先扫描第一行第一列，如果有0，则将各自的flag设置为true
//- 然后扫描除去第一行第一列的整个数组，如果有0，则将对应的第一行和第一列的数字赋0
//- 再次遍历除去第一行第一列的整个数组，如果对应的第一行和第一列的数字有一个为0，则将当前值赋0
//- 最后根据第一行第一列的flag来更新第一行第一列
public class SetMatrixZeroes_73 {
	public void setZeroes(int[][] matrix) {
		boolean fr = false, fc = false;
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[0].length; j++)
				if (matrix[i][j] == 0) {
					if (i == 0)
						fr = true;
					if (j == 0)
						fc = true;
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
		for (int i = 1; i < matrix.length; i++)
			for (int j = 1; j < matrix[0].length; j++)
				if (matrix[i][0] == 0 || matrix[0][j] == 0)
					matrix[i][j] = 0;

		if (fr)
			for (int j = 0; j < matrix[0].length; j++)
				matrix[0][j] = 0;

		if (fc)
			for (int i = 0; i < matrix.length; i++)
				matrix[i][0] = 0;
	}
}

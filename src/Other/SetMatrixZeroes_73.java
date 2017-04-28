package Other;

//- ��ɨ���һ�е�һ�У������0���򽫸��Ե�flag����Ϊtrue
//- Ȼ��ɨ���ȥ��һ�е�һ�е��������飬�����0���򽫶�Ӧ�ĵ�һ�к͵�һ�е����ָ�0
//- �ٴα�����ȥ��һ�е�һ�е��������飬�����Ӧ�ĵ�һ�к͵�һ�е�������һ��Ϊ0���򽫵�ǰֵ��0
//- �����ݵ�һ�е�һ�е�flag�����µ�һ�е�һ��
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

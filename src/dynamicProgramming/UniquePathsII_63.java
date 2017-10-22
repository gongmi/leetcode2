package dynamicProgramming;

public class UniquePathsII_63 {//��֮ǰ�ǵ������� ֻ��Ҫ��2ά�ķ�����
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		if (m == 0)
			return 0;
		int n = obstacleGrid[0].length;

		int P[][] = new int[m][n];//���Ա��һά���� int P[] = new int[n];Ȼ��ÿһ�ε���

		for (int i = 0; i < m; i++)
			if (obstacleGrid[i][0] != 1)
				P[i][0] = 1;
			else
				break;

		for (int i = 0; i < n; i++)
			if (obstacleGrid[0][i] != 1)
				P[0][i] = 1;
			else
				break;

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {

				if (obstacleGrid[i][j] != 1)
					P[i][j] = P[i][j - 1] + P[i - 1][j];
				else
					P[i][j] = 0;

			}
		}
		return P[m - 1][n - 1];

	}
	//���˵��������� û���õ������space ��ԭ���Ļ�����
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        
        //flip upper left cell (the start cell): 1 => 0 or 0 => 1
        obstacleGrid[0][0] ^= 1;
        
        //first row: if 1, then 0; otherwise, left cell
        for(int i = 1; i < n; i++)
            obstacleGrid[0][i] = obstacleGrid[0][i] == 1 ? 0 : obstacleGrid[0][i - 1];
        
        //first column: if 1, then 0; otherwise, top cell
        for(int i = 1; i < m; i++)
            obstacleGrid[i][0] = obstacleGrid[i][0] == 1 ? 0 : obstacleGrid[i - 1][0];
            
        //rest: if 1, then 0; otherwise, left cell + top cell
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++)
                obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? 0 : obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
        
        return obstacleGrid[m - 1][n - 1];
    }
}

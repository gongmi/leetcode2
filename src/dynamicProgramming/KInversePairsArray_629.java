package dynamicProgramming;

//��f(n,k)��ʾn����������������������Ϊk����������
//������n���ܻ����ڵ�n-iλ���Ӷ�����i����n�йص�����ԣ�ȥ��n֮��ʣ�µ�n-1������������k-i������ԡ����ԣ�f(n,k)=���(f(n-1��k-i))(0<=i<n)��
//ͬ����f(n,k-1)=���(f(n-1��k-1-i))(0<=i<n)��
//��ʽ������ɵ�f(n,k)-f(n,k-1)=f(n-1,k)-f(n-1,k-n)��
//���ƹ�ʽΪf(n,k)=f(n,k-1)+f(n-1,k)-f(n-1,k-n)��
//Ȼ��̬�滮�ɵá�
public class KInversePairsArray_629 {
	int mod = 1000000007;

	public int kInversePairs(int n, int k) {
		int[][] dp = new int[n + 1][k + 1];
		for (int i = 1; i <= n; i++)
			dp[i][0] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i * (i - 1) / 2 && j <= k; j++) {
				int tmp1 = 0, tmp2 = 0, tmp3 = 0;
				tmp1 = dp[i - 1][j];
				tmp2 = dp[i][j - 1];
				if (j - i >= 0)
					tmp3 = dp[i - 1][j - i];
				dp[i][j] = ((tmp1 + tmp2 - tmp3) % mod + mod) % mod;
			}
		}
		return dp[n][k];
	}
}

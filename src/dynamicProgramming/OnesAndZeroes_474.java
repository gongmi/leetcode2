package dynamicProgramming;
//�������һ�����͵�Ӧ��DP������⣬
//������ǿ����������������������г�����������⣬ʮ�а˾Ŷ�����DP���⣬
//����֮�ؾ��������ҳ�����ʽ��
//������һ��Ӧû���뵽��DP�������������̰���㷨������
//�����ȸ��ַ��������Ÿ����ó���С���ַ�����ǰ�棬
//Ȼ�����ÿ���ַ���������0����1�ͽ���Ӧ��m��n��ֵ��С��
//���ַ������е�ʱ���ǲ��Եģ�
//�������{"11", "01", "10"}��m=2��n=2������ӣ�
//���ǽ������ꡰ11����ʱ�򣬰�1�����ˣ���ô���ں��������ַ�����û�������ˣ�
//����ʵ��ȷ�Ĵ���Ӧ����ɺ��������ַ����Ŷԡ�
//����������Ҫ����һ��DP���飬����dp[i][j]��ʾ��i��0��j��1ʱ����ɵ�����ַ����ĸ�����
//�����ڵ�ǰ���������ַ���������ͳ�Ƴ�����0��1�ĸ���Ϊzeros��ones��
//dp[i][j] = max(dp[i][j], dp[i - zeros][j - ones] + 1);

//����� �ͱ��dp����� ��֮ͬ������ ÿ��str��Ҫdpһ�� 
public class OnesAndZeroes_474 {
	public int findMaxForm(String[] strs, int m, int n) {
		int[][] dp = new int[m + 1][n + 1];
		for (String s : strs) {
			int ones = 0;
			int zeroes = 0;
			for (int i = 0; i < s.length(); i++)
				if (s.charAt(i) == '0')
					zeroes++;
				else
					ones++;
			for (int i = m; i >= zeroes; i--)
				for (int j = n; j >= ones; j--) {
					dp[i][j] = Math.max(dp[i - zeroes][j - ones] + 1, dp[i][j]);
				}
		}
		return dp[m][n];
	}

}
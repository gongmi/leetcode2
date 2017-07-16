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



//�о��������01������ ������0�ĸ��� 1�ĸ�����weight������� ʹ�������
//��Ϊ���Ƿ����������� ���Բ�����������˵��̰���㷨����
//https://discuss.leetcode.com/topic/76103/0-1-knapsack-detailed-explanation
public class OnesAndZeroes_474 {
	public int findMaxForm(String[] strs, int m, int n) {
		int l = strs.length;
		int[][][] dp = new int[l + 1][m + 1][n + 1];

		for (int i = 0; i < l + 1; i++) {
			int[] nums = new int[2];
			if (i > 0) {
				nums = calculate(strs[i - 1]);
			}
			for (int j = 0; j < m + 1; j++) {
				for (int k = 0; k < n + 1; k++) {
					if (i == 0) {
						dp[i][j][k] = 0;
					} else if (j >= nums[0] && k >= nums[1]) {
						dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - nums[0]][k - nums[1]] + 1);
					} else {
						dp[i][j][k] = dp[i - 1][j][k];
					}
				}
			}
		}

		return dp[l][m][n];
	}

	private int[] calculate(String str) {
		int[] res = new int[2];
		for (char ch : str.toCharArray()) {
			if (ch == '0') {
				res[0]++;
			} else if (ch == '1') {
				res[1]++;
			}
		}
		return res;
	}

	// Ҳ����˵������Ľⷨ��ʵ���Ǳ�������ļ�
	// we can decrease the space complexity from ijk to j*k
	// ���Ǳ���Ӵ�С
	// http://love-oriented.com/pack/P01.html
	// ���潲�˹��ڽ�ά
	public int findMaxForm2(String[] strs, int m, int n) {
		int[][] dp = new int[m + 1][n + 1];
		for (String s : strs) {
			int ones = calculate(s)[0];
			int zeroes = calculate(s)[1];

			for (int i = m; i >= zeroes; i--)
				for (int j = n; j >= ones; j--) {
					dp[i][j] = Math.max(dp[i - zeroes][j - ones] + 1, dp[i][j]);
				}
		}
		return dp[m][n];
	}

}

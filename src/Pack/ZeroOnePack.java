package Pack;

// http://www.cppblog.com/tanky-woo/archive/2010/07/31/121803.html
//01������ZeroOnePack��: 
//��N����Ʒ��һ������ΪW�ı�������ÿ����Ʒ��ֻ��һ����
//��i����Ʒ��������w[i]����ֵ��v[i]��
//��⽫��Щ��Ʒװ�뱳����ʹ��ֵ�ܺ����
public class ZeroOnePack {
	// dp[i][j]��ʾǰi����Ʒǡ����һ������Ϊj�ı������Ի�õ�����ֵ
	// int[][] dp = new int[length + 1][weight + 1];
	// dp[i][j] = Math.max(v[i] + dp[i - 1][j - w[i]], dp[i - 1][j]);

	// ���Ա�Ϊ
	// for i=1..N
	// for j=W..0
	// f[j]=max{f[j-w[i]]+v[i],f[j]};
}

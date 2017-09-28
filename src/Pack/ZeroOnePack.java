package Pack;

// http://www.cppblog.com/tanky-woo/archive/2010/07/31/121803.html
//01背包（ZeroOnePack）: 
//有N件物品和一个容量为W的背包。（每种物品均只有一件）
//第i件物品的重量是w[i]，价值是v[i]。
//求解将哪些物品装入背包可使价值总和最大。
public class ZeroOnePack {
	// dp[i][j]表示前i件物品恰放入一个容量为j的背包可以获得的最大价值
	// int[][] dp = new int[length + 1][weight + 1];
	// dp[i][j] = Math.max(v[i] + dp[i - 1][j - w[i]], dp[i - 1][j]);

	// 可以变为
	// for i=1..N
	// for j=W..0
	// f[j]=max{f[j-w[i]]+v[i],f[j]};
}

package Pack;

//完全背包(CompletePack):
//有N件物品和一个容量为W的背包。（每种物品都有无穷多件）
//第i件物品的重量是w[i]，价值是v[i]。
//求解将哪些物品装入背包可使价值总和最大。
public class CompletePack {
	// dp[i][j]表示前i件物品恰放入一个容量为j的背包可以获得的最大价值
	// int[][] dp = new int[length + 1][weight + 1];
	// dp[i][j] = Math.max(v[i] + dp[i][j - w[i]], dp[i-1][j]);
	// 与01背包的区别在于 dp[i][j] 与当前的i有关 而不是i-1
	// 因为每种物品都是无限的。当我们把i从1到N循环时，dp[i][j]表示容量为j在前i种物品时所得的价值，
	// 这里我们要添加的不是前一个物品，而是当前物品。所以我们要考虑的是当前状态。

	// 可以变为 与01背包的区别在于 w是顺序的
	// for i=1..N
	// for j=0..W
	// f[j]=max{f[j-w[i]]+v[i],f[j]};
	// 由于j-w[i]必须要>=0所以j可以从w[i]开始
}

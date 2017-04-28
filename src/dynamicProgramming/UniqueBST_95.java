package dynamicProgramming;

import java.util.*;

import tree.TreeNode;
//dp[i][i - 1].add(null) 这句话非常重要！！！！！！！！因为一开始我没有这句话
//那么dp[i][i - 1]中就是什么都没有的 连null都没有 
//当for (TreeNode left : dp[j][i - 1]) i=j时
//这个循环根本就不会进行 因此 当left为 null right 为 dp[j + 1][j + k]中循环就不会执行
//因此我就又写了一版讨论边界的 那样就代码复杂了 还是这样好。
public class UniqueBST_95 {
	public List<TreeNode> generateTrees(int n) {
		 if (n==0) return new ArrayList<TreeNode>();
		List<TreeNode>[][] dp = new ArrayList[n + 2][n + 2];
		for (int i = 1; i <= n+1; i++) {
			dp[i][i - 1] = new ArrayList<TreeNode>();
			dp[i][i - 1].add(null);//这句话非常重要！！！！！！！！ 
			dp[i][i] = new ArrayList<TreeNode>();
			dp[i][i].add(new TreeNode(i));
		}

		for (int k = 1; k < n; k++) // k是间隔
			for (int j = 1; j + k <= n; j++)// j是开始
			{
				dp[j][j + k] = new ArrayList<TreeNode>();
				for (int i = j; i <= j + k; i++)// i是从j到j+k遍历 表明 把i作为root
				{   
					for (TreeNode left : dp[j][i - 1])
						for (TreeNode right : dp[i + 1][j + k]) {
							TreeNode root = new TreeNode(j);
							root.left = left;
							root.right = right;
							dp[j][j + k].add(root);
						}
				}
			}
		return dp[1][n];
	}
//	public List<TreeNode> generateTrees(int n) {
//	    if (n==0) return new ArrayList<TreeNode>();
//		List<TreeNode>[][] dp = new ArrayList[n + 1][n + 1];
//		for (int i = 1; i <= n; i++) {
//			dp[i][i] = new ArrayList<TreeNode>();
//			dp[i][i].add(new TreeNode(i));
//		}
//
//		for (int k = 1; k < n; k++)
//			// k是间隔
//			for (int j = 1; j + k <= n; j++)// j是开始
//			{
//				dp[j][j + k] = new ArrayList<TreeNode>();
//				for (int i = j; i <= j + k; i++)// i是从j到j+k遍历 表明 把i作为root
//				{
//					if (i == j) {
//						for (TreeNode right : dp[i + 1][j + k]) {
//							TreeNode root = new TreeNode(i);
//							root.right = right;
//							dp[j][j + k].add(root);
//						}
//					} else if (i == j + k) {
//						for (TreeNode left : dp[j][i - 1]) {
//							TreeNode root = new TreeNode(i);
//							root.left = left;
//							dp[j][j + k].add(root);
//						}
//					} else {
//						for (TreeNode left : dp[j][i - 1])
//							for (TreeNode right : dp[i + 1][j + k]) {
//								TreeNode root = new TreeNode(i);
//								root.left = left;
//								root.right = right;
//								dp[j][j + k].add(root);
//							}
//					}
//				}
//			}
//		return dp[1][n];
//	}
}

package dynamicProgramming;

import java.util.HashMap;

import tree.TreeNode;

//看top的解析 从最直观的代码到优化 心路历程！！！！！！！！！！！
//关于重叠子问题！

public class HouseRobberIII_337 {
	// top answer的解法1
	// 我刚开始以为是分层求和 但是并不是这么简单
	// 最正常的思维想法 其实我应该可以写出来的 但是觉得太想当然了 没敢尝试 这个代码会 Time Limit Exceeded
	// 因为很多子树的rob（）重复计算了 所以要用map把它们装起来 7ms
	private HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();

	public int rob2(TreeNode root) {
		if (root == null)
			return 0;
		if (map.containsKey(root))
			return map.get(root);
		int val = 0;
		if (root.left != null)
			val = val + rob(root.left.left) + rob(root.left.right);
		if (root.right != null)
			val = val + rob(root.right.left) + rob(root.right.right);
		int n = Math.max(val + root.val, rob(root.left) + rob(root.right));
		map.put(root, n);
		return n;
	}

	// top 方法2：只要2ms

	// the first element res[0] :if root is not robbed,
	// the second element res[1] :if root is robbed.
	public int rob(TreeNode root) {
		int[] res = robSub(root);
		return Math.max(res[0], res[1]);
	}

	private int[] robSub(TreeNode root) {
		if (root == null) {
			return new int[2];
		}

		int[] left = robSub(root.left);
		int[] right = robSub(root.right);

		int[] res = new int[2];
		res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		res[1] = root.val + left[0] + right[0];

		return res;
	}

	// 2017.7 我写的 这应该就是所谓的超时代码

	public int rob3(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int sumYes = root.val;
		int sumNo = 0;
		if (root.left != null) {
			sumYes += rob(root.left.left);
			sumYes += rob(root.left.right);
			sumNo += rob(root.left);
		}
		if (root.right != null) {
			sumYes += rob(root.right.left);
			sumYes += rob(root.right.right);
			sumNo += rob(root.right);
		}
		return Math.max(sumYes, sumNo);

	}
}

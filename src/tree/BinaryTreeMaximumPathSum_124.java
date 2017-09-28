package tree;

public class BinaryTreeMaximumPathSum_124 {
	int res = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		maxSinglePathSum(root);
		return res;
	}

	// 返回以root 为根节点的路径的最大值 可能为负数值
	private int maxSinglePathSum(TreeNode root) {
		if (root == null)
			return 0;
		int left = Math.max(0, maxSinglePathSum(root.left));
		int right = Math.max(0, maxSinglePathSum(root.right));
		res = Math.max(res, left + right + root.val);
		return Math.max(left, right) + root.val;
	}
}

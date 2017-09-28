package tree;

public class BinaryTreeMaximumPathSum_124 {
	int res = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		maxSinglePathSum(root);
		return res;
	}

	// ������root Ϊ���ڵ��·�������ֵ ����Ϊ����ֵ
	private int maxSinglePathSum(TreeNode root) {
		if (root == null)
			return 0;
		int left = Math.max(0, maxSinglePathSum(root.left));
		int right = Math.max(0, maxSinglePathSum(root.right));
		res = Math.max(res, left + right + root.val);
		return Math.max(left, right) + root.val;
	}
}

package tree;

public class SortedArrayToBST {
	public TreeNode sortedArrayToBST(int[] nums) {
		return helper(nums, 0, nums.length - 1);
	}

	private TreeNode helper(int[] nums, int start, int end) {
		if (start > end)
			return null;
		int size = end - start + 1;
		int mid = start + (int) Math.ceil((double) size / 2) - 1;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = helper(nums, start, mid - 1);
		root.right = helper(nums, mid + 1, end);
		return root;
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if ((p.val <= root.val && root.val <= q.val)||(q.val <= root.val && root.val <= p.val))
			return root;
		else if (p.val < root.val && q.val < root.val)
			return lowestCommonAncestor(root.left, p, q);
		else
			return lowestCommonAncestor(root.right, p, q);
	}
}

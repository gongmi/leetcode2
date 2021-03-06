package tree;

public class ConvertSortedArrayToBST_108 {
	public TreeNode sortedArrayToBST(int[] num) {
		return helper(num, 0, num.length - 1);
	}

	public TreeNode helper(int[] num, int low, int high) {
		if (low > high) { // Done
			return null;
		}
		int mid = (low + high) / 2;
		TreeNode node = new TreeNode(num[mid]);
		node.left = helper(num, low, mid - 1);
		node.right = helper(num, mid + 1, high);
		return node;
	}
}

package tree;
//¾ÍÊÇweiss µÄP90
public class DeleteNodeinBST_450 {
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null)
			return root;
		if (root.val > key)
			root.left = deleteNode(root.left, key);
		else if (root.val < key)
			root.right = deleteNode(root.right, key);
		else {
			if (root.left == null)
				root = root.right;
			else if (root.right == null)
				root = root.left;
			else {
				TreeNode node = findMin(root.right);

				node.right = deleteNode(root.right, node.val);
				node.left = root.left;
				root = node;
			}
		}
		return root;
	}

	private TreeNode findMin(TreeNode root) {
		while (root.left != null)
			root = root.left;
		return root;
	}
}

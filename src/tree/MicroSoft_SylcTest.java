package tree;

import java.util.*;

public class MicroSoft_SylcTest {

	public TreeNode add(TreeNode root, int n) {
		if (root == null)
			root = new TreeNode(n);
		else if (n < root.val)
			root.left = add(root.left, n);
		else if (n > root.val)
			root.right = add(root.right, n);
		else
			;
		return root;
	}

	public TreeNode remove(TreeNode root, int n) {
		if (root == null)
			return null;
		if (root.val < n)
			root.left = remove(root.left, n);
		else if (root.val > n)
			root.right = remove(root.right, n);
		else if (root.left != null && root.right != null) {
			root.val = findMin(root.right).val;
			root.right = remove(root.right, root.val);
		} else if (root.left != null & root.right == null) {
			TreeNode child = root.left;
			root = child;
		} else if (root.left == null & root.right != null) {
			TreeNode child = root.right;
			root = child;
		} else
			root = null;

		return root;
	}

	private TreeNode findMin(TreeNode t) {
		if (t == null)
			return null;
		else if (t.left == null)
			return t;
		return findMin(t.left);
	}

	public int getK(TreeNode root, int k) {
		int count = 0;
		Stack<TreeNode> s = new Stack<>();
		putAllLeft(s, root);
		while (!s.isEmpty()) {
			TreeNode TreeNode = s.pop();
			count++;
			if (count == k)
				return TreeNode.val;
			putAllLeft(s, TreeNode.right);
		}
		return -1;
	}

	private void putAllLeft(Stack<TreeNode> s, TreeNode root) {
		while (root != null) {
			s.push(root);
			root = root.left;
		}
	}
}

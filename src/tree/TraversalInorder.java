package tree;

import java.util.*;

public class TraversalInorder {
	// 第三种 用stack
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		Deque<TreeNode> stack = new LinkedList<>();
		pushAllLeft(root, stack);
		TreeNode node = new TreeNode(0);
		while (!stack.isEmpty()) {
			node = stack.pop();
			res.add(node.val);
			pushAllLeft(node.right, stack);
		}
		return res;

	}

	private void pushAllLeft(TreeNode root, Deque<TreeNode> stack) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}
}

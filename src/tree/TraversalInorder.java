package tree;

import java.util.*;
//We push all the left children of root into the stack until there's no more nodes.
//Then we pop from the stack which we'd call cur.
//Add cur to result list
//Recursively call pushAllLeft() on cur's right child.

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

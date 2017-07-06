package tree;

import java.util.*;

public class TraversalPreorder {
	// ���ǵ�һ�� ���������뵽�ķ���
	private List<Integer> res = new LinkedList<>();

	public List<Integer> preorderTraversal1(TreeNode root) {
		preTraversal1(root);
		return res;
	}

	private void preTraversal1(TreeNode root) {
		if (root == null)
			return;
		res.add(root.val);
		preTraversal1(root.left);
		preTraversal1(root.right);
	}

	// �ڶ���addAll
	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> res = new LinkedList<>();
		if (root == null)
			return res;
		res.add(root.val);
		res.addAll(preorderTraversal2(root.left));
		res.addAll(preorderTraversal2(root.right));
		return res;
	}

	// ������ ��stack
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		Deque<TreeNode> stack = new LinkedList<>();
		stack.push(root);
		TreeNode node = new TreeNode(0);
		while (!stack.isEmpty()) {
			node = stack.pop();
			res.add(node.val);
			if (node.right != null)
				stack.push(node.right);
			if (node.left != null)
				stack.push(node.left);
		}
		return res;
	}
}

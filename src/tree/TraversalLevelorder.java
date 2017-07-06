package tree;

import java.util.*;

public class TraversalLevelorder {
	// ����List<List<Integer>> ��ȡ��ĳһ��list�� ����add ��ôList<List<Integer>> ��
	// ��Ӧ��list�ͻ�ı� ������д�� ��Ϊ�����õ���ͬһ��list�� ���ͨ��res.get(level)�õ���
	// Ȼ��res.get(level).add(root.val);
	// ��ô��Ӧ��list���Ѿ��ı���

	// DFS��
	List<List<Integer>> res = new LinkedList<>();

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		helper(root, 0);
		// Collections.reverse(res);
		return res;
	}

	private void helper(TreeNode root, int level) {
		if (root == null)
			return;
		if (res.size() <= level)
			res.add(new LinkedList<Integer>());
		res.get(level).add(root.val); // ע����ߣ�����������
		helper(root.left, level + 1);
		helper(root.right, level + 1);
	}

	// �÷ǵݹ�ʵ�� ��queue BFS��  �����Եø��� ��Ϊ�����Ҫ��ÿһ���á��������� ���� Ҫ��һ�� num = queue.size();
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root == null)
			return res;
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> subList = new LinkedList<>();
			int num = queue.size();
			while (num-- > 0) {
				TreeNode node = queue.poll();
				subList.add(node.val);
				
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);

			}
			res.add(subList);
		}
		return res;
	}

}

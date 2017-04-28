package tree;

import java.util.*;

public class SerializeDeserializeBST_449 {
	// �ҵĵ�һ��� �ò������ ���ô�null ��Ϊ��BST
	// ����ֻ��Ҫ��֤�����˳�򼴿�
	public String serialize(TreeNode root) {
		if (root == null)
			return "";
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			sb.append(node.val + ",");
			if (node.left != null)
				queue.offer(node.left);
			if (node.right != null)
				queue.offer(node.right);
		}
		return new String(sb);
	}

	// �ڶ��� ����������ǰ�����Ҳ����  ֻҪparent����child���л�����
	public String serialize2(TreeNode root) {
		if (root == null)
			return "";
		StringBuilder sb = new StringBuilder();
		buildString(root, sb);
		return sb.toString();
	}

	private void buildString(TreeNode root, StringBuilder sb) {
		sb.append(root.val + ",");
		if (root.left != null)
			buildString(root.left, sb);
		if (root.right != null)
			buildString(root.right, sb);
	}

	public TreeNode deserialize(String data) {
		if (data.equals(""))
			return null;
		String[] datas = data.split(",");
		TreeNode root = new TreeNode(Integer.parseInt(datas[0]));
		for (int i = 1; i < datas.length; i++)
			add(root, Integer.parseInt(datas[i]));
		return root;
	}

	private TreeNode add(TreeNode root, int i) {
		if (root == null)
			return new TreeNode(i);
		if (i < root.val)
			root.left = add(root.left, i);
		else
			root.right = add(root.right, i);
		return root;

	}
}

package tree;

import java.util.*;

public class SerializeDeserializeBT_297 {
	public String serialize1(TreeNode root) {
		if (root == null)
			return "$,";
		StringBuilder sb = new StringBuilder();
		sb.append(root.val);
		sb.append(",");
		sb.append(serialize1(root.left));
		sb.append(serialize1(root.right));
		return sb.toString();
	}

	public TreeNode deserialize2(String data) {
		return DeserializeHelper(new StringBuilder(data));
	}

	TreeNode DeserializeHelper(StringBuilder sb) {
		String s = new String(sb.substring(0, sb.indexOf(",")));
		sb.delete(0, sb.indexOf(",") + 1);
		if (s.equals("$"))
			return null;
		TreeNode root = new TreeNode(Integer.parseInt(s));
		root.left = DeserializeHelper(sb);
		root.right = DeserializeHelper(sb);
		return root;
	}

	// 别人的答案 比我快多了 思想差不多
	private static final String spliter = ",";
	private static final String NN = "X";

	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		buildString(root, sb);
		return sb.toString();
	}

	private void buildString(TreeNode node, StringBuilder sb) {
		if (node == null) {
			sb.append(NN).append(spliter);
		} else {
			sb.append(node.val).append(spliter);
			buildString(node.left, sb);
			buildString(node.right, sb);
		}
	}

	public TreeNode deserialize(String data) {
		Queue<String> nodes = new LinkedList<>();
		nodes.addAll(Arrays.asList(data.split(spliter)));
		return buildTree(nodes);
	}

	private TreeNode buildTree(Queue<String> nodes) {
		String val = nodes.poll(); // 这很巧妙
		if (val.equals(NN))
			return null;
		TreeNode node = new TreeNode(Integer.valueOf(val));
		node.left = buildTree(nodes);
		node.right = buildTree(nodes);
		return node;
	}
}

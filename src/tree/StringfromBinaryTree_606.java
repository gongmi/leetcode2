package tree;

import java.util.*;

public class StringfromBinaryTree_606 {
	StringBuilder sb = new StringBuilder();

	public String tree2str(TreeNode t) {
		helper(t);
		return sb.toString();

	}

	private void helper(TreeNode root) {
		if (root == null) {
			return;
		}

		sb.append(root.val);
		if (root.left == null && root.right == null)
			return;

		sb.append("(");
		tree2str(root.left);
		sb.append(")");

		if (root.right != null) {
			sb.append("(");
			tree2str(root.right);
			sb.append(")");
		}

	}

	// top
	public String tree2str2(TreeNode t) {
		if (t == null)
			return "";

		String result = t.val + "";

		String left = tree2str(t.left);
		String right = tree2str(t.right);

		if (left == "" && right == "")
			return result;
		if (left == "")
			return result + "()" + "(" + right + ")";
		if (right == "")
			return result + "(" + left + ")";
		return result + "(" + left + ")" + "(" + right + ")";
	}
}

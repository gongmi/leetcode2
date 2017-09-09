package tree;

import java.util.*;

public class MinAbsoluteDifferenceBST_530 {
	// BST�ܼ� �����������
	TreeNode prev = null;
	int res = Integer.MAX_VALUE;

	public int getMinimumDifference(TreeNode root) {
		dfs(root);
		return res;
	}

	private void dfs(TreeNode root) {
		if (root == null)
			return;
		dfs(root.left);
		if (prev != null) {
			res = Math.min(res, root.val - prev.val);
		}
		prev = root;
		dfs(root.right);
	}

	// ���ֻ����ͨ��BT ���԰�node��val �Ž�treeSet
	// ע�� floor ceiling�� higher lower������
	TreeSet<Integer> set = new TreeSet<>();
	int min = Integer.MAX_VALUE;

	public int getMinimumDifference2(TreeNode root) {
		if (root == null)
			return min;

		if (!set.isEmpty()) {
			if (set.floor(root.val) != null) {
				min = Math.min(min, root.val - set.floor(root.val));
			}
			if (set.ceiling(root.val) != null) {
				min = Math.min(min, set.ceiling(root.val) - root.val);
			}
		}

		set.add(root.val);

		getMinimumDifference(root.left);
		getMinimumDifference(root.right);

		return min;
	}
}

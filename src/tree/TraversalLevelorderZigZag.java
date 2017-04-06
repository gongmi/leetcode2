package tree;

import java.util.*;

public class TraversalLevelorderZigZag {
	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		helper(root, 0);
		return res;
	}

	private void helper(TreeNode root, int level) {
		if (root == null)
			return;
		if (res.size() == level)
			res.add(new ArrayList<Integer>());
		if ((level & 1) == 1)
			res.get(level).add(0, root.val);
		else
			res.get(level).add(root.val);
		helper(root.left, level + 1);
		helper(root.right, level + 1);

	}
}

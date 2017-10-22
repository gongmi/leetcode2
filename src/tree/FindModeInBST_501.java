package tree;

import java.util.*;

public class FindModeInBST_501 {
	// 其实就是中序遍历
	// 然后看出现次数最多的那个val
	// 和第二个top答案一样
	List<Integer> res = new ArrayList<>();
	TreeNode prev = null;
	int count = 0;
	int maxCount = 0;

	public int[] findMode(TreeNode root) {
		if (root == null)
			return new int[0];
		inOrder(root);
		int[] ret = new int[res.size()];
		for (int i = 0; i < ret.length; i++)
			ret[i] = res.get(i);
		return ret;
	}

	private void inOrder(TreeNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		if (prev == null || root.val == prev.val) {
			count++;
		} else {
			count = 1;
		}
		if (count > maxCount)
			res.clear();
		if (count >= maxCount)
			res.add(root.val);
		maxCount = Math.max(count, maxCount);
		prev = root;

		inOrder(root.right);
	}
}

package tree;

import java.util.*;

//别人的答案 剑指offer的思想 先add 再delete 相当于是栈 这样可以减少new的list
public class PathSumII_113 {
	List<List<Integer>> ret = new ArrayList<List<Integer>>();
	List<Integer> cur = new ArrayList<Integer>();

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if (root == null)
			return ret;

		cur.add(root.val);
		if (root.left == null && root.right == null && root.val == sum) {
			ret.add(new ArrayList<>(cur));
		} else {
			pathSum(root.left, sum - root.val);
			pathSum(root.right, sum - root.val);
		}
		cur.remove(cur.size() - 1);
		return ret;
	}

	// 我的答案 不好 每到一个node 都要new一个list
	ArrayList<ArrayList<Integer>> res = new ArrayList<>();

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		helper(root, target, new ArrayList<Integer>());
		return res;
	}

	private void helper(TreeNode root, int target, ArrayList<Integer> list) {
		if (root == null)
			return;
		list.add(root.val);
		if (target == root.val && root.left == null && root.right == null)
			res.add(list);

		helper(root.left, target - root.val, new ArrayList<Integer>(list));
		helper(root.right, target - root.val, new ArrayList<Integer>(list));
	}
}

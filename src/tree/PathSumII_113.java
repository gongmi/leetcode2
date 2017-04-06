package tree;

import java.util.*;

//���˵Ĵ� ��ָoffer��˼�� ��add ��delete �൱����ջ �������Լ���new��list
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

	// �ҵĴ� ���� ÿ��һ��node ��Ҫnewһ��list
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

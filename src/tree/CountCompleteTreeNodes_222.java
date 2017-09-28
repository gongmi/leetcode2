package tree;

public class CountCompleteTreeNodes_222 {
	// 前序遍历 2000超时 所以考虑后序遍历 因为2000从右边很容易发现
	// 改成后序遍历 4098超时 因为是第一个多一个 所以相当于全部遍历一遍 也超时
	// 看了答案之后 注意 求幂运算用左移！！！ 不要用power
	// I have O(log(n)) steps. 
	// Finding a height costs O(log(n)).
	// So overall O(log(n)^2).
	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;
		int left = depth(root.left);
		int right = depth(root.right);
		if (left == right) {
			return (1 << left) + countNodes(root.right);
		} else {
			return (1 << right) + countNodes(root.left);
		}
	}

	private int depth(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + depth(root.left);
	}
}

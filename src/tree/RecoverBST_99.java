package tree;


public class RecoverBST_99 {
	// 其实就是中序遍历 从小到大 然后看 不满足 从小到大的两个数
	// 题目要求了 要 O(1) space 应该使用 TraversalInorderMorris
	// 下面这种递归 或者stack都是不满足
	public class Solution {
		TreeNode firstElement = null;
		TreeNode secondElement = null;
		TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);

		public void recoverTree(TreeNode root) {
			traverse(root);
			int temp = firstElement.val;
			firstElement.val = secondElement.val;
			secondElement.val = temp;
		}

		private void traverse(TreeNode root) {
			if (root == null)
				return;
			traverse(root.left);
			if (firstElement == null && prevElement.val >= root.val) {
				firstElement = prevElement;
			}
			if (firstElement != null && prevElement.val >= root.val) {
				secondElement = root;
			}
			prevElement = root;
			traverse(root.right);
		}
	}
}

package tree;

import java.util.*;
//其实就是利用了inorder Traversal 反过来 右中左
//就是把BST的数反着从stack中pop出来 维持一个prevSum 加到当前node的value即可

public class ConvertBSTtoGreaterTree_538 {
	public TreeNode convertBST(TreeNode root) {
		if (root == null)
			return null;

		Stack<TreeNode> s = new Stack<>();
		pushAllRight(s, root);
		int prevSum = 0;
		while (!s.isEmpty()) {
			TreeNode node = s.pop();
			prevSum += node.val;
			node.val = prevSum;
			pushAllRight(s, node.left);
		}
		return root;
	}

	private void pushAllRight(Stack<TreeNode> s, TreeNode root) {

		while (root != null) {
			s.push(root);
			root = root.right;
		}

	}

	// 这是别人的递归
	int sum = 0;

	public TreeNode convertBST2(TreeNode root) {
		convert(root);
		return root;
	}

	public void convert(TreeNode cur) {
		if (cur == null)
			return;
		convert(cur.right);
		cur.val += sum;
		sum = cur.val;
		convert(cur.left);
	}

}

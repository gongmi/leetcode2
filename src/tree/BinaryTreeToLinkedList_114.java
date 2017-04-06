package tree;

import java.util.*;

public class BinaryTreeToLinkedList_114 {
	// 其实就是前序遍历的顺序 所以我用了前序遍历的stack
	// 然后 把当前这个pop出来的node的right指向下一个pop出来的node
	// 后来看了一个top3的答案和我一样的思路 但是别人没有用prev 
	// 用的是curr.right = stack.peek(); 厉害了
	public void flatten2(TreeNode root) {
		if (root == null)
			return;
		Deque<TreeNode> stack = new LinkedList<>();
		stack.push(root);
		// TreeNode prev = new TreeNode(0);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			if (cur.right != null)
				stack.push(cur.right);
			if (cur.left != null)
				stack.push(cur.left);
			if (!stack.isEmpty())                //top3 的答案
				cur.right = stack.peek();        //top3 的答案
			// prev.right = cur;
			// prev = cur;
			cur.left = null;
		}
	}

// top答案 其实就是递归的前序遍历 前序遍历的顺序是中左右
//	但是这边要先找到最右结点 让它作为prev 再找左 再找中 让当前root的right =prev即可完成
//	其实就是 右左中这样一个遍历的顺序 
//	与剑指offer的BSTtoDoubleLinkedList_27相似
 
	private TreeNode prev = null;

	public void flatten(TreeNode root) {
		if (root == null)
			return;
		flatten(root.right);
		flatten(root.left);
		root.right = prev;
		root.left = null;
		prev = root;
	}
}

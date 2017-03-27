package tree;

import java.util.*;

public class TraversalPostorder {
	// 第三种 用stack
//	pre-order traversal is root-left-right, 
//	and post order is left-right-root. 
//	modify the code for pre-order to make it root-right-left, 
//	and then reverse the output so that we can get left-right-root .
	public List<Integer> postorderTraversal(TreeNode root) {
//		LinkedList<Integer> res = new LinkedList<>();
		List<Integer> res = new LinkedList<>();
		if (root == null)
			return res;
		Deque<TreeNode> stack = new LinkedList<>();
		stack.push(root);
		TreeNode node = new TreeNode(0);
		while (!stack.isEmpty()) {
			node = stack.pop();
//			res.addFirst(node.val);//这里res要定义成LinkedList才能用addFirst
			res.add(node.val);
			
			if (node.left != null)
				stack.push(node.left);
			if (node.right != null)
				stack.push(node.right);
		}
		Collections.reverse(res);
		return res;
	}
}

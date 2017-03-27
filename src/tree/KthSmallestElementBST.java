package tree;

import java.util.*;

public class KthSmallestElementBST {
	// 用了中序遍历的思想 就是 到第k个就停止嘛 
//	迭代        stack
	// public int kthSmallest(TreeNode root, int k) {
	// Deque<TreeNode> stack = new LinkedList<>();
	// pushAllLeft(root, stack);
	// TreeNode node = new TreeNode(0);
	//
	// while (k-- > 0) {
	// node = stack.pop();
	// pushAllLeft(node.right, stack);
	// }
	// return node.val;
	// }
	//
	// private void pushAllLeft(TreeNode root, Deque<TreeNode> stack) {
	// while (root != null) {
	// stack.push(root);
	// root = root.left;
	// }
	// }
	
//	这是递归
//	private static int n = 0;
//	private static int val = 0;
//
//	public int kthSmallest(TreeNode root, int k) {
//		n = k;
//		ks(root);
//		return val;
//	}
//
//	public void ks(TreeNode root) {
//		if (root.left != null)
//			ks(root.left);
//		n--;
//		if (n == 0) {
//			val = root.val;
//			return;
//		}
//		if (root.right != null)
//			ks(root.right);
//	}
	
//	countNodes函数 来算出当前这个root的树一共有多少node
	  public int kthSmallest(TreeNode root, int k) {
	        int count = countNodes(root.left);
	        if (k <= count) {
	            return kthSmallest(root.left, k);
	        } else if (k > count + 1) {
	            return kthSmallest(root.right, k-1-count); // 1 is counted as current node
	        }
	        
	        return root.val;
	    }
	    
	    public int countNodes(TreeNode n) {
	        if (n == null) return 0;
	        
	        return 1 + countNodes(n.left) + countNodes(n.right);
	    }
}

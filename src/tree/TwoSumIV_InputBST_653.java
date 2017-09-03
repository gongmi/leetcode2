package tree;

import java.util.Stack;
//我的第一版答案 

//我为了用TwoSumII_167 的双指针 方法
//把二叉树的左边和右边分别存放在一个stack中
//就是相当于两个中序遍历 但是一个是从小到大 一个是从大到小的
//非递归的 
//时间复杂度是o（N）的

//top 有三种方法
//1 就是遍历tree 遍历时 一边把遍历到的数放到set中 并且在set中找 
//相似于TwoSum_1 这种方法是适用于BT 即无序的数组
//2 中序遍历tree 放到一个数组中 就变成了一个有序数组 用TwoSumII_167 双指针
//3 二分法 就是从root开始 node=root  找是否存在 k - node.val 复杂度为 logn
//每个节点都要找一下 即O(nlogn)
public class TwoSumIV_InputBST_653 {
	public boolean findTarget(TreeNode root, int k) {
		Stack<TreeNode> small = new Stack<>();
		Stack<TreeNode> large = new Stack<>();

		pushAllLeft(root, small);
		pushAllRight(root, large);

		while (!small.isEmpty() && !large.isEmpty() && small.peek() != large.peek()) {
			int sum = small.peek().val + large.peek().val;
			if (sum == k)
				return true;
			else if (sum > k)
				pushAllRight(large.pop().left, large);
			else
				pushAllLeft(small.pop().right, small);
		}
		return false;

	}

	private void pushAllLeft(TreeNode root, Stack<TreeNode> s) {
		while (root != null) {
			s.push(root);
			root = root.left;
		}
	}

	private void pushAllRight(TreeNode root, Stack<TreeNode> s) {
		while (root != null) {
			s.push(root);
			root = root.right;
		}
	}
}

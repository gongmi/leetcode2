package tree;

import java.util.Arrays;

public class ConstructBinaryTree_105_106 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0)
			return null;
		int length = preorder.length;

		TreeNode root = new TreeNode(preorder[0]);

		int i = 0;
		while (inorder[i] != preorder[0])
			i++;

		root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1),
				Arrays.copyOfRange(inorder, 0, i));
		root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, length),
				Arrays.copyOfRange(inorder, i + 1, length));
		return root;

	}

	// 别人的和剑指offer一样的
//	比我快 因为我用了Arrays.copyOfRange 而他一直都是那一个数组 只是改变index
	public TreeNode buildTree2(int[] preorder, int[] inorder) {
		return helper(0, 0, inorder.length - 1, preorder, inorder);
	}

	public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
		if (preStart > preorder.length - 1 || inStart > inEnd) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preStart]);

		int inIndex = inStart; // Index of current root in inorder

		while (inorder[inIndex] != root.val)
			inIndex++;

		root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
		root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
		return root;
	}
}

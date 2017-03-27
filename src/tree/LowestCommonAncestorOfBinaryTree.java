package tree;

import java.util.*;

//top 代码
//If the current (sub)tree contains both p and q, 
//then the function result is their LCA.
//If only one of them is in that subtree, 
//then the result is that one of them. 
//If neither are in that subtree, the result is null.

//如果以root为根的树里有p和q 就返回他们的LCA
//如果以root为根的树里有p或q其中一个  就返回p或者q
//如果都没有 就返回null
//这样的话 p 或 q就会一直往上传递 或者LCA往上传递  好厉害 用心感受
public class LowestCommonAncestorOfBinaryTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null)
			return root;
		if (left != null && right == null)
			return left;
		if (left == null && right != null)
			return right;
		return null;

	}
}

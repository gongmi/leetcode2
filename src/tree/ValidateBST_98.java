package tree;

import java.util.*;

public class ValidateBST_98 {
	// 其实就是中序遍历是否是从小到大 与RecoverBST_98相似 
	TreeNode prev = null;

	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		if (isValidBST(root.left) && ((prev == null) || root.val > prev.val))
			prev = root;
		else
			return false;

		return isValidBST(root.right);
	}
}

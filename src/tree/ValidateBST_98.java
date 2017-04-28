package tree;

import java.util.*;

public class ValidateBST_98 {
	// ��ʵ������������Ƿ��Ǵ�С���� ��RecoverBST_98���� 
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

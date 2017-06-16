package tree;
//½£Ö¸offer 18
public class SubtreeofAnotherTree_572 {
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null && t != null)
			return false;
		return sameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
	}

	private boolean sameTree(TreeNode s, TreeNode t) {
		if (s == null && t == null)
			return true;
		if ((s == null && t != null) || (s != null && t == null) || (s.val != t.val))
			return false;
		return sameTree(s.left, t.left) && sameTree(s.right, t.right);
	}
}


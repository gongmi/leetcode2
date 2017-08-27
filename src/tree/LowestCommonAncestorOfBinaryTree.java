package tree;

import java.util.*;

//top ����
//If the current (sub)tree contains both p and q, 
//then the function result is their LCA.
//If only one of them is in that subtree, 
//then the result is that one of them. 
//If neither are in that subtree, the result is null.

//�����rootΪ����������p��q �ͷ������ǵ�LCA
//�����rootΪ����������p��q����һ��  �ͷ���p����q
//�����û�� �ͷ���null
//�����Ļ� p �� q�ͻ�һֱ���ϴ��� ����LCA���ϴ���  ������ ���ĸ���
public class LowestCommonAncestorOfBinaryTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left == null)
			return right;
		if (right == null)
			return left;
		return root;

	}

	// �������BST ����
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) return root;
        if (root.val>p.val&&root.val>q.val){
            return lowestCommonAncestor(root.left,p,q);
        }else if (root.val<p.val&&root.val<q.val){
              return lowestCommonAncestor(root.right,p,q);
        }else{
            return root;
        }
    }
}

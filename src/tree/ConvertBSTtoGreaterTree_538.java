package tree;

import java.util.*;
//��ʵ����������inorder Traversal ������ ������
//���ǰ�BST�������Ŵ�stack��pop���� ά��һ��prevSum �ӵ���ǰnode��value����

public class ConvertBSTtoGreaterTree_538 {
	public TreeNode convertBST(TreeNode root) {
		if (root == null)
			return null;

		Stack<TreeNode> s = new Stack<>();
		pushAllRight(s, root);
		int prevSum = 0;
		while (!s.isEmpty()) {
			TreeNode node = s.pop();
			prevSum += node.val;
			node.val = prevSum;
			pushAllRight(s, node.left);
		}
		return root;
	}

	private void pushAllRight(Stack<TreeNode> s, TreeNode root) {

		while (root != null) {
			s.push(root);
			root = root.right;
		}

	}

	// ���Ǳ��˵ĵݹ�
	int sum = 0;

	public TreeNode convertBST2(TreeNode root) {
		convert(root);
		return root;
	}

	public void convert(TreeNode cur) {
		if (cur == null)
			return;
		convert(cur.right);
		cur.val += sum;
		sum = cur.val;
		convert(cur.left);
	}

}

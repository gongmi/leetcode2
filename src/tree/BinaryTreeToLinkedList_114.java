package tree;

import java.util.*;

public class BinaryTreeToLinkedList_114 {
	// ��ʵ����ǰ�������˳�� ����������ǰ�������stack
	// Ȼ�� �ѵ�ǰ���pop������node��rightָ����һ��pop������node
	// ��������һ��top3�Ĵ𰸺���һ����˼· ���Ǳ���û����prev 
	// �õ���curr.right = stack.peek(); ������
	public void flatten2(TreeNode root) {
		if (root == null)
			return;
		Deque<TreeNode> stack = new LinkedList<>();
		stack.push(root);
		// TreeNode prev = new TreeNode(0);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			if (cur.right != null)
				stack.push(cur.right);
			if (cur.left != null)
				stack.push(cur.left);
			if (!stack.isEmpty())                //top3 �Ĵ�
				cur.right = stack.peek();        //top3 �Ĵ�
			// prev.right = cur;
			// prev = cur;
			cur.left = null;
		}
	}

	// top�� ��ͨ���벻����
    //      1
    //     / \
    //    2   3      
    //   ���
    //      1
    //       \
    //        2
    //         \
    //          3
    //      1
    //     / \
    //    2   4 
    //     \   \
    //      3   5 
    //     ���
    //      1
    //       \
    //        2
    //         \
    //          3 
    //           \
    //            4
    //             \
    //              5
	private TreeNode prev = null;

	public void flatten(TreeNode root) {
		if (root == null)
			return;
		flatten(root.right);
		flatten(root.left);
		root.right = prev;
		root.left = null;
		prev = root;
	}
}

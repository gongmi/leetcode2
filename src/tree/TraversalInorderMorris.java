package tree;

import java.util.*;
//http://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html

//Morris�����������ǵݹ飬����ջ��O(1)�ռ䣩 ��ʵ��������ǰ������rightָ��cur ���� �ͺ��ҵ�parent��
// �����ǰ�ڵ��left
//1. Ϊ�գ�   �������ǰ�ڵ㲢����right��Ϊ��ǰ�ڵ㡣
//2.��Ϊ�գ��ڵ�ǰ�ڵ��left�������ҵ���ǰ�ڵ�����������µ�ǰ���ڵ㡣
//   a) ���ǰ���ڵ��rightΪ�գ�������right����Ϊ��ǰ�ڵ㡣��ǰ�ڵ����Ϊ��ǰ�ڵ��left��
//   b) ���ǰ���ڵ��rightΪ��ǰ�ڵ㣬������right������Ϊ�գ��ָ�������״����
//		�����ǰ�ڵ㡣��ǰ�ڵ����Ϊ��ǰ�ڵ��right��
//3. �ظ�����1����2ֱ����ǰ�ڵ�Ϊ�ա�
public class TraversalInorderMorris {
	public void inorderMorrisTraversal(TreeNode root) {
		TreeNode cur = root, prev = null;
		while (cur != null) {
			if (cur.left == null) // 1.
			{
				System.out.println(cur.val);
				cur = cur.right;
			} else // 2.find predecessor
			{
				prev = cur.left;
				while (prev.right != null && prev.right != cur) //2.һֱ������ ֱ��Ϊnull ��ǰ�ڵ�
					prev = prev.right;
//				�����������е�һ�����ƻ� ����whileֹͣ
				if (prev.right == null) // 2.a) Ϊnull
				{
					prev.right = cur;
					cur = cur.left;
				} else 					// 2.b) Ϊ��ǰ���
				{
					prev.right = null;
					System.out.println(cur.val);
					cur = cur.right;
				}
			}
		}
	}
}

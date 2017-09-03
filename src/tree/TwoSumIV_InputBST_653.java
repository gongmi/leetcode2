package tree;

import java.util.Stack;
//�ҵĵ�һ��� 

//��Ϊ����TwoSumII_167 ��˫ָ�� ����
//�Ѷ���������ߺ��ұ߷ֱ�����һ��stack��
//�����൱������������� ����һ���Ǵ�С���� һ���ǴӴ�С��
//�ǵݹ�� 
//ʱ�临�Ӷ���o��N����

//top �����ַ���
//1 ���Ǳ���tree ����ʱ һ�߰ѱ����������ŵ�set�� ������set���� 
//������TwoSum_1 ���ַ�����������BT �����������
//2 �������tree �ŵ�һ�������� �ͱ����һ���������� ��TwoSumII_167 ˫ָ��
//3 ���ַ� ���Ǵ�root��ʼ node=root  ���Ƿ���� k - node.val ���Ӷ�Ϊ logn
//ÿ���ڵ㶼Ҫ��һ�� ��O(nlogn)
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

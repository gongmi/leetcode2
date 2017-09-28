package tree;

public class CountCompleteTreeNodes_222 {
	// ǰ����� 2000��ʱ ���Կ��Ǻ������ ��Ϊ2000���ұߺ����׷���
	// �ĳɺ������ 4098��ʱ ��Ϊ�ǵ�һ����һ�� �����൱��ȫ������һ�� Ҳ��ʱ
	// ���˴�֮�� ע�� �������������ƣ����� ��Ҫ��power
	// I have O(log(n)) steps. 
	// Finding a height costs O(log(n)).
	// So overall O(log(n)^2).
	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;
		int left = depth(root.left);
		int right = depth(root.right);
		if (left == right) {
			return (1 << left) + countNodes(root.right);
		} else {
			return (1 << right) + countNodes(root.left);
		}
	}

	private int depth(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + depth(root.left);
	}
}

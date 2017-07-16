package dynamicProgramming;

import java.util.HashMap;

import tree.TreeNode;

//��top�Ľ��� ����ֱ�۵Ĵ��뵽�Ż� ��·���̣���������������������
//�����ص������⣡

public class HouseRobberIII_337 {
	// top answer�Ľⷨ1
	// �Ҹտ�ʼ��Ϊ�Ƿֲ���� ���ǲ�������ô��
	// ��������˼ά�뷨 ��ʵ��Ӧ�ÿ���д������ ���Ǿ���̫�뵱Ȼ�� û�ҳ��� �������� Time Limit Exceeded
	// ��Ϊ�ܶ�������rob�����ظ������� ����Ҫ��map������װ���� 7ms
	private HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();

	public int rob2(TreeNode root) {
		if (root == null)
			return 0;
		if (map.containsKey(root))
			return map.get(root);
		int val = 0;
		if (root.left != null)
			val = val + rob(root.left.left) + rob(root.left.right);
		if (root.right != null)
			val = val + rob(root.right.left) + rob(root.right.right);
		int n = Math.max(val + root.val, rob(root.left) + rob(root.right));
		map.put(root, n);
		return n;
	}

	// top ����2��ֻҪ2ms

	// the first element res[0] :if root is not robbed,
	// the second element res[1] :if root is robbed.
	public int rob(TreeNode root) {
		int[] res = robSub(root);
		return Math.max(res[0], res[1]);
	}

	private int[] robSub(TreeNode root) {
		if (root == null) {
			return new int[2];
		}

		int[] left = robSub(root.left);
		int[] right = robSub(root.right);

		int[] res = new int[2];
		res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		res[1] = root.val + left[0] + right[0];

		return res;
	}

	// 2017.7 ��д�� ��Ӧ�þ�����ν�ĳ�ʱ����

	public int rob3(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int sumYes = root.val;
		int sumNo = 0;
		if (root.left != null) {
			sumYes += rob(root.left.left);
			sumYes += rob(root.left.right);
			sumNo += rob(root.left);
		}
		if (root.right != null) {
			sumYes += rob(root.right.left);
			sumYes += rob(root.right.right);
			sumNo += rob(root.right);
		}
		return Math.max(sumYes, sumNo);

	}
}

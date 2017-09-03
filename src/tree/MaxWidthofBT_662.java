package tree;

import java.util.ArrayList;
import java.util.List;

// ��һ��� ���� ����ֻ����������� �п������м��ĳһ��node �������һ���� �и����
// ����[1,1,1,1,1,1,1,null,null,null,1,null,null,null,null,2,2,2,2,2,2,2,null,2,null,null,2,null,2]

//�ڶ��� ��ȷ�� 
//����һ�� list�����ÿһ��� ���������
// ��TraversalLevelorder����
// List<List<Integer>> list = new ArrayList<>();
public class MaxWidthofBT_662 {

	// top�� ���ô����� ÿ�ζ���һ��max
	private int max = 1;
	List<Integer> list = new ArrayList<>();

	public int widthOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;

		helper(root, 0, 1);
		return max;
	}

	public void helper(TreeNode root, int level, int index) {
		if (root == null)
			return;
		if (level == list.size()) // ��Ϊ�Ǵ����dfs ���� ������һ����δ����Ĳ�ʱ һ��������
			list.add(index);
		max = Math.max(max, index + 1 - list.get(level));
		helper(root.left, level + 1, index * 2);
		helper(root.right, level + 1, index * 2 + 1);
	}
}

package tree;

import java.util.*;

//��II�������� ���ô�root ��leaf ����һ�ζ����� ����ֻ�÷�������ĸ���
//�ҵĽⷨ ʱ�临�ӶȺܴ� ��Ϊÿ���ڵ㶼Ҫ���� Ȼ��������ڵ�Ϊroot������helper

public class PathSumIII_437 {
	int res = 0;

	public int pathSum(TreeNode root, int sum) {
		if (root == null)
			return 0;
		helper(root, sum);
		pathSum(root.left, sum);
		pathSum(root.right, sum);
		return res;
	}

	private void helper(TreeNode root, int sum) {
		if (root == null)
			return;
		if (root.val == sum)
			res++;
		helper(root.left, sum - root.val);
		helper(root.right, sum - root.val);
	}

	// TwoSum_1��˼�� ��һ��hashmap ���������е�prefix sum
	// hashmap<prefixSum,freq> ע�� �����ŵ��ǴӸ���ʼ���sum ����
	// ���������presumһ�� ���õ���target�ͺ�
	// �е���RangeSumQuery_303 ����ֻ��˼��һ�� ����˵range��Sum�����ɴӸ���range���������sum����ȥ�õ�
	// ʱ�临�Ӷ�O��N��
//	    10               10,1
//     /  \
//    5   -3			15,1
//   / \    \		
//  3   2   11			18,1  18-10=8 res=res+1;           17,1
// / \   \
//3  -2   1				21,1                       16,1    18,1   18-10=8 res=res+1

	HashMap<Integer, Integer> map = new HashMap<>();
	int result = 0;

	public int pathSum2(TreeNode root, int sum) {
		if (root == null)
			return 0;
		map.put(0, 1);
		helper(root, sum, 0);
		return result;
	}

	private void helper(TreeNode root, int target, int preSum) {
		if (root == null)
			return;

		preSum += root.val;
		result += map.getOrDefault(preSum - target, 0);
		map.put(preSum, map.getOrDefault(preSum, 0) + 1);

		helper(root.left, target, preSum);
		helper(root.right, target, preSum);
		map.put(preSum, map.get(preSum) - 1);
	}
}

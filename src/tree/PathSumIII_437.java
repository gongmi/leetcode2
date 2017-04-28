package tree;

import java.util.*;

//与II的区别是 不用从root 到leaf 任意一段都可以 但是只用返回满足的个数
//我的解法 时间复杂度很大 因为每个节点都要遍历 然后以这个节点为root来调用helper

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

	// TwoSum_1的思想 用一个hashmap 来保存所有的prefix sum
	// hashmap<prefixSum,freq> 注意 这里存放的是从根开始算的sum 这样
	// 如果有两个presum一减 正好等于target就好
	// 有点像RangeSumQuery_303 但是只是思想一样 就是说range的Sum可以由从根到range的两个点的sum来减去得到
	// 时间复杂度O（N）
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

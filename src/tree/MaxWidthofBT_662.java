package tree;

import java.util.ArrayList;
import java.util.List;

// 第一版答案 错了 不能只找最左和最右 有可能在中间的某一个node 延伸出了一棵树 有更宽的
// 比如[1,1,1,1,1,1,1,null,null,null,1,null,null,null,null,2,2,2,2,2,2,2,null,2,null,null,2,null,2]

//第二版 正确了 
//我用一个 list来存放每一层的 最左和最右
// 与TraversalLevelorder相似
// List<List<Integer>> list = new ArrayList<>();
public class MaxWidthofBT_662 {

	// top答案 不用存最右 每次都算一个max
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
		if (level == list.size()) // 因为是从左边dfs 所以 当到达一个从未到达的层时 一定是最左
			list.add(index);
		max = Math.max(max, index + 1 - list.get(level));
		helper(root.left, level + 1, index * 2);
		helper(root.right, level + 1, index * 2 + 1);
	}
}

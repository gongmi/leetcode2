package tree;

import java.util.*;

public class AverageOfLevels_637 {
	// 类似于TraversalLevelorder

	// 要考虑溢出的问题 Integer。maxvalue+Integer。maxvalue会溢出
	// 所以一开始就把sumList定义为double

	List<Double> sumList = new ArrayList<>();
	List<Integer> countList = new ArrayList<>();

	public List<Double> averageOfLevels(TreeNode root) {
		helper(root, 0);

		for (int i = 0; i < sumList.size(); i++) {
			sumList.set(i, sumList.get(i) / countList.get(i));
		}
		return sumList;
	}

	private void helper(TreeNode root, int level) {
		if (root == null) {
			return;
		}
		if (sumList.size() == level) {
			sumList.add((double) root.val);
			countList.add(1);
		} else {
			sumList.set(level, sumList.get(level) + root.val);
			countList.set(level, countList.get(level) + 1);
		}
		helper(root.left, level + 1);
		helper(root.right, level + 1);
	}

	// BFS 用queue
	public List<Double> averageOfLevels2(TreeNode root) {
		List<Double> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		double sum = 0;
		int count = 0;
		while (!queue.isEmpty()) {
			count = queue.size();
			sum = 0;
			for (int i = 0; i < count; i++) {
				TreeNode node = queue.poll();
				sum += node.val;
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			res.add(sum / count);

		}
		return res;
	}
}

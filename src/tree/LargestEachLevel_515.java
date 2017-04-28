package tree;

import java.util.*;
//就是层序遍历 加点东西 我用的BFS 
public class LargestEachLevel_515 {
	List<Integer> res = new ArrayList<>();

	public List<Integer> largestValues(TreeNode root) {
		if (root == null)
			return res;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int level_max = Integer.MIN_VALUE;
			int size = queue.size();
			while (size-- > 0) {
				TreeNode node = queue.poll();
				if (node.val > level_max)
					level_max = node.val;
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);

			}
			res.add(level_max);
		}
		return res;
	}
}

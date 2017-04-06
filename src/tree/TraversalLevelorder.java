package tree;

import java.util.*;

public class TraversalLevelorder {
//关于List<List<Integer>> 当取出某一个list后 进行add 那么List<List<Integer>> 中
//	相应的list就会改变 不用再写回 因为是引用到了同一个list嘛 如果通过res.get(level)拿到了
//	然后res.get(level).add(root.val); 
//	那么相应的list就已经改变了
//   DFS：	
//	List<List<Integer>> res = new LinkedList<>();
//	public List<List<Integer>> levelOrderBottom(TreeNode root) {
//		helper(root, 0);
////		Collections.reverse(res);
//		return res;
//	}
//
//	private void helper(TreeNode root, int level) {
//		if (root == null)
//			return;
//		if (res.size() <= level)
//			res.add(new LinkedList<Integer>());
//		res.get(level).add(root.val);  //注意这边 
//		helper(root.left, level + 1);
//		helper(root.right, level + 1);
//	}
	
//	用非递归实现 用queue BFS：
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new LinkedList<>();
		Queue<TreeNode> queue=new LinkedList<>();
		if (root==null) return res;
		queue.offer(root);
		while(!queue.isEmpty())
		{   List<Integer> subList = new LinkedList<>();
			int num=queue.size();
			while(num-->0)
			{
				TreeNode node = queue.poll();
				if (node.left!=null) queue.offer(node.left);
				if (node.right!=null) queue.offer(node.right);
				subList.add(node.val);
			}
			res.add(subList);
		}
		return res;
	}
	
}

package tree;

import java.util.*;
//  Traversal Level orderµÄË¼Ïë
public class FindBottomLeftTreeValue_513 {
	public int findBottomLeftValue(TreeNode root) {
		int res = root.val;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			int k = 0;
			while (k < size) {
				TreeNode node = queue.poll();
				if (k == 0)
					res = node.val;
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
				k++;
			}
		}
		return res;
	}
//	top answer 
//	Doing BFS right-to-left 
//	means we can simply return the last node's value 
//	and don't have to keep track of the first node 
//	in the current row or even care about rows at all.
	
	public int findLeftMostNode2(TreeNode root) {
	    Queue<TreeNode> queue = new LinkedList<>();
	    queue.add(root);
	    while (!queue.isEmpty()) {
	        root = queue.poll();
	        if (root.right != null)
	            queue.add(root.right);
	        if (root.left != null)
	            queue.add(root.left);
	    }
	    return root.val;
	}	
}

package tree;

import java.util.*;
//http://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html

//Morris遍历方法（非递归，不用栈，O(1)空间） 其实就是利用前驱结点的right指向cur 这样 就好找到parent了
// 如果当前节点的left
//1. 为空，   则输出当前节点并将其right作为当前节点。
//2.不为空，在当前节点的left子树中找到当前节点在中序遍历下的前驱节点。
//   a) 如果前驱节点的right为空，将它的right设置为当前节点。当前节点更新为当前节点的left。
//   b) 如果前驱节点的right为当前节点，将它的right重新设为空（恢复树的形状）。
//		输出当前节点。当前节点更新为当前节点的right。
//3. 重复以上1或者2直到当前节点为空。
public class TraversalInorderMorris {
	public void inorderMorrisTraversal(TreeNode root) {
		TreeNode cur = root, prev = null;
		while (cur != null) {
			if (cur.left == null) // 1.
			{
				System.out.println(cur.val);
				cur = cur.right;
			} else // 2.find predecessor
			{
				prev = cur.left;
				while (prev.right != null && prev.right != cur) //2.一直找最右 直到为null 或当前节点
					prev = prev.right;
//				有两个条件中的一个被破坏 所以while停止
				if (prev.right == null) // 2.a) 为null
				{
					prev.right = cur;
					cur = cur.left;
				} else 					// 2.b) 为当前结点
				{
					prev.right = null;
					System.out.println(cur.val);
					cur = cur.right;
				}
			}
		}
	}
}

package tree;

public class NextRightPointersII {
//	沿用116. Populating Next Right Pointers in Each Node 的方法
//	讨论了 特殊情况
	 
	public void connect(TreeLinkNode root) {
		if (root == null || (root.left == null && root.right == null))
			return;

		if (root.left != null && root.right != null)
			root.left.next = root.right;
		TreeLinkNode node = root.next;
		TreeLinkNode child = null;
		while (node != null) {//找node的next 直到找到一个有孩子的为止 左孩子优先
			child = node.left != null ? node.left : (node.right != null ? node.right : null);
			if (child == null)
				node = node.next;
			else
				break;
		}
		(root.right != null ? root.right : root.left).next = child;

		connect(root.right);
		connect(root.left);
	}
//	层序遍历的思想 tempChild用来hold住每一层的从左边数的第一个node
//	currentChild 用来在这一层遍历每一个node
//	
	 public void connect2(TreeLinkNode root) {
		 TreeLinkNode tempChild = new TreeLinkNode(0);
         TreeLinkNode currentChild = null;
         
	        while(root != null){//从上到下每一层
	        	currentChild = tempChild;
	            while(root!=null){//从左到右每一个node
	                if(root.left != null) { currentChild.next = root.left; currentChild = currentChild.next;}
	                if(root.right != null) { currentChild.next = root.right; currentChild = currentChild.next;}
	                root = root.next;
	            }
	            root = tempChild.next;
	            tempChild.next = null; //把tempChild又重置一下 即将用于下一层了
	        }
	    }
}

package tree;

public class NextRightPointersII {
//	����116. Populating Next Right Pointers in Each Node �ķ���
//	������ �������
	 
	public void connect(TreeLinkNode root) {
		if (root == null || (root.left == null && root.right == null))
			return;

		if (root.left != null && root.right != null)
			root.left.next = root.right;
		TreeLinkNode node = root.next;
		TreeLinkNode child = null;
		while (node != null) {//��node��next ֱ���ҵ�һ���к��ӵ�Ϊֹ ��������
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
//	���������˼�� tempChild����holdסÿһ��Ĵ�������ĵ�һ��node
//	currentChild ��������һ�����ÿһ��node
//	
	 public void connect2(TreeLinkNode root) {
		 TreeLinkNode tempChild = new TreeLinkNode(0);
         TreeLinkNode currentChild = null;
         
	        while(root != null){//���ϵ���ÿһ��
	        	currentChild = tempChild;
	            while(root!=null){//������ÿһ��node
	                if(root.left != null) { currentChild.next = root.left; currentChild = currentChild.next;}
	                if(root.right != null) { currentChild.next = root.right; currentChild = currentChild.next;}
	                root = root.next;
	            }
	            root = tempChild.next;
	            tempChild.next = null; //��tempChild������һ�� ����������һ����
	        }
	    }
}

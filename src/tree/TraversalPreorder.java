package tree;

import java.util.*;

public class TraversalPreorder {
    // ���ǵ�һ�� ���������뵽�ķ���
    // private  List<Integer> res=new LinkedList<>();
    // public List<Integer> preorderTraversal(TreeNode root) {
    //  preTraversal(root);
    //  return res;
    // }
    
    //   private void preTraversal(TreeNode root) {
    //     if (root==null)
    //     return ;
    //     res.add(root.val);
    //     preTraversal(root.left);
    //     preTraversal(root.right);
    // }
	
//	�ڶ���addAll
//     public List<Integer> preorderTraversal(TreeNode root) {
//          List<Integer> res=new LinkedList<>();
//         if  (root==null) return res;
//         res.add(root.val);
//         res.addAll(preorderTraversal(root.left));
//         res.addAll(preorderTraversal(root.right));
//         return res;
// }
//	������ ��stack
        public List<Integer> preorderTraversal(TreeNode root) {
          List<Integer> res=new ArrayList<>();
           if (root==null) return res;
            Deque<TreeNode> stack=new LinkedList<>();
           stack.push(root);
           TreeNode node=new TreeNode(0);
           while(!stack.isEmpty())
           {node=stack.pop();
           res.add(node.val);
           if (node.right!=null)
           stack.push(node.right);
          if (node.left!=null)
           stack.push(node.left);
           }
           return res;
    }
}

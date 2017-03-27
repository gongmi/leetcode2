package dynamicProgramming;

import java.util.*;

import tree.TreeNode;
//matrix[i][i - 1].add(null) ��仰�ǳ���Ҫ������������������Ϊһ��ʼ��û����仰
//��ômatrix[i][i - 1]�о���ʲô��û�е� ��null��û�� 
//��for (TreeNode left : matrix[j][i - 1]) i=jʱ
//���ѭ�������Ͳ������ ��� ��leftΪ null right Ϊ matrix[j + 1][j + k]��ѭ���Ͳ���ִ��
//����Ҿ���д��һ�����۱߽�� �����ʹ��븴���� ���������á�
public class UniqueBST_95 {
	public List<TreeNode> generateTrees(int n) {
		 if (n==0) return new ArrayList<TreeNode>();
		List<TreeNode>[][] matrix = new ArrayList[n + 2][n + 2];
		for (int i = 1; i <= n+1; i++) {
			matrix[i][i - 1] = new ArrayList<TreeNode>();
			matrix[i][i - 1].add(null);//��仰�ǳ���Ҫ���������������� 
			matrix[i][i] = new ArrayList<TreeNode>();
			matrix[i][i].add(new TreeNode(i));
		}

		for (int k = 1; k < n; k++) // k�Ǽ��
			for (int j = 1; j + k <= n; j++)// j�ǿ�ʼ
			{
				matrix[j][j + k] = new ArrayList<TreeNode>();
				for (int i = j; i <= j + k; i++)// i�Ǵ�j��j+k���� ���� ��i��Ϊroot
				{   
					for (TreeNode left : matrix[j][i - 1])
						for (TreeNode right : matrix[i + 1][j + k]) {
							TreeNode root = new TreeNode(j);
							root.left = left;
							root.right = right;
							matrix[j][j + k].add(root);
						}
				}
			}
		return matrix[1][n];
	}
//	public List<TreeNode> generateTrees(int n) {
//	    if (n==0) return new ArrayList<TreeNode>();
//		List<TreeNode>[][] matrix = new ArrayList[n + 1][n + 1];
//		for (int i = 1; i <= n; i++) {
//			matrix[i][i] = new ArrayList<TreeNode>();
//			matrix[i][i].add(new TreeNode(i));
//		}
//
//		for (int k = 1; k < n; k++)
//			// k�Ǽ��
//			for (int j = 1; j + k <= n; j++)// j�ǿ�ʼ
//			{
//				matrix[j][j + k] = new ArrayList<TreeNode>();
//				for (int i = j; i <= j + k; i++)// i�Ǵ�j��j+k���� ���� ��i��Ϊroot
//				{
//					if (i == j) {
//						for (TreeNode right : matrix[i + 1][j + k]) {
//							TreeNode root = new TreeNode(i);
//							root.right = right;
//							matrix[j][j + k].add(root);
//						}
//					} else if (i == j + k) {
//						for (TreeNode left : matrix[j][i - 1]) {
//							TreeNode root = new TreeNode(i);
//							root.left = left;
//							matrix[j][j + k].add(root);
//						}
//					} else {
//						for (TreeNode left : matrix[j][i - 1])
//							for (TreeNode right : matrix[i + 1][j + k]) {
//								TreeNode root = new TreeNode(i);
//								root.left = left;
//								root.right = right;
//								matrix[j][j + k].add(root);
//							}
//					}
//				}
//			}
//		return matrix[1][n];
//	}
}

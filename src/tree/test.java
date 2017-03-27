package tree;

import java.util.*;

public class test {
	public static void main(String[] args) {
		int n = 10;
		List<TreeNode>[][] matrix = new ArrayList[n][n];
		matrix[1][1] = new ArrayList<TreeNode>();
		for (TreeNode right : matrix[1][1]) {
			if (right == null)
				System.out.println("sef");
		}

	}
}

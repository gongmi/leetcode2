package tree;

import java.util.*;
//思路很简单 就是递归的求各个子树的sum 放进hashmap中 
//最后求出top freq的sum

//看了top 答案 top 答案在遞歸的時候就記錄一個freq的最大值
//之後只需要找map中 與這個最大值相等的key即可
public class MostFrequentSubtreeSum_508 {
	HashMap<Integer, Integer> freq = new HashMap<>();
	int maxCount = 0; //看了top之后改了代码

	public int[] findFrequentTreeSum(TreeNode root) {
		subSum(root);
		int max = Integer.MIN_VALUE;
		List<Integer> res = new LinkedList<>();
		for (Map.Entry<Integer, Integer> entry : freq.entrySet())
			if (entry.getValue() == maxCount)
				res.add(entry.getKey());

		int[] r = new int[res.size()];
		for (int i = 0; i < res.size(); i++)
			r[i] = res.get(i);

		return r;
	}

	public int subSum(TreeNode root) {
		if (root == null)
			return 0;
		int sum = root.val + subSum(root.left) + subSum(root.right);
		int count = freq.getOrDefault(sum, 0) + 1;
		freq.put(sum, count);
		maxCount = Math.max(count, maxCount);
		return sum;
	}
}

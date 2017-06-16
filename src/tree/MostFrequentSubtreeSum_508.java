package tree;

import java.util.*;
//˼·�ܼ� ���ǵݹ�������������sum �Ž�hashmap�� 
//������top freq��sum

//����top �� top �����f�w�ĕr���ӛ�һ��freq�����ֵ
//֮��ֻ��Ҫ��map�� �c�@�����ֵ��ȵ�key����
public class MostFrequentSubtreeSum_508 {
	HashMap<Integer, Integer> freq = new HashMap<>();
	int maxCount = 0; //����top֮����˴���

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

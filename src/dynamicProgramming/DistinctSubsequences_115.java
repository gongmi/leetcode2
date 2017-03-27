package dynamicProgramming;

import java.util.*;

public class DistinctSubsequences_115 {
	// �ҵĴ�ͦ�õ� top��Ȼ���˶�ά����
	public int numDistinct(String s, String t) {
		if (s.length() < t.length())
			return 0;
		int[] nums = new int[t.length()];
		for (int i = 0; i < s.length(); i++) {
			for (int j = t.length() - 1; j >= 0; j--) {
				// Ҫ�������� ��ֹ����rabbit������b ��һ������ Ӱ�쵽�ڶ���
				if (s.charAt(i) == t.charAt(j)) {
					if (j == 0)
						nums[j]++;
					else  
						nums[j]+= nums[j - 1];
				}
			}
		}
		return nums[t.length() - 1];
	}

//	�ڶ���� �ܺõ� ʱ��ܶ� ��Ϊ������ʱ��O��s+t��  ������ĵ�һ�����O��s*t��
//	����˵���ÿռ任ʱ��� ������ʵ�õ��Ŀռ�Ҳ����
//	������IsSubsequence_392���һ�ַ��� ��t�е�char�������������� 
//	�����ڱ���s��ʱ�� ������ѭ��t ���ж�s.charAt(i) �� t���ĸ�index ��Լ��ʱ��
	public int numDistinct2(String s, String t) {
		int s_len = s.length();
		int t_len = t.length();
		int[] count = new int[t_len];
		List<Integer>[] idx = new List[256]; // Just for clarity
		for (int i = t_len - 1; i >= 0; i--) {
			if (idx[t.charAt(i)] == null)
				idx[t.charAt(i)] = new ArrayList<Integer>();
			idx[t.charAt(i)].add(i);
		}

		for (int i = 0; i < s_len; i++) {
			List<Integer> list = idx[s.charAt(i)];
			if (list != null)
				for (int c : list) {
					if (c == 0)
						count[c]++;
					else
						count[c] += count[c - 1];
				}
		}
		return count[t_len - 1];
	}
}

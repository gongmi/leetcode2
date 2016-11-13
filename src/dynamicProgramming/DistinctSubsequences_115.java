package dynamicProgramming;

public class DistinctSubsequences_115 {
	//�ҵĴ�ͦ�õ� top��Ȼ���˶�ά����
	public int numDistinct(String s, String t) {
		if (s.length() < t.length())
			return 0;
		int[] nums = new int[t.length()];
		for (int i = 0; i < s.length(); i++) {
			for (int j = t.length()-1; j>=0;j--) {
				//Ҫ�������� ��ֹ����rabbit������b ��һ������ Ӱ�쵽�ڶ���
				if (s.charAt(i) == t.charAt(j)) {
					if (j == 0)
						nums[j]++;
					else if (nums[j - 1] != 0)
						nums[j] = nums[j] + nums[j - 1];
				}
			}
		}
		return nums[t.length() - 1];
	}
}

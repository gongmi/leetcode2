package dynamicProgramming;

public class DistinctSubsequences_115 {
	//我的答案挺好的 top居然用了二维数组
	public int numDistinct(String s, String t) {
		if (s.length() < t.length())
			return 0;
		int[] nums = new int[t.length()];
		for (int i = 0; i < s.length(); i++) {
			for (int j = t.length()-1; j>=0;j--) {
				//要反过来搜 防止出现rabbit中两个b 第一个改了 影响到第二个
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

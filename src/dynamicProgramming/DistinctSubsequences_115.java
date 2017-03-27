package dynamicProgramming;

import java.util.*;

public class DistinctSubsequences_115 {
	// 我的答案挺好的 top居然用了二维数组
	public int numDistinct(String s, String t) {
		if (s.length() < t.length())
			return 0;
		int[] nums = new int[t.length()];
		for (int i = 0; i < s.length(); i++) {
			for (int j = t.length() - 1; j >= 0; j--) {
				// 要反过来搜 防止出现rabbit中两个b 第一个改了 影响到第二个
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

//	第二版答案 很好的 时间很短 因为是线性时间O（s+t）  而上面的第一版答案是O（s*t）
//	可以说是用空间换时间吧 但是其实用到的空间也不多
//	就是用IsSubsequence_392最后一种方法 把t中的char存在链表数组里 
//	这样在遍历s的时候 不用再循环t 来判断s.charAt(i) 是 t的哪个index 节约了时间
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

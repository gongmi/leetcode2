package hashTable;
//用Arrays.copyOf  freq.putAll(frequency) 
//只有当<>中是基本数据类型才是深复制 如果是对象 是浅复制的
import java.util.LinkedList;
import java.util.List;

//https://discuss.leetcode.com/topic/68976/sliding-window-algorithm-template-to-solve-all-the-leetcode-substring-search-problem
//discuss中 把这种方法应用到了许多别的题目
//MinimumWindowSubstring_76
//LongestSubstrWithoutRepeatChars_3
// Time Complexity will be O(n)
// 我之前的方法都是O(n^2)
//这道题我的本子上写的很复杂 其实看代码 很简单的 不用去考虑别的那些char
//主要是要想清楚 当j加入时 与i离开时的思路
public class FindAllAnagrams_438 {

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new LinkedList<>();
		int[] freq = new int[26];
		for (int i = 0; i < p.length(); i++)
			freq[p.charAt(i) - 'a']++;

		int left = 0, right = 0, count = p.length();

		while (right < s.length()) {
			if ((freq[s.charAt(right) - 'a']--) > 0)   
														
				count--;                              //如果未自减之前是>0 说明是freq中需要的char 只有这种情况count才-- 

			if (count == 0)
				res.add(left);
			right++;

			if ((right - left) != p.length())
				continue;

			if ((freq[s.charAt(left) - 'a']++) >= 0)  //如果未自增之前是>=0的 说明这个char是freqs中有用的char 
														// 如果是其他或者多的 那么未自增之前会是被j进来时置为负数
				count++;

			left++;
		}
		return res;
	}

}

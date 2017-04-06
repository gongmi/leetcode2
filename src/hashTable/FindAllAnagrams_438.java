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
public class FindAllAnagrams_438 {

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new LinkedList<>();
		int[] freq = new int[26];
		for (int i = 0; i < p.length(); i++)
			freq[p.charAt(i) - 'a']++;

		int left = 0, right = 0, count = p.length();

		while (right < s.length()) {
			if ((freq[s.charAt(right) - 'a']--) > 0)  //如果这里别的那些char进来了 或者多的p里的char进来了
				count--;                                //都会在freq里被置为负的

			if (count == 0)
				res.add(left);
			right++;

			if ((right - left) != p.length())
				continue;

			if ((freq[s.charAt(left) - 'a']++) >= 0)  //如果是负的 这里会被排除的 因此 其实只有freq数组里的char在起作用
				count++;

			left++;
		}
		return res;
	}

}

package hashTable;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome_409 {
//	用58的数组来存放每一个字母出现的次数 出现偶数次的可以 奇数次的只取偶数次 最后加一个1
//	10 ms 理论上是O(n)
	public int longestPalindrome(String s) {
		int[] freq = new int[58];
		int length = 0;
		boolean have_single = false;
		for (int i = 0; i < s.length(); i++)
			freq[s.charAt(i) - 'A']++;

		for (int f : freq) {
			if (f%2==1&&!have_single)
				have_single = true;
			f=f/2;
			length = length + f*2;
		
		}

		return length + (have_single ? 1 : 0);
	}
//	用set来存放所有的字母 出现两次就删除 这样求出所有出现奇数次的字母
//	最后减掉这些奇数次的字母 留一个就可以了
	public int longestPalindrome2(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) set.remove(c);
            else set.add(c);
        }

        int odd = set.size();
        return s.length() - (odd == 0 ? 0 : odd - 1);
    }
}

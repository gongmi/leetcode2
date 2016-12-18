package hashTable;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome_409 {
//	��58�����������ÿһ����ĸ���ֵĴ��� ����ż���εĿ��� �����ε�ֻȡż���� ����һ��1
//	10 ms ��������O(n)
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
//	��set��������е���ĸ �������ξ�ɾ�� ����������г��������ε���ĸ
//	��������Щ�����ε���ĸ ��һ���Ϳ�����
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

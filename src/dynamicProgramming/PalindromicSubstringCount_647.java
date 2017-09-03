package dynamicProgramming;

//与PalindromicSubstringLongest_5一样的思路
//只不过这个只需要算有多少个
public class PalindromicSubstringCount_647 {
	int count = 0;

	public int countSubstrings(String s) {

		for (int i = 0; i < s.length(); i++) {
			extend(s, i, i);
			extend(s, i, i + 1);
		}
		return count;
	}

	private void extend(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			count++;
			j--;
			k++;
		}
	}
}
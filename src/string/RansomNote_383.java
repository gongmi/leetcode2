package string;

public class RansomNote_383 {
	// ������� magazines�ǲֿ����˼
	public boolean canConstruct(String ransomNote, String magazine) {
		int[] freq = new int[26];
		char[] a = magazine.toCharArray();
		for (char c : a) {
			freq[c - 'a']++;
		}
		for (char c : ransomNote.toCharArray()) {
			if (--freq[c - 'a'] < 0)
				return false;
		}
		return true;
	}
}

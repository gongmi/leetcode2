package backTracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_131 {
	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		backtrack(res, new ArrayList<String>(), s, 0);
		return res;
	}

	private void backtrack(List<List<String>> res, List<String> tmpList, String s, int start) {
		if (start == s.length()) {
			res.add(new ArrayList<String>(tmpList));
			return;
		}
		for (int i = start; i < s.length(); i++) {
			if (isPalindrome(s, start, i)) {
				tmpList.add(s.substring(start, i + 1));
				backtrack(res, tmpList, s, i + 1);
				tmpList.remove(tmpList.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String s, int low, int high) {
		while (low < high)
			if (s.charAt(low++) != s.charAt(high--))
				return false;
		return true;
	}
}

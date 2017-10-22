package backTracking;

import java.util.*;

public class RestoreIPAddresses_93 {
	List<String> ret = new ArrayList<>();

	public List<String> restoreIpAddresses(String s) {
		backTracking(s, 0, 0, "");
		return ret;
	}

	private void backTracking(String s, int i, int count, String res) {
		if (count == 4) {
			if (i == s.length())
				ret.add(res.substring(0, res.length() - 1));
			else
				return;
		}
		for (int j = i + 1; j <= Math.min(i + 3, s.length()); j++) {
			int cur = Integer.parseInt(s.substring(i, j));
			if (j - i > 1 && s.charAt(i) == '0') // Avoid leading 0
				return;
			if (cur <= 255) {
				backTracking(s, j, count + 1, res + cur + ".");
			}
		}
	}
}

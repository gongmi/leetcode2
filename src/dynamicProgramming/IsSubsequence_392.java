package dynamicProgramming;

public class IsSubsequence_392 {
	//my answer 38ms
	public boolean isSubsequence(String s, String t) {
		if (s.length() == 0)
			return true;
		if (s.length() > t.length())
			return false;
		int i = 0;
		int j = 0;
		while (true) {
			if (t.charAt(i) == s.charAt(j))
				j++;
			i++;
			if (j == s.length())
				return true;
			if (i == t.length())
				return false;
		}

	}
// use indexOf 2ms
	public boolean isSubsequence2(String s, String t) {
		if (t.length() < s.length())
			return false;
		int prev = 0;
		for (int i = 0; i < s.length(); i++) {
			char tempChar = s.charAt(i);
			prev = t.indexOf(tempChar, prev);
			if (prev == -1)
				return false;
			prev++;
		}

		return true;
	}
}

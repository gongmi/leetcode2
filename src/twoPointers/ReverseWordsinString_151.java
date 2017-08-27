package twoPointers;

//step 1. reverse the whole string
//step 2. reverse each word
// step 3. clean up spaces
//
public class ReverseWordsinString_151 {

	public String reverseWords(String s) {
		if (s == null)
			return null;

		char[] a = s.toCharArray();
		int n = a.length;

		reverse(a, 0, n - 1);
		reverseWords(a, n);
		return cleanSpaces(a, n);
	}

	private void reverse(char[] a, int i, int j) {
		while (i < j) {
			char t = a[i];
			a[i++] = a[j];
			a[j--] = t;
		}
	}

	private void reverseWords(char[] a, int n) {
		int i = 0, j = 0;
		// 这里面的两个while很神奇啊
		while (i < n) {
			while (i < j || i < n && a[i] == ' ')
				i++; // skip spaces
			while (j < i || j < n && a[j] != ' ')
				j++; // skip non spaces
			reverse(a, i, j - 1); // reverse the word
		}
	}

	// trim leading, trailing and multiple spaces
	private String cleanSpaces(char[] a, int n) {
		int i = 0, j = 0;

		while (j < n) {
			while (j < n && a[j] == ' ')
				j++; // skip spaces
			while (j < n && a[j] != ' ')
				a[i++] = a[j++]; // keep non spaces
			while (j < n && a[j] == ' ')
				j++; // skip spaces
			if (j < n)
				a[i++] = ' '; // keep only one space
		}

		return new String(a).substring(0, i);
	}

}

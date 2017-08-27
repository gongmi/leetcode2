package twoPointers;

public class ReverseVowelsString {
	public String reverseVowels(String s) {
		char[] a = s.toCharArray();
		int i = 0, j = a.length - 1;
		while (i < j) {
			while (i < j && !isVowels(a[i])) {
				i++;
			}
			while (i < j && !isVowels(a[j])) {
				j--;
			}
			char temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;

		}
		return new String(a);
	}

	public boolean isVowels(char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E'
				|| c == 'I' || c == 'O' || c == 'U')
			return true;
		else
			return false;
	}
}

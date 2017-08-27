package twoPointers;

public class ReverseString_344 {

	public String reverseString(String s) {
		char[] a = s.toCharArray();
		int i = 0, j = a.length - 1;
		while (i < j) {
			char temp = a[i];
			a[i++] = a[j];
			a[j--] = temp;

		}
		return new String(a);
	}

	public String reverseString2(String s) {
		char[] a = s.toCharArray();
		int i = 0, j = a.length - 1;
		while (i < j) {
			a[i] = (char) (a[i] ^ a[j]);
			a[j] = (char) (a[i] ^ a[j]);
			a[i] = (char) (a[i] ^ a[j]);
			i++;
			j--;

		}
		return new String(a);
	}

}

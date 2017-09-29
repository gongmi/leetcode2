package twoPointers;

public class ReverseStringII_541 {
	public String reverseStr(String s, int k) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i * k < s.length()) {
			String sub = "";
			if ((i + 1) * k < s.length())
				sub = s.substring(i * k, (i + 1) * k);
			else
				sub = s.substring(i * k, s.length());

			if ((i & 1) == 0)
				sb.append(new StringBuilder(sub).reverse());
			else
				sb.append(sub);

			i++;
		}
		return sb.toString();
	}

	// top´ð°¸
	public String reverseStr2(String s, int k) {
		char[] arr = s.toCharArray();
		int n = arr.length;
		int i = 0;
		while (i < n) {
			int j = Math.min(i + k - 1, n - 1);
			swap(arr, i, j);
			i += 2 * k;
		}
		return String.valueOf(arr);
	}

	private void swap(char[] arr, int l, int r) {
		while (l < r) {
			char temp = arr[l];
			arr[l++] = arr[r];
			arr[r--] = temp;
		}
	}
}

package hashTable;
//��ָoffer35  ��Ȼû��tag �����Ҿ��þ���hashtable
public class FirstUniqueCharInString_387 {
	public int firstUniqChar(String s) {
		char[] a = s.toCharArray();
		int[] count = new int[256];
		for (char c : a) {
			count[c]++;
		}
		for (int i = 0; i < a.length; i++) {
			if (count[a[i]] == 1) {
				return i;
			}
		}
		return -1;
	}
}

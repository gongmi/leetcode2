package bitManipulation;

public class FindDifference_389 {
	
	//�õ���������ֻ����һ�ε����ֵķ���   136. Single Number 
//	10 ms
//	public char findTheDifference(String s, String t) {
//		int c = 0;
//		
//		for (int i = 0; i < s.length(); i++)
//			c = s.charAt(i) ^ c;
//		for (int i = 0; i < t.length(); i++)
//			c = t.charAt(i) ^ c;
//
//		return (char) c;
//	}
	
	
//	�Ż��� 6ms
	public char findTheDifference(String s, String t) {
		int n = t.length();
		char c = t.charAt(n - 1);
		for (int i = 0; i < n - 1; ++i) {
			c ^= s.charAt(i);
			c ^= t.charAt(i);
		}
		return c;
	}
}

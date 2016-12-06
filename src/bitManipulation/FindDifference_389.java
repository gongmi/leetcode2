package bitManipulation;

public class FindDifference_389 {
	
	//用的是数组中只出现一次的数字的方法   136. Single Number 
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
	
	
//	优化后 6ms
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

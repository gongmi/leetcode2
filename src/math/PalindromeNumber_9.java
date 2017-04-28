package math;
//ÕâÊÇtop answer
//Do this without extra space   means no more than O(1) space
// use the idea ReverseInteger_7
// don't have to care about overflow 
// because if x is overflow ,it means it is not Palindrome
public class PalindromeNumber_9 {
	public boolean isPalindrome(int x) {
		int y = 0;
		int num = x;
		while (num > 0) {
			y = y * 10 + num % 10;
			num = num / 10;
		}
		return x == y;
	}
}

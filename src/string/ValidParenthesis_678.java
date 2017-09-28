package string;

//利用RemoveInvalidParentheses_301 中 判断是否valid 的方法 
//通过计算多少左括号 多少右括号来判断
//此处我只需要先顺序 再逆序即可
//top答案中没有与我相似的 但是我这个方法真的很好
public class ValidParenthesis_678 {
	public boolean checkValidString(String s) {
		int left = 0;
		int right = 0;
		char[] array = s.toCharArray();
		for (char c : array) {
			if (c == ')') {
				if (left == right)
					return false;
				right++;
			} else {
				left++;
			}
		}
		left = 0;
		right = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = array[i];
			if (c == '(') {
				if (right == left)
					return false;
				left++;
			} else
				right++;
		}
		return true;
	}
}

package string;

//����RemoveInvalidParentheses_301 �� �ж��Ƿ�valid �ķ��� 
//ͨ��������������� �������������ж�
//�˴���ֻ��Ҫ��˳�� �����򼴿�
//top����û���������Ƶ� ���������������ĺܺ�
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

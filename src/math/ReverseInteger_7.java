package math;

//��Ҫ����Ҫ���Ǽ��˵�case
public class ReverseInteger_7 {
	// �ҵĴ�
	public int reverse(int x) {
		long res = 0;
		int num = Math.abs(x);
		while (num > 0) {
			res = res * 10;
			res += num % 10;
			num = num / 10;
		}
		if (x > 0 && res > Integer.MAX_VALUE)
			return 0;
		if (x < 0 && -res < Integer.MIN_VALUE)
			return 0;
		return x > 0 ? (int) res : (int) (-res);
	}

	// top answer ��ֹ����ķ�ʽ������
	public int reverse2(int x) {
		int result = 0;

		while (x != 0) {
			int tail = x % 10;
			int newResult = result * 10 + tail;
			if ((newResult - tail) / 10 != result) {  
				return 0;
			}
			result = newResult;
			x = x / 10;
		}

		return result;
	}
}

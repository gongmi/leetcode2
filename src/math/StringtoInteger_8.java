package math;

public class StringtoInteger_8 {
// 第二版答案 根据top答案 模仿后
// 注意防止溢出的方式是除以10	
//	parseInt的源码是用负数来乘的 因为负数-2147483648 比最大正数能多表示一位
	public int myAtoi2(String str) {
		str = str.trim();
		str.indexOf(str);
		int sign = 1;
		int i = 0;
		int res = 0;
		if (i < str.length() && (str.charAt(i) == '-' || str.charAt(0) == '+')) {
			sign = str.charAt(i) == '-' ? -1 : 1;
			i++;
		}
		int bound = Integer.MAX_VALUE / 10;
		for (; i < str.length() && '0' <= str.charAt(i) && str.charAt(i) <= '9'; i++) {
			int digit = str.charAt(i) - '0';
			if (res > bound || (res == bound && digit > 7))
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			res = res * 10 + digit;
		}

		return sign * res;

	}

	public int myAtoi(String str) {
		str = str.trim();
		if (str.length() == 0)
			return 0;
		boolean num = false;
		boolean negative = false;
		int i = 0;
		long res = 0;
		if (str.charAt(0) < '0') {
			if (str.charAt(0) == '-') {
				negative = true;
				i++;
			} else if (str.charAt(0) == '+')
				i++;
			else
				return 0;
		}
		for (; i < str.length(); i++) {
			char c = str.charAt(i);
			if ('0' <= c && c <= '9') {
				if (i == 0 || i == 1)
					num = true;
				res = res * 10 + c - '0';
				if (negative && res > (long) Integer.MAX_VALUE + 1)
					return Integer.MIN_VALUE;
				if (!negative && res > Integer.MAX_VALUE)
					return Integer.MAX_VALUE;
			} else
				break;
		}
		if (!num)
			return 0;

		return negative ? (int) (-res) : (int) res;

	}
}

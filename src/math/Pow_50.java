package math;

//attention �������ǽ�ָoffer
//����nowcoder��OJ����������Ĳ��������Ƚ���
//leetcode���е�n=Integer.MIN_VALUE �������¼ӵ�case
//������ע��-n=Integer.MIN_VALUE overflow
//����Ҫ��long
//������õ�iteration
public class Pow_50 {
	public double myPow(double x, int n) {
		if (Math.abs(x - 1) < 0.00000001)
			return x;
		long exp = 0;
		if (n > 0)
			exp = n;
		else if (n < 0)
			exp = -(long) n;
		else
			return 1;
		double res = 1;
		while (exp != 0) {
			if ((exp & 1) == 1)
				res *= x;
			x *= x;
			exp = exp >> 1;
		}
		return n > 0 ? res : 1.0 / res;
	}

	// ����recursive
	public double myPow2(double x, int n) {
		if (n == 0)
			return 1.;
		double res = myPow(x, n / 2); //�ȳ���2 ����Ϊ�˷�ֹInteger.MIN_VALUE
		return n % 2 == 0 ? res * res : n < 0 ? res * res * (1 / x) : res * res * x;
	}
}

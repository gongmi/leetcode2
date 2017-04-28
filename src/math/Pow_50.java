package math;

//attention 这道题就是剑指offer
//但是nowcoder的OJ对特殊情况的测试用例比较少
//leetcode上有当n=Integer.MIN_VALUE 好像是新加的case
//这里请注意-n=Integer.MIN_VALUE overflow
//所以要用long
//这边是用的iteration
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

	// 这是recursive
	public double myPow2(double x, int n) {
		if (n == 0)
			return 1.;
		double res = myPow(x, n / 2); //先除以2 就是为了防止Integer.MIN_VALUE
		return n % 2 == 0 ? res * res : n < 0 ? res * res * (1 / x) : res * res * x;
	}
}

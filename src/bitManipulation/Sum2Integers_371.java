package bitManipulation;

public class Sum2Integers_371 {
	public int getSum(int a, int b) {
		int sum;
		int carry;
		while (true) {
			sum = a ^ b;
			carry = (a & b) << 1;
			if (carry != 0) {
				a = sum;
				b = carry;
			} else
				return sum;
		}
	}
	//别人的
	// Iterative迭代 求和 和我的一样
	public int getSum1(int a, int b) {
		if (a == 0) return b;
		if (b == 0) return a;

		while (b != 0) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		
		return a;
	}

	// Iterative迭代 求差
	public int getSubtract1(int a, int b) {
		while (b != 0) {
			int borrow = (~a) & b;
			a = a ^ b;
			b = borrow << 1;
		}
		
		return a;
	}

	// Recursive 递归求和
	public int getSum2(int a, int b) {
		return (b == 0) ? a : getSum2(a ^ b, (a & b) << 1);
	}

	// Recursive 递归 求差
	public int getSubtract2(int a, int b) {
		return (b == 0) ? a : getSubtract2(a ^ b, (~a & b) << 1);
	}

	// Get negative number
	public int negate(int x) {
		return ~x + 1;
	}
}

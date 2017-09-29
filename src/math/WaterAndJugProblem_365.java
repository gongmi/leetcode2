package math;

public class WaterAndJugProblem_365 {
	public boolean canMeasureWater(int x, int y, int z) {
		// limit brought by the statement that water is in one or both buckets
		if (x + y < z)
			return false;
		// case x or y is zero
		if (x == z || y == z || x + y == z)
			return true;

		// get GCD, then we can use the property of Bézout's identity
		return z % GCD(x, y) == 0;
	}

	// greatest common divisor最大公约数的求法！！！
	public int GCD(int a, int b) {
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
}

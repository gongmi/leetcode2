package binarySearch;

public class Sqrt_69 {
	// �ҵĵ�һ��� ��Ϊ���ʣ������ʱ �����ж� �����Ҿ��������ж���
	public int mySqrt(int x) {
		if (x <= 0)
			return x;
		long i = 1;
		long j = x;
		long mid = (i + j) / 2;
		while (i + 1 < j) {
			mid = (i + j) / 2;
			if (mid * mid > x)
				j = mid - 1;
			else if (mid * mid < x)
				i = mid;
			else
				return (int) mid;
		}

		if (j * j < x)
			return (int) j;
		return (int) i;

	}

	// top ��
	// ��mid == x / mid ������ mid * mid == x
	// ����isPerfectSquare������ ��Ϊ����Ҫ׼ȷ�� mid*mid=x
	// ����� ����Ҫ׼ȷ��doubleֵ
	// ֻ��Ҫint ���� x=17
	// mid=4ʱ
	// mid=x/mid �� 4=17/4
	public int mySqrt2(int x) {
		int left = 1, right = x;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (mid == x / mid) {
				return mid;
			} else if (mid < x / mid) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return right;
	}
}

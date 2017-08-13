package binarySearch;

public class ValidPerfectSquare_367 {
	// ����tag��binarySearch ������ ���ǳ�ʱ�� ��ʵ����Ϊ��numΪ�ܴ�ʱ mid*mid�����
	// �����ͻ��������޵�ѭ���� �Ӷ���ʱ ��ʵʱ�临�Ӷ��Ǻܵ�
	// ���Ӷ�Ϊ O(log(n))
	public boolean isPerfectSquare(int num) {
		if (num == 1 || num == 0)
			return true;
		long left = 1;
		long right = num;

		while (left <= right) {// ע����߿��Ե��ڣ������Ƕ��ַ��ı�׼д��
			long mid = (left + right) / 2;
			if (mid * mid > num)
				right = mid - 1;
			else if (mid * mid < num)
				left = mid + 1;
			else
				return true;
		}
		return false;
	}

	// ���Ӷ�ΪO(sqrt(n))
	public boolean isPerfectSquare2(int num) {
		int i = 1;
		while (num > 0) {
			num -= i;
			i += 2;
		}
		return num == 0;
	}
}

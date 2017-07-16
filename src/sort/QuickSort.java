package sort;

public class QuickSort {
	public static int partition(int[] a, int low, int high) {
		// ���õĲ��ǽ��� �Ҹĳ����滻 ���ݴ����ݽṹ p424�Ż�����Ҫ�Ľ���
		median3(a, low, high);//	�����������ȡ�� ʱ������
		int pivot = a[low];
		while (low < high) {
			while (low < high && a[high] >= pivot)
				high--;
			a[low] = a[high];

			while (low < high && a[low] <= pivot)
				low++;
			a[high] = a[low];
		}
		a[low] = pivot;
		return low;
	}
	// ���� ������һ�� ������Ϊ�����ݽṹ���� ����while������swap ���ǲ���ѧ�� �������������Ż� ������ʵ
	// ����̫�� ������Ӧ��д�������Ĵ��� Ӧ��ֻswapһ��
	// ���Ҳ�Ӧ�ð�pivot�Ž����ȽϲŶ� ������Ϊ�����ݽṹ�����ǲ��ϵؽ��������� ��pivot���������
	// low��
	// ����java���������� һ��ʼpivot�����뽻�� ��� ��low��high�������߽���ʱ ��len-1����pivot
	// ��low����

	private static void median3(int[] a, int left, int right) {
		int center = (left + right) / 2;
		if (a[right] < a[left])
			swapReferences(a, left, right);
		if (a[right] < a[center])
			swapReferences(a, center, right);
		if (a[left] < a[center])
			swapReferences(a, center, left); // a[left]��������
	}

	public static void swapReferences(int[] a, int index1, int index2) {
		int tmp = a[index1];
		a[index1] = a[index2];
		a[index2] = tmp;
	}
}

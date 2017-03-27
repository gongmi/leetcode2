package sort;

public class QuickSort {
	public static int partition(int[] a, int low, int high) {
//���õĲ��ǽ��� �Ҹĳ����滻  ���ݴ����ݽṹ p424�Ż�����Ҫ�Ľ���
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
//		 ���� ������һ�� ������Ϊ�����ݽṹ���� ����while������swap ���ǲ���ѧ��  �������������Ż� ������ʵ
//		����̫�� ������Ӧ��д�������Ĵ��� Ӧ��ֻswapһ��
//		���Ҳ�Ӧ�ð�pivot�Ž����ȽϲŶ�  ������Ϊ�����ݽṹ�����ǲ��ϵؽ��������� ��pivot���������
//	low��
//	����java���������� һ��ʼpivot�����뽻�� ��� ��low��high�������߽���ʱ ��len-1����pivot
//	��low����
}

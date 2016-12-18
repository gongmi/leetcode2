package sort;

public class QuickSort {
	public static int partition(int[] a, int low, int high) {
//���õĲ��ǽ��� �Ҹĳ����滻 
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
}

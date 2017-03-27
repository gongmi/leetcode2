package sort;

public class QuickSort {
	public static int partition(int[] a, int low, int high) {
//我用的不是交换 我改成了替换  根据大话数据结构 p424优化不必要的交换
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
//		 交换 和上面一样 那是因为大话数据结构里面 两个while都跟了swap 这是不科学的  所以他进行了优化 但是其实
//		是他太笨 根本不应该写出这样的代码 应该只swap一次
//		并且不应该把pivot放进来比较才对  那是因为大话数据结构里面是不断地交换过程中 把pivot最后正好在
//	low处
//	但是java语言描述是 一开始pivot不参与交换 最后 当low与high相遇或者交错时 把len-1处的pivot
//	与low交换
}

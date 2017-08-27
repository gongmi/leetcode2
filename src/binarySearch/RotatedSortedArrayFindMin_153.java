package binarySearch;

public class RotatedSortedArrayFindMin_153 {
	// ��������ų��˺ܶ�߽���� ���Ǳ��˵Ĵ���ȴ�ܼ�

	// ��right��left��ֵʱ ��һ������ mid-1�� mid+1�����ַ����ǵģ�
	// Ӧ����ôѡ�����Ǹ�����! Ϊʲô����ѡ��mid �� mid+1
	// ��ָoffer�ڰ��� �������ϵ�codeû�������
	public int findMin(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < nums[right]) {
				right = mid;  // ��Ϊ nums[mid]��������Сֵ ���Բ���mid-1
			} else {
				left = mid + 1; // ��Ϊ nums[mid]����������Сֵ ����
			}
		}
		return nums[left];
	}

	// 2017.08.21�ڶ����
	// ��ʵ����right��left�Ƿ��� mid-1�� mid+1��Ҫ���������
	// ����� �����ж�nums[left] <= nums[right] ������� ���� �Ѿ���˳�� ˵�����ڵ�һ��
	// Ȼ����˳��Ļ� ��Ҫ�� �м�
	// ������<=�м� ˵���м䲻��������Сֵ ��Ϊ��߿϶��������п�������Сֵ ����mid+1
	// ����������>�м� ˵���м��п�������Сֵ ����mid
	public int findMin2(int[] nums) {
		int left = 0, right = nums.length - 1;
		int mid = 0;
		while (left <= right) {
			if (nums[left] <= nums[right]) {
				return nums[left];
			}
			mid = left + (right - left) / 2;
			if (nums[left] <= nums[mid]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return 0;
	}
}

package twoPointers;

//������mergeSort�е�merge�������� ֻ��������ǰ��µ�array ����nums1��
//���������ʣ����nums1
//�Ͳ����ٷ���
//�뽣ָoffer�ĵ����� �滻�ո����� ������ԭ���Ļ����Ϸ�replaceSpace_4
//���Ҫ�Ӻ���ǰ
public class MergeSortedArray_88 {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int pos = m + n - 1;
		m--;
		n--;
		while (m >= 0 && n >= 0) {
			if (nums2[n] > nums1[m])
				nums1[pos--] = nums2[n--];
			else
				nums1[pos--] = nums1[m--];
		}

		while (n >= 0)
			nums1[pos--] = nums2[n--];
	}

}

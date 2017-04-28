package twoPointers;

//就是与mergeSort中的merge方法相似 只不过这边是把新的array 放在nums1中
//因此如果最后剩下了nums1
//就不用再放了
//与剑指offer的第四题 替换空格相似 都是在原来的基础上放replaceSpace_4
//因此要从后往前
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

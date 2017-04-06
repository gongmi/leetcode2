package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class IntersectionTwoArrays_349 {
	// 法1 sort后 2 pointers Time complexity: O(nlogn)
	// 与350类似 把list换成set就可以了

	// 法2 Use two hash sets
	// Time complexity: O(n)

	public class Solution {
		public int[] intersection(int[] nums1, int[] nums2) {
			Set<Integer> set = new HashSet<>();
			Set<Integer> intersect = new HashSet<>();
			for (int i = 0; i < nums1.length; i++) {
				set.add(nums1[i]);
			}
			for (int i = 0; i < nums2.length; i++) {
				if (set.contains(nums2[i])) {// hash的查找只需要O(1) time
					intersect.add(nums2[i]);
				}
			}
			int[] result = new int[intersect.size()];
			int i = 0;
			for (Integer num : intersect) {
				result[i++] = num;
			}
			return result;
		}

		// 法3 Binary search
		// 二分法主要适用于两个数组长度相差很大的情况 比如说nums1很短
//		把nums1中的数拿出来 在排好了序的 nums2中找 这样就不用遍历 nums2了 
//		但是nums2排序也是要时间啊  所以适用于已经排好序的
		// Time complexity: O(nlogn)
		public int[] intersection2(int[] nums1, int[] nums2) {
			Set<Integer> set = new HashSet<>();
			Arrays.sort(nums2);
			for (Integer num : nums1) {
				if (Arrays.binarySearch(nums2, num) > 0) {
					set.add(num);
				}
			}
			int i = 0;
			int[] result = new int[set.size()];
			for (Integer num : set) {
				result[i++] = num;
			}
			return result;
		}
	}

}

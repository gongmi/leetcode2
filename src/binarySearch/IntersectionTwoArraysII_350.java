package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
//!!attention 不能直接list.toArray的 因为是int 引用类型应该可以
//int[]不能转换为 Object[]
//但是其他的引用类型的 是可以的 比如说QueueReconstruction
//为什么可以  因为是二维数组 二维数组是一维数组组成的数组
//因为一维数组 其实也是一个引用




//What if nums1's size is small compared to nums2's size? Which algorithm is better?
//What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

public class IntersectionTwoArraysII_350 {
	//What if the given array is already sorted? How would you optimize your algorithm?
	// 法1 sort后 2 pointers Time complexity: O(nlogn)
	public int[] intersect(int[] nums1, int[] nums2) {

		if (nums1.length == 0 || nums2.length == 0)
			return new int[] {};

		Arrays.sort(nums1);
		Arrays.sort(nums2);
		// 如果是349题把list换成set就可以
		List<Integer> list = new LinkedList<Integer>();
		int i = 0, j = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j])
				i++;
			else if (nums1[i] > nums2[j])
				j++;
			else {
				list.add(nums1[i]);
				i++;
				j++;
			}
		}
		int[] res = new int[list.size()];
		i = 0;
		for (int n : list) {
			res[i] = n;
			i++;
		}
		return res;
	}

	// 法2 Use hashmap
	// Time complexity: O(n)

	public int[] intersect2(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int num : nums1)
			map.put(num, map.getOrDefault(num, 0) + 1);

		for (int num : nums2) {
			if (map.getOrDefault(num, 0) > 0) {
				result.add(num);
				map.put(num, map.get(num) - 1);
			}
		}
		int[] r = new int[result.size()];
		for (int i = 0; i < result.size(); i++)
			r[i] = result.get(i);

		return r;
	}

}

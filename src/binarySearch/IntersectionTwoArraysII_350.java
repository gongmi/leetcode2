package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
//!!attention ����ֱ��list.toArray�� ��Ϊ��int ��������Ӧ�ÿ���
//int[]����ת��Ϊ Object[]
//�����������������͵� �ǿ��Ե� ����˵QueueReconstruction
//Ϊʲô����  ��Ϊ�Ƕ�ά���� ��ά������һά������ɵ�����
//��Ϊһά���� ��ʵҲ��һ������




//What if nums1's size is small compared to nums2's size? Which algorithm is better?
//What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

public class IntersectionTwoArraysII_350 {
	//What if the given array is already sorted? How would you optimize your algorithm?
	// ��1 sort�� 2 pointers Time complexity: O(nlogn)
	public int[] intersect(int[] nums1, int[] nums2) {

		if (nums1.length == 0 || nums2.length == 0)
			return new int[] {};

		Arrays.sort(nums1);
		Arrays.sort(nums2);
		// �����349���list����set�Ϳ���
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

	// ��2 Use hashmap
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

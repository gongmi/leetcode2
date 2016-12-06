package bitManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementII_229 {
	// hash table 时间不好 虽然理论上是o（n）
	// public List<Integer> majorityElement(int[] nums) {
	// Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
	// List<Integer> myList = new ArrayList<Integer>();
	//
	// for (int num : nums) {
	// if (!myMap.containsKey(num))
	// myMap.put(num, 1);
	// else
	// myMap.put(num, myMap.get(num) + 1);
	// if (myMap.get(num) > nums.length / 3) {
	// if (!myList.contains(num))
	// myList.add(num);
	// if (myList.size() == 2)
	// break;
	// }
	// }
	// return myList;
	// }
	
	
	
	
	
	
	
//	1. there are no elements that appears more than n/3 times, 
//	then whatever the algorithm  got from 1st round 
//	wound be rejected in the second round.
//	2. there are only one elements that appears more than n/3 times, 
//	after 1st round one of the candidate must be that appears more than n/3 times
//	(<2n/3 other elements could only pair out for <n/3 times),
//	the other candidate is not necessarily be the second most frequent 
//	 but it would be rejected in 2nd round.
//	3. there are two elements appears more than n/3 times, 
//	Candidates would contain both of them.
//	(<n/3 other elements couldn't pair out any of the majorities.)
	// Moore voting algorithm 线性时间 o（2n）     空间 o（4）=o（1）
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> myList = new ArrayList<Integer>();
		int count1 = 0, count2 = 0;
		int m1 = 0, m2 = 1;//其实这两个值会影响 但是不怕 因为最后还会算一遍究竟大不大于三分之一
		for (int num : nums) {
			if (m1 == num)
				count1++;
			else if (m2 == num)
				count2++;
			else if (count1 == 0) {
				m1 = num;
				count1++;
			} else if (count2 == 0) {
				m2 = num;
				count2++;
			} else {
				count1--;
				count2--;
			}
		}

		count1 = 0;
		count2 = 0;
		for (int num : nums) {
			if (num == m1)
				count1++;
			if (num == m2)
				count2++;
		}
		if (count1 > nums.length / 3)
			myList.add(m1);
		if (count2 > nums.length / 3)
			myList.add(m2);
		return myList;
	}
}

package bitManipulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement_169 {
	
//与SingleNumberII_137 类似的解法 就是分析每一个bit在总的数里的情况
//	这边是析每一个bit为1 的数大于总数的一半
	public int majorityElement(int[] nums) {
		int result = 0;
		int bit1, sum;
		for (int j = 0; j < 32; j++) {
			sum = 0;
			bit1 = (1 << j); // set bit j as 1 others is 0
			for (int i = 0; i < nums.length; i++) {
				if ((nums[i] & bit1) != 0)
					sum++;// 把所有的数的第j位为1的加起来
			}
			if (sum > nums.length / 2)
				result = result | bit1; // 则把这一位置为1
		}
		return result;
	}
	
	// Sorting
	public int majorityElement1(int[] nums) {
	    Arrays.sort(nums);
	    return nums[nums.length/2];
	}

	// Hashtable 
	public int majorityElement2(int[] nums) {
	    Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
	    //Hashtable<Integer, Integer> myMap = new Hashtable<Integer, Integer>();
	    int ret=0;
	    for (int num: nums) {
	        if (!myMap.containsKey(num))
	            myMap.put(num, 1);
	        else
	            myMap.put(num, myMap.get(num)+1);
	        if (myMap.get(num)>nums.length/2) {
	            ret = num;
	            break;
	        }
	    }
	    return ret;
	}

	// Moore voting algorithm  这个方法很巧妙啊
//	http://www.cs.utexas.edu/~moore/best-ideas/mjrty/
	public int majorityElement3(int[] nums) {
	    int count=0, ret = 0;
	    for (int num: nums) {
	        if (count==0)
	            ret = num;
	        if (num!=ret)
	            count--;
	        else
	            count++;
	    }
	    return ret;
	}
}

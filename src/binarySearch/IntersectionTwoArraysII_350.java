package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class IntersectionTwoArraysII_350 {
	//法1 sort后  2 pointers  Time complexity: O(nlogn)
    public int[] intersect(int[] nums1, int[] nums2) {
    	
	    if (nums1.length==0||nums2.length==0)
	    return new int[]{};
	    
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		//如果是349题把list换成set就可以
		List<Integer> list = new LinkedList<Integer>();
		int i = 0, j = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j])
				i++;
			else if (nums1[i] > nums2[j])
				j++;
			else
			{	list.add(nums1[i]);i++;j++;}
		}
		int[] res = new int[list.size()];//不能直接list.toArray的 因为是int 引用类型应该可以
		i = 0;
		for (int n : list) {
			res[i] = n;
			i++;
		}
		return res;
	}
    
    
//   法2 Use  hashmap
//    Time complexity: O(n)

    	   public int[] intersect2(int[] nums1, int[] nums2) {
    	        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	        ArrayList<Integer> result = new ArrayList<Integer>();
    	        for(int i = 0; i < nums1.length; i++)
    	        {
    	            if(map.containsKey(nums1[i])) map.put(nums1[i], map.get(nums1[i])+1);
    	            else map.put(nums1[i], 1);
    	        }
    	    
    	        for(int i = 0; i < nums2.length; i++)
    	        {
    	            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0)
    	            {
    	                result.add(nums2[i]);
    	                map.put(nums2[i], map.get(nums2[i])-1);
    	            }
    	        }
    	    
    	       int[] r = new int[result.size()];
    	       for(int i = 0; i < result.size(); i++)
    	       {
    	           r[i] = result.get(i);
    	       }
    	    
    	       return r;
    	    }

}

package twoPointers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum_18 {
	// ThreeSum_15 的方法 遍历1和2  3与4 用2 pointers
	 public List<List<Integer>> fourSum(int[] nums, int target) {
	        Arrays.sort(nums);
	        List<List<Integer>> res=new LinkedList<List<Integer>>();
	        int start,end;
	        
	        for(int i=0;i<nums.length;i++)
	        { if(i!=0&&nums[i]==nums[i-1]) continue;
	          for(int j=i+1;j<nums.length;j++)
	         {if(j!=i+1&&nums[j]==nums[j-1]) continue;
	         
	            start=j+1;
	            end=nums.length-1;
	           
	             while(start<end)
	          {   
	             
	              if (nums[start]+nums[end]+nums[i]+nums[j]<target)
	              {  while (start < end && nums[start] == nums[start+1]) start++;
	                  start++;}
	              else if (nums[start]+nums[end]+nums[i]+nums[j]>target)
	              {  while (start < end && nums[end] == nums[end-1]) end--;
	                  end--;}
	              else 
	              {
	                   res.add(Arrays.asList(nums[i],nums[j], nums[start], nums[end]));
	                    while (start < end && nums[start] == nums[start+1]) start++;
	                    while (start < end && nums[end] == nums[end-1]) end--;
	                   start++;end--;
	              }
	          }
	          
	         }
	        }
	         return res;
	    }
}

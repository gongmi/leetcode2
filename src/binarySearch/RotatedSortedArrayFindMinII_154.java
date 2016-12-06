package binarySearch;

public class RotatedSortedArrayFindMinII_154 {
//	可以有重复  我讨论了许多情况
	public int findMin(int[] nums) {
		int left = 0,temp;
		int right = nums.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < nums[right])
				right = mid;
			else if (nums[mid] > nums[right])
				left = mid + 1;
			else   //mid==right时
				 right--;//别人的方法 简单粗暴 多么好
//			{
//			    if(nums[left]<nums[right]) 
//			    return nums[left];
//			    if(nums[left]>nums[right]) 
//			    right = mid;
//			    else{       //mid==right 并且 mid==left时 就很复杂了
//			        temp=mid;
//			       while(temp<right&&nums[temp]==nums[temp+1]) //一直往右找 直到不相同
//			       temp++;
//			       
//			       if (temp==right) right = mid; //如果一直相同 说明在左边
//			       else if(nums[temp]<nums[temp+1]) left = temp+1; //如果找到一个大的 说明在右边
//			       else return nums[temp+1]; //如果找到一个小的 说明就是这个小的
//				}
//			}
		}
		return nums[left];
	}
}

package binarySearch;

public class RotatedSortedArrayFindMinII_154 {
//	�������ظ�  ��������������
	public int findMin(int[] nums) {
		int left = 0,temp;
		int right = nums.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < nums[right])
				right = mid;
			else if (nums[mid] > nums[right])
				left = mid + 1;
			else   //mid==rightʱ
				 right--;//���˵ķ��� �򵥴ֱ� ��ô��
//			{
//			    if(nums[left]<nums[right]) 
//			    return nums[left];
//			    if(nums[left]>nums[right]) 
//			    right = mid;
//			    else{       //mid==right ���� mid==leftʱ �ͺܸ�����
//			        temp=mid;
//			       while(temp<right&&nums[temp]==nums[temp+1]) //һֱ������ ֱ������ͬ
//			       temp++;
//			       
//			       if (temp==right) right = mid; //���һֱ��ͬ ˵�������
//			       else if(nums[temp]<nums[temp+1]) left = temp+1; //����ҵ�һ����� ˵�����ұ�
//			       else return nums[temp+1]; //����ҵ�һ��С�� ˵���������С��
//				}
//			}
		}
		return nums[left];
	}
}

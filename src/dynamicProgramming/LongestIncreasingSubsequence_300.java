package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence_300 {
	//https://segmentfault.com/a/1190000003819886
	//���߿��ڶ�top��discuss��Ӣ��
	//���Բο�IncreasingTripletSubsequence_334 length=3����� ˼����һ����
	public int lengthOfLIS(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		// len��ʾ��ǰ����������г��ȣ�Ϊ�˷������tails���Ǽ�1��
		int len = 0;
		// tails[i]��ʾ����Ϊi������������ĩβ������
		int[] tails = new int[nums.length];
		tails[0] = nums[0];
		// ��������������²�ͬ�������еļ���
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] <= tails[0]) //���ʱ���滻�� �滻�����˶���ʱ�� ���ǿ��Խ�Լ��һ���жϵ�д��
				tails[0] = nums[i];
			// ������м䣬���������  Ҫע�� �����ʱ�Ͳ�Ҫ�������� ��Ϊ���ʱ����ʱ���������� 
			else if (nums[i] < tails[len]) 
				tails[binarySearch(tails, 0, len, nums[i])] = nums[i];
			else if (nums[i] > tails[len]) 
				tails[++len] = nums[i];
		}
		return len + 1;
	}
	//������ַ�������ҵ��� �ͷ��� ���û�ҵ� �ͷ������������������λ��
    private int binarySearch(int[] tails, int min, int max, int target){
        while(min <= max){
            int mid = min + (max - min) / 2;
            if(tails[mid] == target){
                return mid;
            }
            if(tails[mid] < target){
                min = mid + 1;
            }
            if(tails[mid] > target){
                max = mid - 1;
            }
        }
        return min;
    }
    //top 1 ���Ĵ��� һ����˼��  Arrays.binarySearch�ķ���ֵ����
//    * @return index of the search key, if it is contained in the array
//    *         within the specified range;
//    *         otherwise   -(insertion point) - 1

// ��   int[] a= new int[]{1,3,5,6,7};
//	Arrays.binarySearch(a, 4)=-3;
//	Arrays.binarySearch(a, 0)=-1;
//	Arrays.binarySearch(a, 8)=-6;
    public int lengthOfLIS2(int[] nums) {            
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);//���û�ҵ���ԭΪӦ�ô��ڵ�λ��
            dp[i] = x;
            if(i == len) len++; //����Ǽ���dp�������� ���ǲ�����һ�����ȼ�һ���µ�LIS����
        }

        return len;
    }
    
    // Follow-up: O(N) time for pre-processing, O(Mlog?) for each S.
    // Eg-1. s="abc", t="bahbgdca"
    // idx=[a={1,7}, b={0,3}, c={6}]
    //  i=0 ('a'): prev=1
    //  i=1 ('b'): prev=3
    //  i=2 ('c'): prev=6 (return true)
    // Eg-2. s="abc", t="bahgdcb"
    // idx=[a={1}, b={0,6}, c={5}]
    //  i=0 ('a'): prev=1
    //  i=1 ('b'): prev=6
    //  i=2 ('c'): prev=? (return false)
    public boolean isSubsequence(String s, String t) {
        List<Integer>[] idx = new List[256]; // Just for clarity
        for (int i = 0; i < t.length(); i++) {
            if (idx[t.charAt(i)] == null)
                idx[t.charAt(i)] = new ArrayList();
            idx[t.charAt(i)].add(i);
        }
        
        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            if (idx[s.charAt(i)] == null) return false; // Note: char of S does NOT exist in T causing NPE
            int j = Collections.binarySearch(idx[s.charAt(i)], prev);
            if (j < 0) j = -j - 1;
            if (j == idx[s.charAt(i)].size()) return false;
            prev = idx[s.charAt(i)].get(j) + 1;
        }
        return true;
    }
}

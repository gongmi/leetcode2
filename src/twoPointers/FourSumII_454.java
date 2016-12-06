package twoPointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FourSumII_454 {
	
//  注意与FourSum_18的区别 
//	FourSum_18只有一个数组 这是四个数组
	
	// 这就是hash 没有binarysearch啊
	public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
		int len = A.length;
		int res = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int a : A)
			for (int b : B) {
//				if (map.containsKey(a + b))
//					map.put(a + b, map.get(a + b) + 1);
//				else
//					map.put((a + b), 1);
				 map.put(a+b,map.getOrDefault((a+b),0)+1);
			}

		for (int c : C)
			for (int d : D) {
//				if (map.containsKey(-(c + d)))
//					res = res + map.get(-(c + d));
				res=res+map.getOrDefault(-(c+d),0);
			}
		return res;
	}
	// 我的方法循环abc d用二分法查找 超时
	// public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
	// Arrays.sort(D);
	// Map<Integer,Integer> map=new HashMap<Integer,Integer>();
	// int target;
	// int res=0;
	// int current=0;
	// int index,index2;
	// for(int a:A)
	// for(int b:B)
	// for(int c:C)
	// {target=-(a+b+c);
	// if (map.containsKey(target))
	// {res=res+map.get(target);
	// continue;}
	//
	// index=Arrays.binarySearch(D,target);
	// if(index>=0)
	// { current=1;
	// index2=index;
	// while (index>=1&&D[index]==D[index-1])
	// {current++;
	// index--;}
	// while (index2<D.length-1&&D[index2]==D[index2+1])
	// {current++;
	// index2++;}
	// map.put(target,current);
	// res=res+current;
	// }
	// }
	// return res;
	// }
}

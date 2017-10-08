package backTracking;

import java.util.*;
//第一版答案 超时了 我用的尝试的方法
//看了top  是数学题
public class BeautifulArrangementII_667 {
	boolean[] used;
	HashMap<Integer,Integer> map=new HashMap<>();
	public int[] constructArray(int n, int k) {
		used=new boolean[n+1];
		LinkedList<Integer> list=new LinkedList<Integer>();
		int[] res=new int[n];
		if(!backTracking(list,n,k)){
			return res;
		}
		int idex=0;
		for(int i:list){
			res[idex++]=i;
		}
		return res;
	}
	private boolean backTracking(LinkedList<Integer> list, int n, int k){
		if (list.size()==n){
			if(map.size()==k)
				return true;
			else{
				return false;
			}

		}
		for(int i=1;i<=n;i++){
			if (!used[i]){

				if (list.size()>0){
					int gap=Math.abs(list.getLast()-i);
					map.put(gap,map.getOrDefault(gap,0)+1);
				}
				used[i]=true;
				list.add(i);
				if(backTracking(list,n,k))
					return true;
				used[i]=false;
				list.removeLast();
				if (list.size()>0){
					int gap=Math.abs(list.getLast()-i);
					if (map.get(gap)==1)
						map.remove(gap);
					else
						map.put(gap,map.get(gap)-1);
				}
			}

		}
		return false;
	}
}

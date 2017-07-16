package heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class TopKFrequentElements_347 {
	
	// 法1 map + bucket sort
	// 时间复杂度是 O(n)
	public List<Integer> topKFrequent(int[] nums, int k) {
		int len = nums.length;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int n : nums)
			map.put(n, map.getOrDefault(n, 0) + 1);

		LinkedList<Integer>[] bucket = new LinkedList[len + 1];

		for (int num : map.keySet()) {
			int freq = map.get(num);
			if (bucket[freq] == null)
				bucket[freq] = new LinkedList<Integer>();
			bucket[freq].add(num);
		}
		LinkedList<Integer> res = new LinkedList<>();
		for (int i = len; res.size() < k; i--)
			if (bucket[i] != null)
				res.addAll(bucket[i]);

		return res.subList(0, k);
	}

	// 法2 把 HashMap<Number,frequency>中的Entry
	// 放在TreeMap<frequency，LinkedList<Number>>中 时间复杂度是O(n log n)
	public List<Integer> topKFrequent2(int[] nums, int k) {
		int len = nums.length;
		LinkedList<Integer> res = new LinkedList<>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int n : nums)
			map.put(n, map.getOrDefault(n, 0) + 1);

		TreeMap<Integer, LinkedList<Integer>> freq_map = new TreeMap<Integer, LinkedList<Integer>>();

		LinkedList<Integer> list = new LinkedList<>();
		for (int num : map.keySet()) {
			int freq = map.get(num);
			list = freq_map.getOrDefault(freq, new LinkedList<Integer>());
			list.add(num);
			freq_map.put(freq, list);
		}

		while (res.size() < k)
			res.addAll(freq_map.pollLastEntry().getValue());

		return res.subList(0, k);
	}

	// 法3 把 HashMap<Number,frequency>中的Entry放在PriorityQueue中 大顶堆
	// 理论上是O（n）+O(K log n) 可是其实很慢？
	public List<Integer> topKFrequent3(int[] nums, int k) {
		int len = nums.length;
		LinkedList<Integer> res = new LinkedList<>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      
		for (int n:nums)
		map.put(n,map.getOrDefault(n,0)+1);
		
		PriorityQueue<Map.Entry<Integer, Integer>> pq=new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));

		pq.addAll(map.entrySet());
		
	    while(res.size() < k)
			res.add(pq.poll().getKey());

//	    O(n log k) 
//		或者用小顶堆   大小为k 超过k 就把头部（小的） 删掉 
//	    PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue()-b.getValue());
//	    for(Map.Entry<Integer, Integer> entry : counterMap.entrySet()) {
//	        pq.offer(entry);
//	        if(pq.size() > k) pq.poll();
//	    }
//	    我感觉不应该用上面这种for  因为不应该啥都往里加 会浪费时间 应该先判断一下与顶的大小 
//        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
//            if (pq.size()<k){
//            	pq.offer(entry);
//            }else if (pq.size()==k&&entry.getValue()>pq.peek().getValue()){
//            	pq.offer(entry);
//            	pq.poll();
//          }  
//        }
//	    
//	    while(!pq.isEmpty()) {
//	        res.add(0, pq.poll().getKey());//这是加在头部 实现了顺序变倒序 其实不用 题目没有要求 list要按freq排序
//	    }
	    return res;
	    
	}

}

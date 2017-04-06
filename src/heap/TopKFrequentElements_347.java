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
	
	// ��1 bucket sort bucket Array
	//	�� HashMap<Number,frequency>
	// ��ʵ�������ͦɵ�� ΪʲôҪ��freq bucket����һ��������
	// Ӧ���ǿռ任ʱ�� �ռ��Ǻܶ��˷ѵ� ����ʱ�临�Ӷ��� O(n)
	public List<Integer> topKFrequent(int[] nums, int k) {
		int len = nums.length;
		LinkedList<Integer> res = new LinkedList();
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

		for (int i = len; res.size() < k; i--)
			if (bucket[i] != null)
				res.addAll(bucket[i]);

		return res.subList(0, k);
	}

	// ��2 �� HashMap<Number,frequency>�е�Entry
	// ����TreeMap<frequency��LinkedList<Number>>�� ʱ�临�Ӷ���O(n log n)
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

	// ��3 �� HashMap<Number,frequency>�е�Entry����PriorityQueue�� �󶥶�
	// ��������O��n��+O(K log n) ������ʵ������
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
//		������С����   ��СΪk ����k �Ͱ�ͷ����С�ģ� ɾ�� 
//	    PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue()-b.getValue());
//	    for(Map.Entry<Integer, Integer> entry : counterMap.entrySet()) {
//	        pq.offer(entry);
//	        if(pq.size() > k) pq.poll();
//	    }
//	    
//	    while(!pq.isEmpty()) {
//	        res.add(0, pq.poll().getKey());//���Ǽ���ͷ�� ʵ����˳��䵹��
//	    }
	    return res;
	    
	}

}

package heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class TopKFrequentWords_692 {
	public List<String> topKFrequent(String[] words, int k) {
		int len = words.length;
		LinkedList<String> res = new LinkedList<>();
		Map<String, Integer> map = new HashMap<String, Integer>();
      
		for (String s:words)
		map.put(s,map.getOrDefault(s,0)+1);
		
		PriorityQueue<Map.Entry<String, Integer>> pq=new PriorityQueue<>((a,b)->b.getValue()==a.getValue()?a.getKey().compareTo(b.getKey()):(b.getValue()-a.getValue()));

		pq.addAll(map.entrySet());
	    while(res.size() < k)
			res.add(pq.poll().getKey());   
        return res;
    }
}

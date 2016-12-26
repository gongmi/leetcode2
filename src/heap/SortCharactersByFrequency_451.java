package heap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency_451 {
	//   沿用的 TopKFrequentElements_347 的法3
	// 依然很慢
	public String frequencySort(String s) {
        Map<Character,Integer> frequency =new HashMap<>();
        for (char c:s.toCharArray())
        frequency.put(c,frequency.getOrDefault(c,0)+1);
        
        PriorityQueue<Map.Entry<Character,Integer>> pq =new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        pq.addAll(frequency.entrySet());
        
        int freq=0;
        char c;
        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty())
        { Map.Entry<Character,Integer> entry=pq.poll();
            freq=entry.getValue();
            c=entry.getKey();
            while(freq-->0) sb.append(c);
        }
        return sb.toString();
    }

	//   沿用的 TopKFrequentElements_347 的法1
//	bucket sort 
//	慢
	public String frequencySort2(String s) {
		Map<Character, Integer> frequency = new HashMap<>();
		for (char c : s.toCharArray())
			frequency.put(c, frequency.getOrDefault(c, 0) + 1);

		int len = s.length();
		LinkedList<Character>[] bucket = new LinkedList[len + 1];
		for (char c : frequency.keySet()) {
			int freq = frequency.get(c);
			if (bucket[freq] == null)
				bucket[freq] = new LinkedList<Character>();
			bucket[freq].add(c);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = len; i > 0; i--)
			if (bucket[i] != null)
				for (char c : bucket[i]) {
					int freq = i;
					while (freq-- > 0)
						sb.append(c);
				}

		return sb.toString();
	}
	
//	这个非常快
//	其实就是 上面的bucket sort 但是 他没有用 map来存放 char->frequency
//	并且他没有用linkedlist来存放 这个freq下面的所有char
//	而是用的string

	public String frequencySort3(String s) {
        if(s.length() < 3)
            return s;
        int max = 0;
        int[] map = new int[256];
        for(char ch : s.toCharArray()) {
            map[ch]++;
            max = Math.max(max,map[ch]);
        }
        String[] buckets = new String[max + 1];  
        for(int i = 0 ; i < 256; i++) {  
            String str = buckets[map[i]];
            if(map[i] > 0)
                buckets[map[i]] = (str == null) ? "" + (char)i : (str + (char) i);
        }
        StringBuilder strb = new StringBuilder();
        for(int i = max; i >= 0; i--) {  
            if(buckets[i] != null)
                for(char ch : buckets[i].toCharArray())
                    for(int j = 0; j < i; j++)
                        strb.append(ch);
        }
        return strb.toString();
    }
}

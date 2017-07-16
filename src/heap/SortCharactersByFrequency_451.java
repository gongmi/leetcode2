package heap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency_451 {
	//   ���õ� TopKFrequentElements_347 �ķ�3 ����hashmap+priorityqueue
	// ��Ȼ����
	//	ע��PriorityQueue�Ǽ̳���queue ��queue����һ��collection 
	//	��setҲ��һ��collection
	//	����
	//	collection֮�䶼������addAll������������
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

	//   ���õ� TopKFrequentElements_347 �ķ�1
	//	hashmap+bucket sort 
	//	��
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
	
//	����ǳ���
//	��ʵ���� �����bucket sort ���� ��û���� map����� char->frequency
//	�����õ�һ������ ��Ϊ��ŵ���char����һ����С��256��
//	����bucket�в�����linkedlist����� ���freq���������char
//	�����õ�string!!!��û�뵽 ��������������ͻ�ˣ�������
//�� freq�� 0 1 ... A B C ...  Z a b c d ...  z   255
//       4 1  ... 3 4 1 ...  2 8 2 1 7 ...  1    2
//	buckets��                    0   1     2    3   4     5    6    7      8 
//  ����Ԫ����String     "Ccz"  "b" "A"  "Ba"
	public String frequencySort3(String s) {
        if(s.length() < 3)
            return s;
        int max = 0;
        int[] freq = new int[256];
        for(char ch : s.toCharArray()) {
            freq[ch]++;
            max = Math.max(max,freq[ch]);
        }
        String[] buckets = new String[max + 1];  
        for(int i = 0 ; i < 256; i++) {  
            String str = buckets[freq[i]];
            if(freq[i] > 0)
                buckets[freq[i]] = (str == null) ? "" + (char)i : (str + (char) i);
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

package binarySearch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;


public class Main_test {

	public static void main(String[] args) {
		TreeMap<Integer,Integer> map=new TreeMap<Integer, Integer>();
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>(5);
		pq.add(5);
		pq.add(3);
		int[] citations;
		Arrays.sort(citations,((a,b)->(b-a)));
		pq.add(1);
		pq.add(2);
	
		pq.add(4);
		pq.add(6);
		pq.add(8);
		pq.add(7);
//		while(!pq.isEmpty())
//		System.out.println(pq.poll());
		System.out.println(pq);
		String s;
	 
	}

}

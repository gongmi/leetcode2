package hashTable;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;


public class Main_test {

	public static void main(String[] args) {
		Map<Integer,Integer> map;
		map = new HashMap<>();
		ArrayList<Integer> list= new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		Set<Integer> set=new HashSet<>();
		set.add(1);
		set.add(1);
		set.add(3);
		set.add(2);
		
		Iterator<Integer> it =set.iterator();
		int n=0;
		if(it.hasNext())
			n=it.next();
	System.out.println(n);	
	}

}

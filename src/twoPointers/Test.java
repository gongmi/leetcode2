package twoPointers;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<>();
		waitQueue.offer(null);
		System.out.println(waitQueue);
		System.out.println(waitQueue.size());
	}
}

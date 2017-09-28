package linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Main_test {
	public static void main(String[] args) {
		RandomListNode head = new RandomListNode(1);
		head.next = new RandomListNode(2);
		head.next.next = new RandomListNode(3);
		HashSet<RandomListNode> set = new HashSet<>();
		set.add(head);
		RandomListNode head2 = head;
		System.out.println(set.contains(head2));
	}
}
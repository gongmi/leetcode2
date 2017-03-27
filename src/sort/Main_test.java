package sort;

import java.util.*;


public class Main_test {

	public static void main(String[] args) {
		Map<String,Integer> map1=new HashMap<>();
		String s1="aabb";
		String s2="aabb";
		String s3="aabbcc";
		String s4="aabbccd";
		map1.put(s1,1);
		map1.put(s2,2);
		map1.put(s3,3);
		map1.put(s4,4);
		
		Map<Character,Integer> map2=new HashMap<>();
		map2.put('a',1);
		map2.put('B',2);
		map2.put('C',3);

	char[] array1=new char[]{'1','2','3'};
	Arrays.sort(array1); 
	char[] array2=new char[]{'1','2','3'};
	
	System.out.println(map1);
	System.out.println(array1.equals(array2));
	System.out.println(Arrays.equals(array1,array2));
	}

}

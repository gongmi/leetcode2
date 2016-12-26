package hashTable;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences_187 {
	// 我做的  直接用Set<String> 
   //	可以把注释掉的部分改成这样 也是利用了add的返回值
	// @return true if this set did not already contain the specified
	// element
	public List<String> findRepeatedDnaSequences(String s) {
		Set<String> set = new HashSet<>();
		Set<String> res = new HashSet<>();
		for (int i = 0; i + 10 <= s.length(); i++) {
			String sub = s.substring(i, i + 10);
			// if (set.contains(sub))
			// res.add(sub);
			// else
			// set.add(sub);

			if (!set.add(sub))
			res.add(sub);
		}
		return new LinkedList<String>(res);
	}
//	别人的先用了 bit manipulation  
//	因为我是直接把 subString放进set中 但是还可以把这个string换成int类型的一个数
//	就是用
//	        0 = 00 (bits in binary number system) = 'A'
//			1 = 01 (bits in binary number system) = 'C'
//			2 = 10 (bits in binary number system) = 'G'
//			3 = 11 (bits in binary number system) = 'T'
//	A   A  C  C  T  C  C  G  G  T
//	00 00 01 01 11 01 01 10 10 11 = 00000101110101101011 (binary) 
//	= 23915 (decimal)
//	v这个整数 就唯一的代表了这个substring
	
//	 if(!words.add(v) && doubleWords.add(v))
//	这个用法很厉害 当words中不存在v时 words.add(v)为true 因此不满足 所以不会 doubleWords.add(v))
//	只有当当words中存在v时 第一个条件才满足 才会 doubleWords.add(v)
	
	public List<String> findRepeatedDnaSequences2(String s) {
	    Set<Integer> words = new HashSet<>();
	    Set<Integer> doubleWords = new HashSet<>();
	    List<String> result = new LinkedList<>();
	    char[] map = new char[26];
	    map['A' - 'A'] = 0;
	    map['C' - 'A'] = 1;
	    map['G' - 'A'] = 2;
	    map['T' - 'A'] = 3;

	    for(int i = 0; i < s.length() - 9; i++) {
	        int v = 0;
	        for(int j = i; j < i + 10; j++) {
	            v <<= 2;
	            v |= map[s.charAt(j) - 'A'];
	        }
	        if(!words.add(v) && doubleWords.add(v)) {
	        	result.add(s.substring(i, i + 10));
	        }
	    }
	    return result;
	}
}

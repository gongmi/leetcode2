package hashTable;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings_205 {
	// 不能用WordPattern_290的top方法了
	// 因为不是相互对应的 但是也是一一对应的
	// 比如说paper与title 是true
	// 即l->e e->r
	// 因为top方法是放在同一个map中 s和t的char就无法区分了
	
	// 这是对应WordPattern_290的法2 一个map
	public boolean isIsomorphic(String s, String t) {
		Map<Character, Character> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				if (map.get(s.charAt(i)) != t.charAt(i))
					return false;
			} else if (map.containsValue(t.charAt(i)))
				return false;
			else
				map.put(s.charAt(i), t.charAt(i));
		}
		return true;
	}
//	top答案 这个思想就是 WordPattern_290 top答案的思想 
//	但是使用数组装的 因为用数组就够了 因为只有char
//	这样就不会产生 s 与t的char混淆的问题了
//	brilliant
	
    public boolean isIsomorphic2(String s1, String s2) {
        int[] m = new int[512];
        for (int i = 0; i < s1.length(); i++) {
            if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
            m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1; //加一是为了避免初始值
        }
        return true;
    }
}

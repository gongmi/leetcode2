package hashTable;

import java.util.*;

public class ImplementMagicDictionary_676 {
	// 刚开始答案 不对 没有考虑到删除的那个char的位置 后来把 i加入sub中 即可
	HashMap<String, String> map = new HashMap<>();

	public ImplementMagicDictionary_676() {
	}

	public void buildDict(String[] dict) {
		for (String s : dict) {
			for (int i = 0; i < s.length(); i++) {
				String sub = i + "," + s.substring(0, i) + s.substring(i + 1);
				if (map.containsKey(sub))
					map.put(sub, ""); // 存在两个或以上 则说明search的时候 如果有sub一样的 则一定存在
				else
					map.put(sub, s);// 只存在一个
			}
		}
	}

	public boolean search(String word) {
		if (word.equals(""))
			return false;
		for (int i = 0; i < word.length(); i++) {
			String sub = i + "," + word.substring(0, i) + word.substring(i + 1);
			if (map.containsKey(sub) && !map.get(sub).equals(word))
				return true;
		}
		return false;
	}

	// 更好的答案 value 不用存String 只需要存i处的char 并且把i加在i 处 而不是开头 这样更合理
	HashMap<String, Character> map2 = new HashMap<>();

	public void buildDict2(String[] dict) {
		for (String s : dict) {
			for (int i = 0; i < s.length(); i++) {
				String sub = s.substring(0, i) + "" + i + "" + s.substring(i + 1);
				if (map2.containsKey(sub))
					map2.put(sub, '*'); // 存在两个或以上 则说明search的时候 如果有sub一样的 则一定存在
				else
					map2.put(sub, s.charAt(i));// 只存在一个
			}
		}
	}

	public boolean search2(String word) {
		if (word.equals(""))
			return false;
		for (int i = 0; i < word.length(); i++) {
			String sub = word.substring(0, i) + "" + i + "" + word.substring(i + 1);
			if (map2.containsKey(sub) && map2.get(sub) != word.charAt(i))
				return true;
		}
		return false;
	}
}

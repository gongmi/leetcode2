package hashTable;

import java.util.HashMap;
import java.util.Map;

public class WordPattern_290 {
//	top答案
//	利用了put返回的值
//     @return the previous value associated with key,
//        	or null if there was no mapping for key.

	public boolean wordPattern(String pattern, String str) {
	    String[] words = str.split(" ");
	    if (words.length != pattern.length())
	        return false;
	    Map index = new HashMap();
	    for (Integer i=0; i<words.length; ++i)
	        if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
	            return false;
	    return true;
	}
	
//	法2
	// 为了满足一对1 的关系我用了两个map
	// 特别注意当比较两个String是否一样时 不能用== 要用equals！！！
	public boolean wordPattern3(String pattern, String str) {
		String[] words = str.split(" ");
		if (words.length != pattern.length())
			return false;
		Map<String, Character> wordMapChar = new HashMap<>();
		Map<Character, String> charMapWord = new HashMap<>();

		for (int i = 0; i < words.length; i++) {
			if (wordMapChar.containsKey(words[i])
					&& wordMapChar.get(words[i]) != pattern.charAt(i))
				return false;
			if (charMapWord.containsKey(pattern.charAt(i))
					&& !charMapWord.get(pattern.charAt(i)).equals(words[i]))
				return false;

			wordMapChar.put(words[i], pattern.charAt(i));
			charMapWord.put(pattern.charAt(i), words[i]);
		}
		return true;
	}
	
//	法2
	// 其实可以只用一个map啊！
	public boolean wordPattern2(String pattern, String str) {
		String[] words = str.split(" ");
		if (words.length != pattern.length())
			return false;
		Map<Character, String> map = new HashMap<>();

		for (int i = 0; i < words.length; i++) {
			char c = pattern.charAt(i);
			if (map.containsKey(c)) {
				if (!map.get(c).equals(words[i]))
					return false;
			} else if (map.containsValue(words[i]))
				return false;
			else
				map.put(c, words[i]);
		}
		return true;
	}
}

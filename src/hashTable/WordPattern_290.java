package hashTable;

import java.util.HashMap;
import java.util.Map;

public class WordPattern_290 {
//	top��
//	������put���ص�ֵ
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
	
//	��2
	// Ϊ������һ��1 �Ĺ�ϵ����������map
	// �ر�ע�⵱�Ƚ�����String�Ƿ�һ��ʱ ������== Ҫ��equals������
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
	
//	��2
	// ��ʵ����ֻ��һ��map����
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

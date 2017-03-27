package hashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
//数组不能直接赋值 那样是指向同一个对象 浅复制
//用Arrays.copyOf 深复制
//0 1 2三种方法都是我写的 时间超级慢 
//freq.putAll(frequency); map的复制 也不是深复制
//只有当<>中是基本数据类型才是深复制 如果是对象 是浅复制的

public class FindAllAnagrams_438 {
	// 借鉴了MinimumWindowSubstring_76滑动窗口
	// Time Complexity will be O(n)
	// 我之前的方法都是O(n^2)
//	这道题我的本子上写的很复杂 其实看代码 很简单的 不用去考虑别的那些char
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new LinkedList<>();
		int[] freq = new int[26];
		for (int i = 0; i < p.length(); i++)
			freq[p.charAt(i) - 'a']++;

		int left = 0, right = 0, count = p.length();

		while (right < s.length()) {
			if ((freq[s.charAt(right) - 'a']--) > 0)  //如果这里别的那些char进来了 或者多的p里的char进来了
				count--;                                //都会在freq里被置为负的

			if (count == 0)
				res.add(left);
			right++;

			if ((right - left) != p.length())
				continue;

			if ((freq[s.charAt(left) - 'a']++) >= 0)  //如果是负的 这里会被排除的 因此 其实只有freq数组里的char在起作用
				count++;

			left++;
		}
		return res;
	}

	// public List<Integer> findAnagrams0(String s, String p) {
	// boolean flag=false;
	// List<Integer> res = new LinkedList<>();
	// char[] sArray=s.toCharArray();
	// char[] pArray=p.toCharArray();
	// HashMap<Character,Integer> frequency=new HashMap<>();
	// HashMap<Character,Integer> freq = new HashMap<>();
	// for (char c:pArray)
	// frequency.put(c,frequency.getOrDefault(c,0)+1);
	//
	//
	// int i = 0;
	// while (i < s.length() - p.length() + 1) {
	// freq.clear();
	// freq.putAll(frequency);
	// if(flag)
	// {
	// if (sArray[i-1]==sArray[i + p.length() -1])
	// {res.add(i++); flag=true;}
	// else
	// {flag=false;
	// if (!freq.containsKey(sArray[i + p.length() -1]))
	// i=i + p.length();
	// else
	// i++;
	// }
	// continue;
	// }
	//
	// for (int j = 0; j < p.length(); j++) {
	// if (!freq.containsKey(sArray[i + j])) {
	// flag = false;
	// i=i+j+1;
	// break;
	// }
	// if (freq.get(sArray[i + j])==0) {
	// flag = false;
	// i=i+1;
	// break;
	// }
	// freq.put(sArray[i + j],freq.get(sArray[i + j])-1);
	// flag = true;
	// }
	// if (flag)
	// res.add(i++);
	// }
	// return res;
	// }
	// public List<Integer> findAnagrams1(String s, String p) {
	// boolean flag;
	// List<Integer> res = new LinkedList<>();
	// int[] frequency = new int[26];
	// for (int i = 0; i < p.length(); i++)
	// frequency[p.charAt(i) - 'a']++;
	//
	// for (int i = 0; i < s.length() - p.length()+1; i++) {
	// flag = true;
	// // int[] freq = frequency;
	// int[] freq = Arrays.copyOf(frequency, frequency.length);
	// for (int j = 0; j < p.length(); j++) {
	// if ((freq[s.charAt(i + j) - 'a']) == 0) {
	// flag = false;
	// break;
	// }
	// freq[s.charAt(i + j) - 'a']--;
	// }
	// if (flag)
	// res.add(i);
	// }
	// return res;
	// }
	public List<Integer> findAnagrams2(String s, String p) {
		boolean flag = false;
		List<Integer> res = new LinkedList<>();
		int[] frequency = new int[26];
		for (int i = 0; i < p.length(); i++)
			frequency[p.charAt(i) - 'a']++;

		for (int i = 0; i < s.length() - p.length() + 1; i++) {
			if (flag) {
				if (s.charAt(i - 1) == s.charAt(i + p.length() - 1)) {
					res.add(i);
					flag = true;
				} else
					flag = false;
				continue;
			}
			int[] freq = Arrays.copyOf(frequency, frequency.length);
			for (int j = 0; j < p.length(); j++) {
				if ((freq[s.charAt(i + j) - 'a']) == 0) {
					flag = false;
					break;
				}
				freq[s.charAt(i + j) - 'a']--;
				flag = true;
			}
			if (flag)
				res.add(i);
		}
		return res;
	}
}

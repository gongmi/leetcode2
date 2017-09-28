package Graph_UnionFind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class test {

	public static void main(String[] args) {
		WordLadderII_126 t = new WordLadderII_126();
		String[] array = new String[] { "hot", "dot", "dog", "lot", "log", "cog", "ttt" };
		List<String> list = new ArrayList<>();
		for (String s : array)
			list.add(s);
		System.out.println(t.findLadders("hit", "ttt", list));
	}
}

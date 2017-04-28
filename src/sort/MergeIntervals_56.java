package sort;

import java.util.*;

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	 Interval(int s, int e) { start = s; end = e; }
}

public class MergeIntervals_56 {
	// ��һ��� ������ ��merge ��ʵ����ֻ����start������Ĳ��ù�end ����endҲ���ٱȵ�
	public List<Interval> merge(List<Interval> intervals) {
		// Collections.sort(intervals,((a,b)->a.start==b.start?(a.end-b.end):(a.start-b.start)));
		// ������ı�������Ŀ�ǳ��� ����Ϊʲô��
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.start == b.start ? (a.end - b.end) : (a.start - b.start);
			}
		});
		Deque<Interval> s = new LinkedList<>();
		for (Interval in : intervals) {
			if (s.isEmpty())
				s.push(in);
			else {
				if (in.start <= s.peek().end) {
					if (in.end > s.peek().end)
						s.peek().end = in.end;
				} else
					s.push(in);
			}
		}
		return new LinkedList<Interval>(s);
	}
//���ǵڶ��� ֱ����ԭ���Ļ����ϸĵ� ���ǲ�û�б��
	public List<Interval> merge2(List<Interval> intervals) {
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.start == b.start ? (a.end - b.end) : (a.start - b.start);
			}
		});
		int i = 1;
		while (i < intervals.size()) {
			if (intervals.get(i).start <= intervals.get(i - 1).end) {
				if (intervals.get(i).end > intervals.get(i - 1).end)
					intervals.get(i - 1).end = intervals.get(i).end;
				intervals.remove(i);
			} else
				i++;

		}
		return intervals;
	}
//	top ��ʵ���ҵ�һ���� ֻ������ÿ�ζ��½���Interval  �Ҿ����ҵĸ��� ��Ȼ��Ҫpop
	public List<Interval> merge3(List<Interval> intervals) {
	    if (intervals.size() <= 1)
	        return intervals;
	    
//	    intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
	    
	    List<Interval> result = new LinkedList<Interval>();
	    int start = intervals.get(0).start;
	    int end = intervals.get(0).end;
	    
	    for (Interval interval : intervals) {
	        if (interval.start <= end) // Overlapping intervals, move the end if needed
	            end = Math.max(end, interval.end);
	        else {                     // Disjoint intervals, add the previous one and reset bounds
	            result.add(new Interval(start, end));
	            start = interval.start;
	            end = interval.end;
	        }
	    }
	    
	    // Add the last interval
	    result.add(new Interval(start, end));
	    return result;
	}
}

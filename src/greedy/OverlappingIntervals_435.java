package greedy;

import java.util.Arrays;
import java.util.Comparator;

class Interval {
	int start;
	int end;
}
// 就是classic Greedy problem: Interval Scheduling P238
public class OverlappingIntervals_435 {
	// 9ms
	public int eraseOverlapIntervals(Interval[] intervals) {
		if (intervals.length == 0)
			return 0;
		// Arrays.sort(intervals, (a, b)->(a.end-b.end));
		// 用下面的比用上面的快 匿名内部类
		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval o1, Interval o2) {
				return o1.end - o2.end;
			}
		});

		int CurrEnd = intervals[0].end, sum = 1;
		for (int i = 1; i < intervals.length; i++)
			if (CurrEnd <= intervals[i].start) {
				sum++;
				CurrEnd = intervals[i].end;
			}
		return intervals.length - sum;

	}

}

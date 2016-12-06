package binarySearch;

public class FirstBadVersion_278 {
//我的方法是用low代表good high代表bad 一直二分 当good=bad-1时就找到了第一个bad
	public int firstBadVersion(int n) {
		int low = 0;
		int high = n;
		int mid = 0;

		while (low < high) {
			mid = low + (high - low) / 2;
			if (isBadVersion(mid))
				high = mid;
			else
				low = mid;
			if (low == (high - 1))
				break;
		}
		return high;
	}
	
	//别人的是认真找第一个bad
	public int firstBadVersion2(int n) {
	    int start = 1, end = n;
	    while (start < end) {
	        int mid = start + (end-start) / 2;
	        if (!isBadVersion(mid)) start = mid + 1;
	        else end = mid;            
	    }        
	    return start;
	}
}

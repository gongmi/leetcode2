package binarySearch;

public class FirstBadVersion_278 {
//�ҵķ�������low����good high����bad һֱ���� ��good=bad-1ʱ���ҵ��˵�һ��bad
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
	
	//���˵��������ҵ�һ��bad
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

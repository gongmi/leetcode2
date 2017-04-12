package heap;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindKPairsSmallestSums_373 {
	// 把 pair的comparator 写在类中 比写在 PriorityQueue的构造函数中快多了
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
Queue q=new LinkedList();
		List<int[]> res = new LinkedList<>();
		if (nums1.length == 0 || nums2.length == 0)
			return res;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for (int i = 0; i < k && i < nums1.length; i++)
			pq.offer(new Pair(i, 0, nums1, nums2));

		for (int i = 0; i < k && !pq.isEmpty(); i++) {
			Pair p = pq.poll();
			res.add(new int[] { nums1[p.i1], nums2[p.i2] });
			if (p.i2 == nums2.length - 1)
				continue;
			pq.offer(new Pair(p.i1, p.i2 + 1, nums1, nums2));
		}

		return res;
	}
}

class Pair implements Comparable<Pair> {
	public int i1, i2;
	public int[] a1, a2;

	public Pair(int index1, int index2, int[] arr1, int[] arr2) {
		i1 = index1;
		i2 = index2;
		a2 = arr2;
		a1 = arr1;
	}

	public int sum() {
		return a1[i1] + a2[i2];
	}

	@Override
	public int compareTo(Pair p) {
		return this.sum() - p.sum();
	}
}

// public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//
// List<int[]> res=new LinkedList<>();
// if(nums1.length==0||nums2.length==0) return res;
// PriorityQueue<Pair> pq=new
// PriorityQueue<>((P1,P2)->(nums1[P1.index1]+nums2[P1.index2]-nums1[P2.index1]-nums2[P2.index2]));
// for(int i=0;i<k&&i<nums1.length;i++)
// pq.offer(new Pair(i,0));
//
// for(int i=0;i<k&&!pq.isEmpty();i++)
// { Pair p=pq.poll();
// res.add(new int[]{nums1[p.index1],nums2[p.index2]});
// if (p.index2==nums2.length-1) continue;
// pq.offer(new Pair(p.index1,p.index2+1));
// }
//
// return res;
// }
// }
//
// class Pair {
// int index1, index2;
//
// public Pair(int index1, int index2) {
// this.index1 = index1;
// this.index2 = index2;
// }
// }

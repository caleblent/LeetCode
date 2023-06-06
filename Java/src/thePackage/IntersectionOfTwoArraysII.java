package thePackage;

import java.util.ArrayList;

public class IntersectionOfTwoArraysII {

	public int[] intersect(int[] nums1, int[] nums2) {
		ArrayList<Integer> nums3 = new ArrayList<Integer>();

		for (int i1 = 0; i1 < nums1.length; i1++) {
			for (int i2 = 0; i2 < nums2.length; i2++) {
				if (nums1[i1] == nums2[i2]) {
					nums3.add(nums1[i1]);
					nums2[i2] = -1; // this prevents duplicates
					break;
				}
			}
		}

		return convertArrayListToArray(nums3);
	}

	public int[] convertArrayListToArray(ArrayList<Integer> al) {
		int[] a = new int[al.size()];

		for (int i = 0; i < a.length; i++) {
			a[i] = al.get(i);
		}

		return a;
	}
}

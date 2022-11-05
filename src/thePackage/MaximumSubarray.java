package thePackage;

import java.util.ArrayList;

public class MaximumSubarray {

	public int maxSubArray(int[] nums) {
		ArrayList<Integer> subSums  = new ArrayList<Integer>();
		int length = getSummation(nums.length);
		
		for (int i = 0; i < length; i++) {
			subSums.add(0);
		}
		
		return findMax(subSums, length);
	}

	private int findMax(ArrayList<Integer> nums, int length) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < length; i++) {
			if (nums.get(i) > max)
				max = nums.get(i);
		}
		return max;
	}
	
	public int getSummation(int n) {
		return n * (n + 1) / 2;
	}
}

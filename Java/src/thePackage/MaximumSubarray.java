package thePackage;

public class MaximumSubarray {

	public static void main(String[] args) {
		int[] nums1 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int[] nums2 = { 1 };
		int[] nums3 = { 5, 4, -1, 7, 8 };

		System.out.println(maxSubArray(nums1));
		System.out.println(maxSubArray(nums2));
		System.out.println(maxSubArray(nums3));
	}

	public static int maxSubArray(int[] nums) {
		int size = nums.length;
		int finalMax = Integer.MIN_VALUE;
		int tempMax = 0;

		for (int i = 0; i < size; i++) {
			tempMax = tempMax + nums[i];
			if (finalMax < tempMax)
				finalMax = tempMax;
			if (tempMax < 0)
				tempMax = 0;
		}
		return finalMax;
	}

	public static int maxSubArray_recursiveTooSlow(int[] nums) {
		int[] subSums = new int[nums.length];
		for (int i = 0; i < subSums.length; i++) {
			subSums[i] = maxSubArray(nums, i);
		}
		return findMax(subSums);
	}

	// recursive
	public static int maxSubArray(int[] a, int index) {
		// base case
		if (index == 0) {
			return a[0];
		}

		// recursive case
		return getMaxInt(a[index], a[index] + maxSubArray(a, index - 1));
	}

	public static int getMaxInt(int a, int b) {
		return a > b ? a : b;
	}

	private static int findMax(int[] a) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max)
				max = a[i];
		}
		return max;
	}
}

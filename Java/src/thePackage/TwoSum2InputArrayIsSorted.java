package thePackage;

public class TwoSum2InputArrayIsSorted {

	public static Integer mid_;
//	public static Integer index_;

	public static int[] twoSum(int[] numbers, int target) {
		for (int i = 0; i < numbers.length; i++) {
			int tempTarget = target - numbers[i];

			int low = i + 1;
			int high = numbers.length - 1;

			while (low <= high) {
				int mid = low + (high - low) / 2;

				if (tempTarget < numbers[mid])
					high = mid - 1;

				else if (tempTarget > numbers[mid])
					low = mid + 1;

				else // tempTarget == numbers[mid]
					return new int[] { i + 1, mid + 1 };
				
				mid_ = mid;
			}
			
			if (tempTarget == numbers[mid_])
				return new int[] { i + 1, mid_ + 1 };
		}
		return null;
	}

//	public static int[] twoSum_notQuite(int[] numbers, int target) {
//		for (int i = 0; i < numbers.length; i++) {
//			index_ = i;
//			int low = i + 1, high = numbers.length - 1;
//			while (low <= high) {
//				mid_ = low + (high - low) / 2;
//
//				if (numbers[i] + numbers[mid_] < target)
//					high = mid_ - 1;
//
//				else if (numbers[i] + numbers[mid_] > target)
//					low = mid_ + 1;
//
//				else // (numbers[i] + numbers[mid] == target)
//					return new int[] { i + 1, mid_ + 1 };
//			}
//
//			if (numbers[i] + numbers[mid_] == target)
//				return new int[] { i + 1, mid_ + 1 };
//		}
//		return new int[] { index_ + 1, mid_ + 1 };
//	}

	public static int search(int[] nums, int target) {
		int low = 0, high = nums.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (target < nums[mid])
				high = mid - 1;

			else if (target > nums[mid])
				low = mid + 1;

			else
				return mid;
		}
		return -1;
	}

	// this works, but it's too slow
	public static int[] twoSum_bruteForce(int[] numbers, int target) {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] + numbers[j] == target) {
					return new int[] { i + 1, j + 1 };
				}
			}
		}
		return null;
	}
}

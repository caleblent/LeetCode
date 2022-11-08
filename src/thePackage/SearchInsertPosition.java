package thePackage;

public class SearchInsertPosition {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5, 6 };

		System.out.println(searchInsert(nums, 5)); // 2
		System.out.println(searchInsert(nums, 2)); // 1
		System.out.println(searchInsert(nums, 7)); // 4
	}

	public static int searchInsert(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		int mid = -1;

		while (low <= high) {
			mid = low + (high - low) / 2;

			if (target < nums[mid])
				high = mid - 1;

			else if (target > nums[mid])
				low = mid + 1;

			else
				return mid;
		}

		return nums[mid] > target ? mid : mid + 1;
	}
}

package thePackage;

public class SortColors {
	
	public void sortColors(int[] nums) {
		// declare left and right pointers
		int left = 0;
		int right;
		
		// sort all 0s first
		while (left < nums.length - 1) {
			if (nums[left] == 0) {
				left++;
			} else {
				right = left+1;
				while (right < nums.length && nums[right] != 0) {
					right++;
				}
				// swap the numbers (if we found something)
				if (right < nums.length) {
					int temp = nums[right];
					nums[right] = nums[left];
					nums[left] = temp;
				}
				left++;
			}
		}
		
		// sort all 1s next
		left = 0;
		while (left < nums.length - 1) {
			if (nums[left] == 0 || nums[left] == 1) {
				left++;
			} else {
				right = left+1;
				while (right < nums.length && nums[right] != 1) {
					right++;
				}
				// swap the numbers (if we found something)
				if (right < nums.length) {
					int temp = nums[right];
					nums[right] = nums[left];
					nums[left] = temp;
				}
				left++;
			}
		}
		
		// at this point, the 2s will already be sorted
		return;
	}
}

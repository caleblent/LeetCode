package thePackage;

public class BinarySearch {
	
	public static void main(String[] args) {
		int[] nums = new int[]{-1,0,3,5,9,12};
		System.out.println(search(nums, 9)); //   4
		System.out.println(search(nums, 4)); //  -1
		System.out.println(search(nums, 0)); //   1
		System.out.println(search(nums, 3)); //   2
		System.out.println(search(nums, 12)); //  5
		System.out.println(search(nums, 13)); // -1
	}
	
	public static int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        
        while (low <= high) {
        	int mid = low + (high - low)/2;
        	
        	if (target < nums[mid])
				high = mid - 1;
        	
        	else if (target > nums[mid])
        		low = mid+1;
        	
        	else
        		return mid;
        }
		return -1;
    }

}

package thePackage;

public class SearchA2DMatrix {

	public static void main(String[] args) {
//		int[][] test3 = {{1,3}};
		int[][] test4 = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		System.out.println(searchMatrix_worksButTooSlow(test4, 6));
//		System.out.println(searchMatrix(test3, 3));
//		System.out.println(searchMatrix(test3, 2));
	}
	
	public static boolean searchMatrix_bruteForce(int[][] matrix, int target) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == target)
					return true;
				if (matrix[i][j] > target) // since it's sorted
                    return false;
			}
		}
		return false;
	}
	

	public static boolean searchMatrix_worksButTooSlow(int[][] matrix, int target) {
		int length = matrix.length;
		int height = matrix[0].length;
		System.out.println("TARGET:" + target + " length:" + length + " height:" + height);

		int loVal = matrix[0][0];
		int hiVal = matrix[length - 1][height - 1];
		
		int[] lo = {0,0};
		int[] hi = {length - 1,height - 1};
		int[] mid = new int[2];

		while (loVal < hiVal) {
			mid[0] = lo[0] + (hi[0] - lo[0])/2;
			mid[1] = lo[1] + (hi[1] - lo[1])/2;
			int midVal = matrix[mid[0]][mid[1]];

			if (target < midVal) {
				hi[0] = mid[0];
				hi[1] = mid[1];
				hiVal = matrix[hi[0]][hi[1]];
			}
			else if (target > midVal) {
				lo[0] = mid[0];
				lo[1] = mid[1]+1;
				if (lo[1] >= length) {
					lo[0]++;
					lo[1] = 0;
					loVal = matrix[lo[0]][lo[1]];
				} else {
					loVal = matrix[lo[0]][lo[1]];
				}
			}
			else
				return true;
		}
		
		if (loVal == target || hiVal == target)
			return true;

		return false;
	}

	public static int binarySearch(int[] nums, int target) {
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
}

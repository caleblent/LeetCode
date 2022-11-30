package thePackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		// sort the array
//		quickSort(nums, 0, nums.length - 1);
		Arrays.sort(nums);
		
		// initialize left and right pointers
		int L, R;
		
		for (int i = 0; i < nums.length - 3; i++) {
			L = i + 1;
			R = nums.length - 1;
			while (L < R) {
				if (nums[i] + nums[L] + nums[R] == 0) { 
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(nums[i]);
					temp.add(nums[L]);
					temp.add(nums[R]);
					temp.sort(null);
					if (!result.contains(temp))
						result.add(temp);
				}
				else if (nums[i] + nums[L] + nums[R] < 0) {
                    L++;
				}
 
                else  if (nums[i] + nums[L] + nums[R] > 0) {
                    R--;
                }
			}
		}
		
		return result;
	}
	
	public static void quickSort(int arr[], int begin, int end) {
		if (begin < end) {
			int partitionIndex = partition(arr, begin, end);

			quickSort(arr, begin, partitionIndex - 1);
			quickSort(arr, partitionIndex + 1, end);
		}
	}
	private static int partition(int arr[], int begin, int end) {
		int pivot = arr[end];
		int i = (begin - 1);

		for (int j = begin; j < end; j++) {
			if (arr[j] <= pivot) {
				i++;

				int swapTemp = arr[i];
				arr[i] = arr[j];
				arr[j] = swapTemp;
			}
		}

		int swapTemp = arr[i + 1];
		arr[i + 1] = arr[end];
		arr[end] = swapTemp;

		return i + 1;
	}

	// O(N^3) solution (works but far too slow for large data sets)
	public List<List<Integer>> threeSum_worksButTooSlow(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				for (int k = j+1; k < nums.length; k++) {
					if (nums[i] + nums[j] + nums[k] == 0) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(nums[i]);
						temp.add(nums[j]);
						temp.add(nums[k]);
						temp.sort(null);
						if (!result.contains(temp))
							result.add(temp);
					}
				}
			}
		}
		
		return result;
	}

}

package thePackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		
		// sort the array
		Arrays.sort(nums);
		
		// declare left and right pointers
		int left, right;
		
		int i = 0;
		while (i < nums.length - 2) {
			// if the number is already positive, adding more positive numbers cannot equal 0
			if (nums[i] > 0)
				break;
			
			// initialize left and right pointers
			left = i + 1;
			right = nums.length - 1;
			
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				
				if (sum == 0)
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));
				
				if (sum <= 0) {
					while (left+1 < right && nums[left] == nums[left+1]) {
						left++; 
					}
                    left++;
				}
                if (sum >= 0) {
                	while (left < right-1 && nums[right] == nums[right-1]) {
                		right--; 
                	}
                    right--;
                }
			}
			// iterate thru any duplicates
			while (i+1 < nums.length-2 && nums[i] == nums[i+1])
				i++; 	
			i++;
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

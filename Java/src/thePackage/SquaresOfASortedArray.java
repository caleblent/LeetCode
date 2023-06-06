package thePackage;

public class SquaresOfASortedArray {

	public static void main(String[] args) {

	}

	public int[] sortedSquares(int[] nums) {
		/* square each element in the array */
		for (int i = 0; i < nums.length; i++)
			nums[i] *= nums[i];

		/* sort the array in ascending order */
		quickSort(nums, 0, nums.length - 1);

		/* return the array */
		return nums;
	}

	/* https://www.baeldung.com/java-quicksort */
	public void quickSort(int arr[], int begin, int end) {
		if (begin < end) {
			int partitionIndex = partition(arr, begin, end);

			quickSort(arr, begin, partitionIndex - 1);
			quickSort(arr, partitionIndex + 1, end);
		}
	}

	/* https://www.baeldung.com/java-quicksort */
	private int partition(int arr[], int begin, int end) {
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

}

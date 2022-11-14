package thePackage;

import java.util.ArrayList;
import java.util.List;

public class AAA_Utility_Functions {
	/* -------------------------------------------------------*/
	/* -------------------- ALGORITHMS -----------------------*/
	/* -------------------------------------------------------*/
	// Binary Search
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
	
	// Quick Sort
	/* https://www.baeldung.com/java-quicksort */
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
	
	public static void quickSort(char arr[], int begin, int end) {
		if (begin < end) {
			int partitionIndex = partition(arr, begin, end);

			quickSort(arr, begin, partitionIndex - 1);
			quickSort(arr, partitionIndex + 1, end);
		}
	}
	private static int partition(char arr[], int begin, int end) {
		int pivot = arr[end];
		int i = (begin - 1);

		for (int j = begin; j < end; j++) {
			if (arr[j] <= pivot) {
				i++;

				char swapTemp = arr[i];
				arr[i] = arr[j];
				arr[j] = swapTemp;
			}
		}

		char swapTemp = arr[i + 1];
		arr[i + 1] = arr[end];
		arr[end] = swapTemp;

		return i + 1;
	}
	
	// Bubble Sort
	public static void bubbleSort(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
	
	// Find Maximum Value
	public static int findMax(int[] a) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max)
				max = a[i];
		}
		return max;
	}
	
	/* ------------------------------------------------------------*/
	/* -------------------- DATA STRUCTURES -----------------------*/
	/* ------------------------------------------------------------*/
	
	/* ListNode class/object used for LeetCode problems involving linked nodes */
	class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { 
			this.val = val; this.next = next; 
		}
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) {	this.val = val;	}
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	/* ---------------------------------------------------------------*/
	/* -------------------- ARRAY COPY METHODS -----------------------*/
	/* ---------------------------------------------------------------*/
	
	public static char[] copyStringToCharArray(String s) {
		char[] c = new char[s.length()];

		for (int i = 0; i < c.length; i++) {
			c[i] = s.charAt(i);
		}

		return c;
	}

	public static String copyCharArrayToString(char[] c) {
		String s = "";

		for (int i = 0; i < c.length; i++) {
			s += c[i];
		}

		return s;
	}
	
	public static int[] convertArrayListToArray(ArrayList<Integer> al) {
		int[] a = new int[al.size()];

		for (int i = 0; i < a.length; i++) {
			a[i] = al.get(i);
		}

		return a;
	}
	
	/* ------------------------------------------------------------*/
	/* -------------------- PRINT FUNCTIONS -----------------------*/
	/* ------------------------------------------------------------*/
	
	public static void printInt(int[][] a) {
		System.out.print("[\n");
		for (int i = 0; i < a.length; i++) {
			System.out.print("[");
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j]);
				if (j != a[i].length - 1) {
					System.out.print(", ");
				}
			}
			System.out.print("]\n");
		}
		System.out.print("]\n");
	}
	
	public static void printChar(char[] a) {
		System.out.print("[");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
			if (i != a.length - 1)
				System.out.print(", ");
		}
		System.out.print("]\n");
	}
	
	public static void printBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
	
	public static void printRows(List<List<Integer>> list) {
		for (int i = 0; i < list.size(); i++) {
			printRow(list.get(i));
		}
	}

	public static void printRow(List<Integer> row) {
		for (int i = 0; i < row.size(); i++) {
			System.out.printf("%5d", row.get(i));
		}
		System.out.print("\n");
	}
	
	// adds data from a 2D int array to a 1D ArrayList<Integer>
	public static ArrayList<Integer> addData(int[][] data) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				ret.add(data[i][j]);
			}
		}
		return ret;
	}
	
	/* -------------------------------------------------------------------*/
	/* -------------------- MATHEMATICS OPEARTIONS -----------------------*/
	/* -------------------------------------------------------------------*/
		
	public static int getSummation(int n) {
		return n * (n + 1) / 2;
	}
	
	/* ----------------------------------------------------------*/
	/* -------------------- MISCELLANEOUS -----------------------*/
	/* ----------------------------------------------------------*/
	
	public static String removeChar(String s, int index) {
		String ret = "";

		for (int i = 0; i < s.length(); i++) {
			if (i != index)
				ret += s.charAt(i);
		}

		return ret;
	}
	
	public static boolean isVowel(char c) {
		if (c == 'a' ||	c == 'A' ||
			c == 'e' ||	c == 'E' ||
			c == 'i' ||	c == 'I' ||
			c == 'o' ||	c == 'O' ||
			c == 'u' ||	c == 'U')
			return true;

		return false;
	}
	
	public static boolean isConsonant(char c) {
		if (c == 'a' ||	c == 'A' ||
			c == 'e' ||	c == 'E' ||
			c == 'i' ||	c == 'I' ||
			c == 'o' ||	c == 'O' ||
			c == 'u' ||	c == 'U')
			return false;

		return true;
	}
}

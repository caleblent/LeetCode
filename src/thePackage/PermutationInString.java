package thePackage;

import java.util.ArrayList;
import java.util.LinkedList;

public class PermutationInString {
	
	public boolean checkInclusion_tooSlow3(String s1, String s2) {
		int size1 = s1.length();
		int size2 = s2.length();
		
		// 1. make list of all s1 permutations
		ArrayList<String> permutations = new ArrayList<String>();
		permute(permutations, s1, 0, size1 - 1);

		// 2. slice s2 into substrings of s1.length() size
		ArrayList<String> substrings = new ArrayList<String>();
		for (int i = 0; i < size2 - size1 + 1; i++) {
			String temp = (s2.substring(i, i+size1));
			// 3. check the substrings up against the permutations
			for (int j = 0; j < permutations.size(); j++) {
				if (temp.equals(permutations.get(j)))
					return true;
			}
		}

		// 4. if no permutations have been found, return false
		return false;
	}
	
	public boolean checkInclusion_tooSlow2(String s1, String s2) {
		int size1 = s1.length();
		int size2 = s2.length();
		
		// 1. make list of all s1 permutations
		ArrayList<String> permutations = new ArrayList<String>();
		permute(permutations, s1, 0, size1 - 1);

		// 2. slice s2 into substrings of s1.length() size
		ArrayList<String> substrings = new ArrayList<String>();
		for (int i = 0; i < size2 - size1 + 1; i++) {
			substrings.add(s2.substring(i, i+size1));
		}
		
		// 3. check the substrings up against the permutations
		for (int i = 0; i < substrings.size(); i++) {
			for (int j = 0; j < permutations.size(); j++) {
				if (substrings.get(i).equals(permutations.get(j)))
					return true;
			}
		}

		// 4. if no permutations have been found, return false
		return false;
	}

	// This solution is INCORRECT; although it is similar-ish to: "242. Valid
	// Anagram"
	// This would be correct if we wanted to see if s2 contained all the characters
	// in s1
	public boolean checkInclusion_incorrectSolution(String s1, String s2) {
		// 0. if s2 is null, return false
		if (s2 == null)
			return false;
		// 0. if s1 is null/empty and s2 isn't, then return true
		if ((s1 == null || s1.isEmpty()) && s2 != null)
			return true;

		// 1. convert each String into a char[]
		char[] c1 = copyStringToCharArray(s1);
		char[] c2 = copyStringToCharArray(s2);

		// 2. sort char[] via QuickSort
		quickSort(c1, 0, c1.length - 1);
		quickSort(c2, 0, c2.length - 1);

		// 3. go through the char[]s
		// - if we get through c1 first, return true
		// - if we get through c2 first, return false
		int p1 = 0;
		int p2 = 0;
		while (p2 < c2.length) {
			if (p1 >= c1.length)
				return true;
			if (c1[p1] == c2[p2])
				p1++;
			p2++;
		}

		// 4. since we made it through c2 before all the characters in c1 were
		// accounted for, s2 does NOT contain a permutation of s1
		return false;
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

	public static char[] copyStringToCharArray(String s) {
		char[] c = new char[s.length()];

		for (int i = 0; i < c.length; i++) {
			c[i] = s.charAt(i);
		}

		return c;
	}

	// This solution does work, but it's too slow on bigger s1 inputs
	// The number of permutations is n! when n = s1.length()
	// Obviously that scales very fast with just a few additional characters to s1
	//
	// Interestingly, making the permutations list an ArrayList instead of a
	// LinkedList
	// makes a noticeable difference in performance. Random lookup in an ArrayList
	// is
	// constant time, vs for LinkedList it's linear.
	public static boolean checkInclusion_worksButNotFastEnough(String s1, String s2) {
		// 1. make list of all s1 permutations
		ArrayList<String> permutations = new ArrayList<String>();
		permute(permutations, s1, 0, s1.length() - 1);

		// 2. iterate over the permutation LinkedList, see is any are in s2
		for (int i = 0; i < permutations.size(); i++) {
			if (s2.contains(permutations.get(i)))
				return true;
		}

		// 3. since no permutations have been found in the original string, return false
		return false;
	}

	public static void printLinkedList(LinkedList<String> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}

	// below permutation methods found here:
	// https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/

	/**
	 * permutation function
	 * 
	 * @param str string to calculate permutation for
	 * @param l   starting index
	 * @param r   end index
	 */
	private static void permute(ArrayList<String> permutations, String str, int l, int r) {
		if (l == r)
			permutations.add(str);
		else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permute(permutations, str, l + 1, r);
				str = swap(str, l, i);
			}
		}
	}

	/**
	 * Swap Characters at position
	 * 
	 * @param a string value
	 * @param i position 1
	 * @param j position 2
	 * @return swapped string
	 */
	public static String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
}

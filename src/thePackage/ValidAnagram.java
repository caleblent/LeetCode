package thePackage;

public class ValidAnagram {
	
	public boolean isAnagram(String s, String t) {
		// 0. if either s or t is null, or they aren't the same length, return false
		if (s == null || t == null || s.length() != t.length())
			return false;
		
        // 1. convert each String into a char[]
		char[] cs = copyStringToCharArray(s);
		char[] ct = copyStringToCharArray(t);
		
		// 2. sort char[] via QuickSort
		quickSort(cs, 0, cs.length-1);
		quickSort(ct, 0, ct.length-1);
		
		// 3. compare the char[]'s element by element
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] != ct[i])
				return false;
		}
		
		// 4. if it hasn't returned yet, they must be anagrams
		return true;
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
	
	
}

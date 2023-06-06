package thePackage;

public class RansomNote {

	public boolean canConstruct(String ransomNote, String magazine) {
		// 1. convert each String into a char[]
		char[] cRansom = copyStringToCharArray(ransomNote);
		char[] cMagazine = copyStringToCharArray(magazine);

		// 2. sort char[] via QuickSort
		quickSort(cRansom, 0, cRansom.length - 1);
		quickSort(cMagazine, 0, cMagazine.length - 1);
		
		System.out.println("ransom note sorted: ");
		printChar(cRansom);
		System.out.println("magazine sorted: ");
		printChar(cMagazine);
		
		//3. go through cRansom with 2 pointers (one to each char[])
		//   if cRansom has a char not contained in cMagazine, return false
		int iRan = 0, iMag = 0;
		while (iMag < cMagazine.length && iRan < cRansom.length) {
			if (cMagazine[iMag] == cRansom[iRan]) {
				iRan++;
				iMag++;
			} else if (cMagazine[iMag] < cRansom[iRan]) {
				iMag++;
			} else {
				return false;
			}
		}
		
		// 4. if it hasn't returned yet, there's 2 possible scenarios:
		//    - it hasn't gotten through the whole ransom note
		//    - it is in fact constructible
		if (iRan < cRansom.length)
			return false;
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
	
	public static void printChar(char[] a) {
		System.out.print("[");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
			if (i != a.length - 1)
				System.out.print(", ");
		}
		System.out.print("]\n");
	}
}

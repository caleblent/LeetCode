package thePackage;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	
	public static void main(String[] args) {
		printRows(generate(10));
	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> Triangle = new ArrayList<List<Integer>>();
		List<Integer> triangleRow = new ArrayList<Integer>();
		
		for (int i = 0; i < numRows; i++) {
			triangleRow = new ArrayList<Integer>();
			triangleRow.add(1);
			for (int j = 1; j < i; j++) {
				int val = Triangle.get(i-1).get(j-1) + Triangle.get(i-1).get(j);
				triangleRow.add(val);
			}
			if (i != 0) // don't wanna add multiple 1s to the first row
				triangleRow.add(1);
			
			Triangle.add(triangleRow);
		}

		return Triangle;
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

}

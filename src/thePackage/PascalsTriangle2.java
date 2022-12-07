package thePackage;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {

	public List<Integer> getRow(int rowIndex) {
		List<List<Integer>> Triangle = new ArrayList<List<Integer>>();
		List<Integer> triangleRow = new ArrayList<Integer>();
		
		for (int i = 0; i <= rowIndex; i++) {
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

		return triangleRow;
	}
}

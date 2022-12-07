package thePackage;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public List<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		if (matrix.length == 0 || matrix[0].length == 0)
			return result;
		
		int start = 0;
		int total = matrix.length * matrix[0].length;
		
		int x = 0;
		int xMin = 0;
		int xMax = matrix.length;
		
		int y = 0;
		int yMin = 1;
		int yMax = matrix[0].length;
		
		while (start < total) {
			while (start < total && x <= xMax) {
				result.add(matrix[y][x++]);
				start++;
			}
			x--;
			y++;
			while (start < total && y <= yMax) {
				result.add(matrix[y++][x]);
				start++;
			}
			x--;
			y--;
			while (start < total && x >= xMin) {
				result.add(matrix[y][x--]);
				start++;
			}
			x++;
			y--;
			while (start < total && y >= yMin) {
				result.add(matrix[y--][x]);
				start++;
			}
			xMax--;
			yMax--;
			xMin++;
			yMin++;
			x = xMin;
			y = yMin;
		}
		
		return result;
	}
}

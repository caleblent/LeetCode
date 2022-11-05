package thePackage;

import java.util.ArrayList;

public class ReshapeTheMatrix {

	public static void main(String[] args) {
		int[][] test1 = { { 1, 2 }, { 3, 4 } };

		printInt(matrixReshape(test1, 4, 4));
	}

	public static int[][] matrixReshape(int[][] mat, int r, int c) {
		ArrayList<Integer> data = addData(mat);
//		System.out.println("data length:" + data.size());

		int divisor = data.size() / r;
		if (data.size() != r * c)
			return mat;
		int[][] reshaped = new int[r][c];
		int runningIndex = 0;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
//				System.out.println("i:" + i + " j:" + j + " runningIndex:" + runningIndex);
				reshaped[i][j] = data.get(runningIndex);
				runningIndex++;
			}
		}

		return reshaped;
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
}

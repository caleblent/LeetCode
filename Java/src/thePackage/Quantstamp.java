package thePackage;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;

public class Quantstamp {
	/**
	 * {{0,1,2,3},{4,5,6,7},{8,9,10,11},{12,13,14,15}}
	 * {{0,0,0,0},{0,5,6,7},{0,9,10,11},{0,13,14,15}}
	 * 
	 * {{2,0,2},{3,3,0},{4,4,5}}
	 * {{0,0,0},{0,0,0},{4,0,0}}
	 */
	
	public void solution(double[][] arr) throws InputMismatchException {
		if (arr == null)
			throw new InputMismatchException("array cannot be null");
		if (arr.length == 0)
			throw new InputMismatchException("array must be a rectangular M x N array");
		
		int length = arr[0].length;
		// iterate thru array, flag the first row/col with a 0 if the whole row/col must be zeroed
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].length == length) {
				for (int j = 0; j < arr[i].length; j++) {
					if(arr[i][j] == 0) {
						arr[0][j] = 0;
						arr[i][0] = 0;
					}
				}
			} else {
				throw new InputMismatchException("array must be a rectangular M x N array");
			}
		}
		
		// go thru the first row and zero out each column that needs it
		for (int i = 0; i < arr[0].length; i++) {
			if (arr[0][i] == 0) {
				for (int j = 0; j < arr.length; j++) {
					arr[j][i] = 0;
				}
			}
		}
		
		// go thru the first column and zero out each row that needs it
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][0] == 0) {
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = 0;
				}
			}
		}
	}
	
	public void func(double[][] arr) throws InputMismatchException {
		if (arr == null)
			throw new InputMismatchException("array cannot be null");
		if (arr.length == 0)
			throw new InputMismatchException("array must be a rectangular M x N array");
		
		HashSet<Integer> rows = new HashSet<Integer>();
		HashSet<Integer> cols = new HashSet<Integer>();
		int length = arr[0].length;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].length == length) {
				for (int j = 0; j < arr[i].length; j++) {
					if(arr[i][j] == 0) {
						rows.add(i);
						cols.add(j);
						break;
					}
				}
			} else {
				throw new InputMismatchException("array must be a rectangular M x N array");
			}
			
		}
		
		Iterator<Integer> iter = rows.iterator();
		for (Integer row : rows) {
			zeroOutRow(arr, iter.next());
		}
		iter = cols.iterator();
		for (Integer col : cols) {
			zeroOutColumn(arr, iter.next());
		}
	}
	
	public void zeroOutRow(double[][] arr, int row) {
		
	}
	
	public void zeroOutColumn(double[][] arr, int col) {
		
	}
	
//	public double[][] copyArray(double[][] arr) {
//		double[][] copy = new double[arr.length][arr[0].length];
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr[i].length; j++) {
//				copy[i][j] = arr[i][j];
//			}
//		}
//		return copy;
//	}
	
	
}

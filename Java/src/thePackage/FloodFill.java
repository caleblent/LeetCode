package thePackage;

import java.util.ArrayList;

public class FloodFill {
	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//		int[][] ret = new int[image.length][image[0].length];
		
		ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
		
		int rows = image.length;
		int columns = image[0].length;
		
		// middle
		coordinates.add(new Coordinate(sr, sc));
		
		// top
//		if (sr-1 >= 0) {
			if (image[sr][sc] == image[(sr-1)%rows][sc]) {
				// add top to list
				coordinates.add(new Coordinate((sr-1)%rows, sc));
				
				// top-top
//				if (sr-2 >= 0) {
					if (image[(sr-1)%rows][sc] == image[(sr-2)%rows][sc]) {
						coordinates.add(new Coordinate((sr-2)%rows, sc));
					}
//				}
				
				// top-right
//				if (sc+1 < columns) {
					if (image[(sr-1)%rows][sc] == image[(sr-1)%rows][(sc+1)%columns]) {
						coordinates.add(new Coordinate((sr-1)%rows, (sc+1)%columns));
					}
//				}
				
				// top-bottom
				// gets skipped because it's just the middle pixel (already added)
				
				// top-left
//				if (sc-1 >= 0) {
					if (image[(sr-1)%rows][sc] == image[(sr-1)%rows][(sc-1)%columns]) {
						coordinates.add(new Coordinate((sr-1)%rows, (sc-1)%columns));
					}
//				}
			}
//		}
		
		// right
//		if (sc+1 < image[0].length) {
			if (image[sr][sc] == image[sr][(sc+1)%columns]) {
				// add right to list
				coordinates.add(new Coordinate(sr, (sc+1)%columns));
				
				// right-top
//				if (sr-1 >= 0) {
					if (image[sr][(sc+1)%columns] == image[(sr-1)%rows][(sc+1)%columns]) {
						coordinates.add(new Coordinate((sr-1)%rows, (sc+1)%columns));
					}
//				}
				
				// right-right
//				if (sc+2 < columns) {
					if (image[sr][(sc+1)%columns] == image[sr][(sc+2)%columns]) {
						coordinates.add(new Coordinate(sr, (sc+2)%columns));
					}
//				}
				
				// right-bottom
//				if (sr+1 < rows) {
					if (image[sr][(sc+1)%columns] == image[(sr+1)%rows][(sc+1)%columns]) {
						coordinates.add(new Coordinate((sr+1)%rows, (sc+1)%columns));
					}
//				}
				
				// right-left
				// gets skipped because it's just the middle pixel (already added)
			}
//		}
		
		// bottom
//		if (sr+1 < image.length) {
			if (image[sr][sc] == image[(sr+1)%rows][sc]) {
				// add bottom to list
				coordinates.add(new Coordinate((sr+1)%rows, sc));
				
				// bottom-top
				// gets skipped because it's just the middle pixel (already added)
				
				// bottom-right
//				if (sc+1 < columns) {
					if (image[(sr+1)%rows][sc] == image[(sr+1)%rows][(sc+1)%columns]) {
						coordinates.add(new Coordinate((sr+1)%rows, (sc+1)%columns));
					}
//				}
				
				// bottom-bottom
//				if (sr+2 < rows) {
					if (image[(sr+1)%rows][sc] == image[(sr+2)%rows][sc]) {
						coordinates.add(new Coordinate((sr-2)%rows, sc));
					}
//				}
				
				// bottom-left
//				if (sc-1 >= 0) {
					if (image[(sr+1)%rows][sc] == image[(sr+1)%rows][(sc-1)%columns]) {
						coordinates.add(new Coordinate((sr+1)%rows, (sc-1)%columns));
					}
//				}
			}
//		}
		
		// left
//		if (sc-1 >= 0) {
			if (image[sr][sc] == image[sr][(sc-1)%columns]) {
				// add left to list
				coordinates.add(new Coordinate(sr, (sc-1)%columns));
				
				// left-top
//				if (sr-1 >= 0) {
					if (image[sr][(sc+1)%columns] == image[(sr-1)%rows][(sc-1)%columns]) {
						coordinates.add(new Coordinate((sr-1)%rows, (sc-1)%columns));
					}
//				}
				
				// left-right
				// gets skipped because it's just the middle pixel (already added)
				
				// left-bottom
//				if (sr+1 < rows) {
					if (image[sr][(sc-1)%columns] == image[(sr+1)%rows][(sc-1)%columns]) {
						coordinates.add(new Coordinate((sr+1)%rows, (sc-1)%columns));
					}
//				}
				
				// left-left
//				if (sc-2 >= 0) {
					if (image[sr][(sc-1)%columns] == image[sr][(sc-2)%columns]) {
						coordinates.add(new Coordinate(sr, (sc-2)%columns));
					}
//				}
			}
//		}
		
		// recolor every pixel contained in the coordinates list
		for (int i = 0; i < coordinates.size(); i++) {
			image[coordinates.get(i).row][coordinates.get(i).column] = color;
		}
		
		return image;
	}
	
	class Coordinate {
		int row;
		int column;
		Coordinate(int row, int column) { this.row = row; this.column = column; }
	}
}

package Chap7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextToMatrix {
	
	// Reads a file and returns matrix contained in the file as integer
	// values.
	public static int[][] readFile(String path) throws IOException {
		int[][] matrix = null;
		int rowIndex = 0;
		String line = null;
		FileReader fileReader = new FileReader(path);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		while ((line = bufferedReader.readLine()) != null) {
			if (! line.isEmpty()) {
				String[] row = line.split("\t");
				int nRows = row.length;
				if (rowIndex == 0) {
					matrix = new int[nRows][nRows];
				}
				for (int i = 0; i < nRows; i++) {
					matrix[rowIndex][i] = Integer.valueOf(row[i]);
				}
				rowIndex++;
			}
		}
		bufferedReader.close();
		return matrix;
	}
	
	// Prints a matrix of integer values.
	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
				System.out.print("  ");
			}
			System.out.println();
		}
	}
	

	public static void main(String[] args) throws IOException {
		int[][] matrix = readFile("./src/Luna.txt");
		printMatrix(matrix);
	}

}

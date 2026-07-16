package Chap7;

import java.io.IOException;
import java.util.ArrayList;

public class MagicSquare {
	
	// Checks if all the elements inside a one dimensional array are equal.
	public static boolean checkIfAllElementsEqual(int[] oneDimArray) {
		int valueToCheck = oneDimArray[0];
		for (Integer value : oneDimArray) {
			if (value != valueToCheck) {
				return false;
			}
		}
		return true;
	}
	
	// Checks if all the rows in a magic square sum to the same value.
	public static boolean checkMagicSquareRow(int[][] matrix) {
		int rowLength = matrix.length;
		int[] allSums = new int[rowLength];
		for (int i = 0; i < rowLength; i++) {
			int rowSum = 0;
			for (int j = 0; j < rowLength; j++) {
				rowSum += matrix[i][j];
			}
			allSums[i] = rowSum;
		}
		if (checkIfAllElementsEqual(allSums)) {
			System.out.println("Row sum : " + allSums[0]);
			return true;
		}
		System.out.println("Sorry, all the rows do not sum to the same value.");
		return false;
	}

	// Checks if all the columns in a magic square sum to the same value.
	public static boolean checkMagicSquareColumn(int[][] matrix) {
		int rowLength = matrix.length;
		int[] allSums = new int[rowLength];
		for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < rowLength; j++) {
				allSums[j] += matrix[i][j];
			}
		}
		if (checkIfAllElementsEqual(allSums)) {
			System.out.println("Column sum : " + allSums[0]);
			return true;
		}
		System.out.println("Sorry, all the columns do not sum to the same value.");
		return false;
	}
	
	// Checks if all the diagonals in a magic square sum to the same value.
	public static boolean checkMagicSquareDiagonals(int[][] matrix) {
		int rowLength = matrix.length;
		int mainDiagonalSum = 0;
		int secondDiagonalSum = 0;
		for (int i = 0; i < rowLength; i++) {
			mainDiagonalSum += matrix[i][i];
			secondDiagonalSum += matrix[i][rowLength - i - 1];
		}
		if (mainDiagonalSum == secondDiagonalSum) {
			System.out.println("Diagonals' sum : " + mainDiagonalSum);
			return true;
		}
		System.out.println("Sorry, the two diagonals do not sum up to the same value.");
		System.out.println("Main diagonal sum " + mainDiagonalSum + "; "
				+ "Second diagonal sum : " + secondDiagonalSum + ".");
		return false;
	}
	
	// Checks if all the magic square sides (rows, columns, diagonals)
	// sum to one.
	public static boolean checkMagicSquareComplete(int[][] matrix) {
		if ((checkMagicSquareRow(matrix)) && 
				(checkMagicSquareColumn(matrix)) &&
				checkMagicSquareDiagonals(matrix)) {
			System.out.println("All the rows, all the columns, "
					+ "and all the diagonals sum up to the same value.");
			return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) throws IOException {
		ArrayList<int[][]> tensor = new ArrayList<int[][]>();
		
		int[][] lunaMatrix = TextToMatrix.readFile("./src/Luna.txt");
		int[][] mercuryMatrix = TextToMatrix.readFile("./src/Mercury.txt");
		int[][] lunaLeadingDiagonal = TextToMatrix.readFile("./src/Luna_leading_diag.txt");
		int[][] lunaNonLeadingDiagonal = TextToMatrix.readFile("./src/Luna_non_leading_diag.txt");
		
		tensor.add(lunaMatrix);
		tensor.add(mercuryMatrix);
		tensor.add(lunaLeadingDiagonal);
		tensor.add(lunaNonLeadingDiagonal);
		
		for (int[][] matrix : tensor) {
			TextToMatrix.printMatrix(matrix);
			System.out.println();
			System.out.println(checkMagicSquareComplete(matrix));
			System.out.println("\n");
		}
	}

}

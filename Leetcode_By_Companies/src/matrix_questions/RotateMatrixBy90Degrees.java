package matrix_questions;
//import java.util.Scanner;

//Matrix will always be NxN
/*
 * Time complexity : O(N^2), is a complexity given by two inserted loops.
 * Space complexity : O(1)
 */

public class RotateMatrixBy90Degrees {

	public static void clockwiseRotation(int[][] matrix) {
		//Approach = First swap all the values bottom to up columnwise and then take transpose
		
		//for swapping from bottom to up, we need to go columnwise.
		for(int col = 0; col < matrix[0].length; col++) {
			int rowFromTop = 0;
			int rowFromBottom = matrix.length - 1;
			
			while(rowFromTop < rowFromBottom) {
				int temp = matrix[rowFromBottom][col];
				matrix[rowFromBottom][col] = matrix[rowFromTop][col];
				matrix[rowFromTop][col] = temp;
				rowFromTop++;
				rowFromBottom--;
			}
		}
		
		//transpose means [row][col] to [col][row]. Diagonal elements won't change in transpose as row,col are same
		//we need to only swap values on the either side if diagonal. Don't include diagonal elements.
		//So use row number as the anchor at the start of each array and use the col + 1 to move ahead in that array
		//which will simulate, going across different columns in the same row, thus achieving the access of only
		//values on the upper side of diagonal.
		transposeOf2DArray(matrix);
		
		System.out.println("Clockwise rotation 90 degree = ");
		print2DArray(matrix);
	}
	
	public static void anticlockwiseRotation(int[][] matrix) {
		//Approach, first swap elements left to right rowwise, then take transpose.
		
		//Swapping values across rows.
		for(int row = 0; row < matrix.length; row++) {
			int leftColumn = 0;
			int rightColumn = matrix[0].length - 1;
			
			while(leftColumn < rightColumn) {
				int temp = matrix[row][leftColumn];
				matrix[row][leftColumn] = matrix[row][rightColumn];
				matrix[row][rightColumn] = temp;
				leftColumn++;
				rightColumn--;
			}
		}
		
		//take transpose now
		transposeOf2DArray(matrix);
		
		System.out.println("Anti-clockwise rotation 90 degree = ");
		print2DArray(matrix);
	}
	
	public static void transposeOf2DArray(int[][] matrix) {
		for(int row = 0; row < matrix.length; row++) {
			for(int col = row + 1; col < matrix[0].length; col++) {
				//swap values, [row][col] to [col][row]
				int temp = matrix[row][col];
				matrix[row][col] = matrix[col][row];
				matrix[col][row] = temp;
			}
		}
	}
	
	public static void print2DArray(int[][] matrix) {
		for(int row = 0; row < matrix.length; row++) {
			if(row != 0)
				System.out.println();
			for(int col = 0; col < matrix[0].length; col++)
				System.out.print(matrix[row][col] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {	
		int[][] matrix = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		}; //[row][column]
		
		clockwiseRotation(matrix);
		
		int[][] matrix2 = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		}; //[row][column]
		anticlockwiseRotation(matrix2);
		
		/*reference code for entering elements into 2D array
		 * int[][] matrix = new int[4][4]; //[row][column]
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter elements = ");
		for(int row = 0; row < matrix.length; row++)
			for(int col = 0; col < matrix[0].length; col++)
				matrix[row][col] = sc.nextInt();
		
		sc.close();
		
		for(int row = 0; row < matrix.length; row++) {
			if(row != 0)
				System.out.println();
			for(int col = 0; col < matrix[0].length; col++)
				System.out.print(matrix[row][col] + " ");
		}	
		*/
	}//end main

}

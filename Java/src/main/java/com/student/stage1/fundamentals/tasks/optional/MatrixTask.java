package com.student.stage1.fundamentals.tasks.optional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


/**
 * Task: "Задание. Ввести с консоли n - размерность матрицы a [n] [n]. 
 * 		  Задать значения элементов матрицы в интервале значений 
 * 		  от -M до M с помощью генератора случайных чисел (класс Random).
 * 
 *		  1. Упорядочить строки (столбцы) матрицы в порядке возрастания 
 *		     значений элементов k-го столбца (строки).
 *
 *		  2. Найти и вывести наибольшее число возрастающих (убывающих) 
 *			 элементов матрицы, идущих подряд.
 *
 */

public class MatrixTask {
	
	public static void main(String[] args) {
		
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			MatrixTask task = new MatrixTask();
			int[][] matrix = task.createSquareMatrix(reader);
			task.fillMatrixWithRandomNumbers(matrix);
				
			System.out.println("Matrix before sorting: ");
			printMatrix(matrix);
				
			int column = task.askNumber(matrix[0].length - 1, reader);
			task.orderMatrixRowsByRisingOfColumnValues(matrix, column);
				
			System.out.printf("Matrix after sorting by %d column: %n", column);
			printMatrix(matrix);
			
			int longestSequence = task.findLongestRisingSequence(matrix);
			System.out.printf("The longest rising sequence of already ordered matrix is: %d%n", 
							  longestSequence);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
	public int findLongestRisingSequence(int[][] matrix) {
		int currentSequence = 1;
		int compareTemp = Integer.MAX_VALUE;
		int result = 1;
		int previousElement;
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				previousElement = (j == 0) ? compareTemp : matrix[i][j-1];
				
				if (matrix[i][j] > previousElement) {
					currentSequence++;
					result = (currentSequence > result) ? currentSequence : result; 
				} else {
					currentSequence = 1;
				}
				
				if (j == matrix[i].length-1) {
					compareTemp = matrix[i][j];
				}
			}
		}
		
		return result;
	}


	private int askNumber(int bound, BufferedReader reader) throws IOException {
		int column = 0;
		
		System.out.println("Enter the column number to sort by "
							+ "(from 0 to " + bound + " including): ");
		String response = reader.readLine();
		column = Integer.parseInt(response);
		
		return (column <= bound && column >= 0) ? column : 0;
	}


	public void orderMatrixRowsByRisingOfColumnValues(int[][] matrix, int column) {
		boolean isMatrixChanged = true;
		
		while(isMatrixChanged) {
			isMatrixChanged = false;
			
			for (int i = 0; i < matrix.length-1; i++) {
				if (matrix[i][column] > matrix[i+1][column]) {
					int[] temp = matrix[i+1];
					matrix[i+1] = matrix[i];
					matrix[i] = temp;
					isMatrixChanged = true;
				}
			}
		}
	}
	
	
	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	public void fillMatrixWithRandomNumbers(int[][] matrix) {
		Random rnd = new Random();
		final int M = rnd.nextInt(100) + 50; //value interval will be between -M and M
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = -M + rnd.nextInt(2 * M);
			}
		}
	}
	
	
	public int[][] createSquareMatrix(BufferedReader reader) throws IOException {
		int n = 0;
			
		while (true) {
			System.out.println("Enter the dimension of the matrix: ");
			String response = reader.readLine();
			n = Integer.parseInt(response);
				
			if (n >= 2) {
				break;
			}
			System.out.println("The square matrix can't have dimension less then 2. Try again");
		}
		
		return new int[n][n];
	}
}

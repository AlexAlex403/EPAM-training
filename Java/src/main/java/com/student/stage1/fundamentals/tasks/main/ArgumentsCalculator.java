package com.student.stage1.fundamentals.tasks.main;

import java.math.BigInteger;

/**
 * Task: "4. Ввести целые числа как аргументы командной строки, 
 * 			 подсчитать их сумму (произведение) 
 * 			 и вывести результат на консоль."
 *
 */

public class ArgumentsCalculator {

	public static void main(String[] args) {
		if (args == null || args.length == 0) {
			System.err.println("There is no arguments to calculate...");
			System.exit(0);
		}
		
		ArgumentsCalculator calc = new ArgumentsCalculator();
		int[] numbers = calc.convertStringArrayToIntArray(args);
		
		BigInteger sum = calc.sumArrayItems(numbers);
		System.out.printf("Sum of your numbers is: %d%n", sum);
		
		BigInteger multiplication = calc.multiplyArrayItems(numbers);
		System.out.printf("Multiplication of your numbers is: %d%n", multiplication);
	}
	
	
	public BigInteger multiplyArrayItems(int[] arr) {
		if (arr.length == 1) {
			System.out.println("Can't multiply your array because it contains only one number");
			return null;
		}
		
		BigInteger result = BigInteger.ONE;
		
		for (int a : arr) {
			result = result.multiply(BigInteger.valueOf(a));
		}
		
		return result;
	}
	
	
	public BigInteger sumArrayItems(int[] arr) {
		BigInteger result = BigInteger.ZERO;
		
		for (int a : arr) {
			result = result.add(BigInteger.valueOf(a));
		}
		
		return result;
	}

	
	public int[] convertStringArrayToIntArray(String[] arr) {
		int[] result = new int[arr.length];
		
		for (int i = 0; i < result.length; i++) {
			
			try {
				result[i] = Integer.parseInt(arr[i]);
			} catch (Exception e) {
				System.err.println("There is not an integer number in your arguments");
				System.exit(1);
			}
		}
		
		return result;
	}
}

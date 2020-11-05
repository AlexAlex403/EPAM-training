package com.student.stage1.fundamentals.tasks.main;

/**
 * Task: "2. Отобразить в окне консоли 
 * 			 командной строки в обратном порядке."
 *
 */

public class ReverseArguments {

	public static void main(String[] args) {
		printArrayReverse(args);
	}

	
	public static void printArrayReverse(String[] args) {
		if (args.length == 0) {
			System.out.println("There is no arguments...");
			return;
		}
		
		for (int i = 1; i <= args.length; i++) {
			System.out.print(args[args.length - i] + " ");
		}
	}
}

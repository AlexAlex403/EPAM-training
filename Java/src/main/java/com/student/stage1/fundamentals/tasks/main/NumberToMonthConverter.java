package com.student.stage1.fundamentals.tasks.main;


import java.time.Month;
import java.util.Scanner;

/**
 * Task: "5. Ввести число от 1 до 12. 
 * 			 Вывести на консоль название месяца, соответствующего 
 * 			 данному числу. Осуществить проверку корректности ввода чисел." 
 *
 */
public class NumberToMonthConverter {

	public static void main(String[] args) {
		int monthNumber = getMonthNumberFromUser();
		System.out.printf("The month corresponding to your number is: %s%n", 
						  convertIntNumberToMonthName(monthNumber));
	}
	
	
	public static String convertIntNumberToMonthName(int monthNumber) {
		return Month.of(monthNumber).name();
	}
	

	public static int getMonthNumberFromUser() {
		int monthNumber = 0;
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("Enter month number (from 1 to 12): ");
			monthNumber = sc.nextInt();
		
			if (monthNumber >= 1 && monthNumber <= 12) {
				break;
			}
			
			System.out.println("There is no month with such a number. Try again..");
		}
		
		sc.close();
		
		return monthNumber;
	}
}

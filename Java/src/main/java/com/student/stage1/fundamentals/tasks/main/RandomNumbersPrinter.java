package com.student.stage1.fundamentals.tasks.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Task: "3. Вывести заданное количество случайных 
 * 			 чисел с переходом и без перехода на новую строку"
 *
 */

public class RandomNumbersPrinter {
	
	private boolean isNewLineNeed = false;
	
	public static void main(String[] args) {
		RandomNumbersPrinter printer = new RandomNumbersPrinter();
		printer.printRandomNumbers();
	}

	
	public void printRandomNumbers() {
		int count = 0;
		String request = "How many random numbers do you want to print? "
					   + "Enter a quantity: ";
		
		try (BufferedReader reader = new BufferedReader(
										new InputStreamReader(System.in))) {
			
			count = Integer.parseInt(askUser(request, reader));
			
			request = "Do you want to add a new line after each number?" + 
					  " (Default is \"N\") Type Y or N: ";
			
			String answer = askUser(request, reader);
			isNewLineNeed = "y".equalsIgnoreCase(answer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Random rnd = new Random();
		for (int i = 0; i < count; i++) {
			System.out.print(rnd.nextInt(100) + " "); //bound of the number is 100
			if (isNewLineNeed) {
				System.out.println();
			}
		}
	}
	
	
	public String askUser(String message, BufferedReader reader) throws IOException {
		String answer = "";
		System.out.println(message);
		answer = reader.readLine();
		return answer;
	}
}

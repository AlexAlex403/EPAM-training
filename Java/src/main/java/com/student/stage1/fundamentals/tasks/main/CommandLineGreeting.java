package com.student.stage1.fundamentals.tasks.main;

/**
 * Task: "1. Приветствовать любого пользователя при вводе 
 * 			 его имени через командную строку."
 * 
 */

public class CommandLineGreeting {

	public static void main(String[] args) {
		sayGreetings(args);
	}

	
	public static void sayGreetings(String[] args) {
		String hello = "Hello, %s!";
		String name = "anonymous";
		
		if (args.length > 0) {
			StringBuilder sb = new StringBuilder();
			
			for (String s : args) {
				sb.append(s).append(" ");
			}
			
			sb.deleteCharAt(sb.length()-1);
			name = sb.toString();
		}
		
		System.out.printf(hello + "%n", name);
	}
}

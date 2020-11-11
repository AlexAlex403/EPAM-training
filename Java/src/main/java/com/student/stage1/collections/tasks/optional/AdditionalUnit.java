package com.student.stage1.collections.tasks.optional;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 1. Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.
 * 8. Задан файл с текстом на английском языке. Выделить все различные слова. 
 *    Слова, отличающиеся только регистром букв, считать одинаковыми. Использовать класс HashSet.
 * 
 */

public class AdditionalUnit {
	private static final String FILE_NAME = "src/main/resources/fileForCollectionsOptionalTask.txt";

	public static void main(String[] args) {
		List<String> lines = getListOfAllLinesFromTextFile(FILE_NAME);
		
		String destinationFile = "src/main/resources/reverseList.txt";
		writeListOfStringsIntoFileInReverseOrder(destinationFile, lines);
		
		Set<String> words = getAllUniqueWordsFromText(lines);
		System.out.println("All the unique words from the text: \n" + words);
		
	}

	
	public static List<String> getListOfAllLinesFromTextFile(String fileName) {
		List<String> lines = null;
		try {
			lines = Files.readAllLines(Paths.get(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
	
	public static void writeListOfStringsIntoFileInReverseOrder(String fileName, List<String> lines) {
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName))) {
			for (int i = lines.size()-1; i >= 0; i--) {
				writer.write(lines.get(i));
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Set<String> getAllUniqueWordsFromText(List<String> lines) {
		Set<String> words = new HashSet<>();
		StringBuilder stringBuilder = new StringBuilder();
		for (String s : lines) {
			if (s == null || s.isEmpty()) {
				continue;
			}
			stringBuilder.append(s).append(" ");
		}
		String text = stringBuilder.toString();
		text = text.replaceAll("\\p{P}", "").trim().toLowerCase();
		words.addAll(Arrays.asList(text.split("\\s")));
		return words;
	}
}

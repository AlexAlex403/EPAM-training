package com.student.stage1.classes.tasks.main;

/*
 * Создать классы, спецификации которых приведены ниже. 
 * Определить конструкторы и методы setТип(), getТип(), toString(). 
 * Определить дополнительно методы в классе, создающем массив объектов. 
 * Задать критерий выбора данных и вывести эти данные на консоль. 
 * В каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.
 *
 * 5. Book: id, Название, Автор (ы), Издательство, Год издания, 
 *    Количество страниц, Цена, Тип переплета.
 *    Создать массив объектов. Вывести:
 *     a) список книг заданного автора;
 *     b) список книг, выпущенных заданным издательством;
 *     c) список книг, выпущенных после заданного года.
 * 
 */

public class Main {
		
	public static void main(String[] args) {
		Book[] books = BookService.createBooks();
		
		BookService.printBooksByAuthor(books, new Author("Александр", "Сергеевич", "Пушкин"));
		System.out.println("\n");
		BookService.printBooksByAuthor(books, new Author("Joanne", "Rowling"));
		System.out.println("\n");
		BookService.printBooksByPublishingHouse(books, "АСТ");
		System.out.println("\n");
		BookService.printBooksPublishedAfterYear(books, 2006);
		
	}

}

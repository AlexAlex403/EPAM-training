package com.student.stage1.classes.tasks.main;

import java.util.List;

public class BookService {
	
	public static Book[] createBooks() {
		Author pushkin = new Author("Александр", "Сергеевич", "Пушкин");
		Author rowling = new Author("Joanne", "Rowling");
		Author tolkien = new Author("John Ronald Reuel", "Tolkien");
		Author strugatskyA = new Author("Аркадий", "Натанович", "Стругацкий");
		Author strugatskyB = new Author("Борис", "Натанович", "Стругацкий");
		Author lukianenko = new Author("Сергей", "Васильевич", "Лукьяненко");
		Author london = new Author("Jack", "London");
		
		String publisher1 = "Эксмо";
		String publisher2 = "АСТ";
		String publisher3 = "Bloomsbury";
		
		Book b1 = new Book("Сказка о рыбаке и рыбке", pushkin);
		Book b2 = new Book("Евгений Онегин", publisher1, 2001, pushkin);
		Book b3 = new Book("Harry Potter and the Philosopher's Stone", publisher3, 2010, 
							342, 100.0, Bookbinding.HARDCOVER, rowling);
		Book b4 = new Book("Harry Potter 2: Harry Potter and the Chamber of Secrets", 
							publisher3, 2012, rowling);
		Book b5 = new Book("The Lord of the Rings", tolkien);
		Book b6 = new Book("Трудно быть богом", publisher2, 2007, strugatskyA, strugatskyB);
		Book b7 = new Book("Пикник на обочине", publisher2, 2009, strugatskyA, strugatskyB);
		Book b8 = new Book("Черновик", publisher2, 2014, 352, 95.0, 
							Bookbinding.THERMALLY_ACTIVATED, lukianenko);
		Book b9 = new Book("Чистовик", publisher1, 2016, lukianenko);
		Book b10 = new Book("White Fang", london);
		Book b11 = new Book("Martin Eden", publisher3, 2008, london);
		
		return new Book[] {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11};
	}
	
	
	public static void printBooksByAuthor(Book[] books, Author author) {
		if (books == null || author == null) {
			throw new IllegalArgumentException("Params can't be Null");
		}
		
		List<Author> authors;
		for (Book book : books) {
			authors = book.getAuthors();
			for (Author bookAuthor : authors) {
				if (author.equals(bookAuthor)) {
					System.out.println(book);
					break;
				}
			}
		}
	}
	
	public static void printBooksByPublishingHouse(Book[] books, String pubHouse) {
		if (books == null || pubHouse == null) {
			throw new IllegalArgumentException("Params can't be Null");
		}
		
		for (Book book : books) {
			if (pubHouse.equalsIgnoreCase(book.getPublishingHouse())) {
				System.out.println(book);
			}
		}
	}
	
	public static void printBooksPublishedAfterYear(Book[] books, int year) {
		if (books == null) {
			throw new IllegalArgumentException("Params can't be Null");
		}
		
		for (Book book : books) {
			if (book.getPublishingYear() > year) {
				System.out.println(book);
			}
		}
	}
}

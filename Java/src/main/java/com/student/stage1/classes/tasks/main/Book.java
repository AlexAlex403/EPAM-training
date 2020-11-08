package com.student.stage1.classes.tasks.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Book {
	private static int idCounter = 1;
	
	private int bookId = idCounter++;
	private String title;
	private List<Author> authors;
	private String publishingHouse;
	private int publishingYear;
	private int pages;
	private Double price;
	private Bookbinding bookbinding;
	private boolean isInRussian;
	
	public Book(String title) {
		if (title == null || title.isEmpty()) {
			throw new IllegalArgumentException("Title can't be empty or be absent");
		}
		this.title = title;
		isInRussian = title.charAt(0) > 122;
	}

	public Book(String title, Author... authors) {
		this(title);
		if (authors != null) {
			this.authors = new ArrayList<>();
			this.authors.addAll(Arrays.asList(authors));
		}
	}
	
	public Book(String title, String publishingHouse, int publishingYear, Author... authors) {
		this(title, authors);
		this.publishingHouse = publishingHouse;
		this.publishingYear = publishingYear;
	}

	public Book(String title, String publishingHouse, int publishingYear, int pages, 
			    Double price, Bookbinding bookbinding, Author... authors) {
		this(title, authors);
		this.publishingHouse = publishingHouse;
		this.publishingYear = publishingYear;
		this.pages = pages;
		this.price = price;
		this.bookbinding = bookbinding;
	}

	
	//getters & setters
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		if (title == null || title.isEmpty()) {
			throw new IllegalArgumentException("Title can't be empty or be absent");
		}
		this.title = title;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	public String getPublishingHouse() {
		return publishingHouse;
	}
	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}
	public int getPublishingYear() {
		return publishingYear;
	}
	public void setPublishingYear(int publishingYear) {
		this.publishingYear = publishingYear;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Bookbinding getBookbinding() {
		return bookbinding;
	}
	public void setBookbinding(Bookbinding bookbinding) {
		this.bookbinding = bookbinding;
	}
	public int getBookId() {
		return bookId;
	}
	public boolean isInRussian() {
		return isInRussian;
	}
	public void setInRussian(boolean isInRussian) {
		this.isInRussian = isInRussian;
	}

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\"").append(title).append("\"");
		if (authors != null && !authors.isEmpty()) {
			sb.append(isInRussian ? ", автор(ы) -" : ", written by");
			for (Author a : authors) {
				sb.append(" ").append(a).append(",");
			}
			sb.deleteCharAt(sb.length()-1);
		}
		if (publishingHouse != null && !publishingHouse.isEmpty()) {
			sb.append(isInRussian ? " (издательство " : " (published by ");
			sb.append(publishingHouse);
			if (publishingYear > 0) {
				sb.append(", ").append(publishingYear);
			}
			sb.append(")");
		}
		
		return String.format("ID%d. %s", bookId, sb.toString());
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result = prime * result + bookId;
		result = prime * result + ((bookbinding == null) ? 0 : bookbinding.hashCode());
		result = prime * result + pages;
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((publishingHouse == null) ? 0 : publishingHouse.hashCode());
		result = prime * result + publishingYear;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		
		return bookId == other.bookId;
	}
	
}

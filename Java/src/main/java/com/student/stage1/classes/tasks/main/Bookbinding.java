package com.student.stage1.classes.tasks.main;

public enum Bookbinding {
	HARDCOVER("hardcover binding"),
	THERMALLY_ACTIVATED("thermally activated binding"),
	STITCHED("stitched binding"),
	MODERN_HAND("modern hand binding"),
	PAPERBACK("paperback binding");
	
	private String description;

	private Bookbinding(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
}

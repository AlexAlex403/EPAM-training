package com.student.stage1.collections.tasks.main.type;

public enum FuelType {
	PETROL_98(5.90),
	PETROL_95(5.50),
	PETROL_92(5.30),
	DIESEL(5.20),
	GAS(4.0);
	
	private double price;

	private FuelType(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}

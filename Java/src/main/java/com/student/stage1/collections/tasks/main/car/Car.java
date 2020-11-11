package com.student.stage1.collections.tasks.main.car;

import java.util.Objects;

import com.student.stage1.collections.tasks.main.type.FuelType;

public abstract class Car {
	private String model;
	private int doors;
	private int maxSpeed;
	private double fuelConsumption;
	private int price;
	private FuelType fuelType;
	
	public Car(String model, int doors, int maxSpeed, double fuelConsumption, int price, FuelType fuelType) {
		this.model = model;
		this.doors = doors;
		this.maxSpeed = maxSpeed;
		this.fuelConsumption = fuelConsumption;
		this.price = price;
		this.fuelType = fuelType;
	}
	
	public Car(String model, int maxSpeed, double fuelConsumption, int price, FuelType fuelType) {
		this.model = model;
		this.maxSpeed = maxSpeed;
		this.fuelConsumption = fuelConsumption;
		this.price = price;
		this.fuelType = fuelType;
	}

	public Car(String model, int maxSpeed, double fuelConsumption, FuelType fuelType) {
		this(model, 0, maxSpeed, fuelConsumption, 10000, fuelType);
	}

	
	public int getDoors() {
		return doors;
	}
	public void setDoors(int doors) {
		this.doors = doors;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public double getFuelConsumption() {
		return fuelConsumption;
	}
	public void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getModel() {
		return model;
	}
	public FuelType getFuelType() {
		return fuelType;
	}
	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}

	
	@Override
	public String toString() {
		return "Car [model=" + model + ", maxSpeed=" + maxSpeed + ", fuel cost per 100 km =" 
				+ fuelConsumption*fuelType.getPrice() + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(doors, fuelConsumption, maxSpeed, model, price, fuelType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return doors == other.doors && fuelType == other.fuelType
				&& Double.doubleToLongBits(fuelConsumption) == Double.doubleToLongBits(other.fuelConsumption)
				&& maxSpeed == other.maxSpeed && Objects.equals(model, other.model) && price == other.price;
	}

}

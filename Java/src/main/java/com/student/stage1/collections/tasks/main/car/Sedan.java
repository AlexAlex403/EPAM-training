package com.student.stage1.collections.tasks.main.car;

import java.util.Objects;

import com.student.stage1.collections.tasks.main.type.FuelType;


public class Sedan extends Car {
	private int maxBaggageWeight;

	public Sedan(String model, int maxSpeed, double fuelConsumption, int price, int maxBaggageWeight, FuelType fuelType) {
		super(model, 4, maxSpeed, fuelConsumption, price, fuelType);
		this.maxBaggageWeight = maxBaggageWeight;
	}

	
	public int getMaxBaggageWeight() {
		return maxBaggageWeight;
	}
	public void setMaxBaggageWeight(int maxBaggageWeight) {
		this.maxBaggageWeight = maxBaggageWeight;
	}


	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), maxBaggageWeight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sedan other = (Sedan) obj;
		return maxBaggageWeight == other.maxBaggageWeight;
	}

}

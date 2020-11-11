package com.student.stage1.collections.tasks.main.car;

import java.util.Objects;

import com.student.stage1.collections.tasks.main.type.FuelType;
import com.student.stage1.collections.tasks.main.type.LimousineFeature;


public class Limousine extends Car {
	private LimousineFeature limousineFeature;

	public Limousine(String model, int doors, int maxSpeed, double fuelConsumption, int price, 
					 FuelType fuelType, LimousineFeature limousineFeature) {
		super(model, doors, maxSpeed, fuelConsumption, price, fuelType);
		this.limousineFeature = limousineFeature;
	}

	public LimousineFeature getLimousineFeature() {
		return limousineFeature;
	}

	public void setLimousineFeature(LimousineFeature limousineFeature) {
		this.limousineFeature = limousineFeature;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), limousineFeature);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Limousine other = (Limousine) obj;
		return limousineFeature == other.limousineFeature;
	}
	
}

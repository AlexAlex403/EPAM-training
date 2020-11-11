package com.student.stage1.collections.tasks.main.car;

import java.util.Objects;

import com.student.stage1.collections.tasks.main.type.CoupeType;
import com.student.stage1.collections.tasks.main.type.FuelType;


public class Coupe extends Car {
	private CoupeType coupeType;

	public Coupe(String model, int maxSpeed, double fuelConsumption, int price, CoupeType coupeType, FuelType fuelType) {
		super(model, 2, maxSpeed, fuelConsumption, price, fuelType);
		this.coupeType = coupeType;
	}

	public CoupeType getCoupeType() {
		return coupeType;
	}
	public void setCoupeType(CoupeType coupeType) {
		this.coupeType = coupeType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), coupeType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coupe other = (Coupe) obj;
		return coupeType == other.coupeType;
	}
	
}

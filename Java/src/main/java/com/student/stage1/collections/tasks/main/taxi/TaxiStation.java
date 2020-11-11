package com.student.stage1.collections.tasks.main.taxi;

import java.util.Comparator;
import java.util.List;

import com.student.stage1.collections.tasks.main.car.Car;
import com.student.stage1.collections.tasks.main.car.Coupe;
import com.student.stage1.collections.tasks.main.car.Limousine;
import com.student.stage1.collections.tasks.main.car.Sedan;
import com.student.stage1.collections.tasks.main.type.CoupeType;
import com.student.stage1.collections.tasks.main.type.LimousineFeature;


public class TaxiStation {
	private List<Car> cars;

	public TaxiStation(List<Car> cars) {
		this.cars = cars;
	}

	public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	
	public int getAllCarsCost() {
		int cost = 0;
		for (Car car : cars) {
			cost += car.getPrice();
		}
		return cost;
	}
	
	public void sortCarsByFuelCost() {
		cars.sort(new Comparator<Car>() {
			@Override
			public int compare(Car o1, Car o2) {
				return (int) (o1.getFuelConsumption()*o1.getFuelType().getPrice() - 
								o2.getFuelConsumption()*o2.getFuelType().getPrice());
			}
			
		});
	}
	
	public Car getCarWithSpeedMoreThen(int speed) {
		for (Car car : cars) {
			if (car.getMaxSpeed() >= speed) {
				return car;
			}
		}
		return null;
	}
	
	public Sedan getSedanByMinimumBaggageWeight(int minWeight) {
		for (Car car : cars) {
			if (car.getClass().getSimpleName().equals("Sedan")) {
				Sedan sedan = (Sedan) car;
				if (sedan.getMaxBaggageWeight() >= minWeight) {
					return sedan;
				}
			}
		}
		return null;
	}
	
	public Coupe getCoupeByType(CoupeType coupeType) {
		for (Car car : cars) {
			if (car.getClass().getSimpleName().equals("Coupe")) {
				Coupe coupe = (Coupe) car;
				if (coupe.getCoupeType() == coupeType) {
					return coupe;
				}
			}
		}
		return null;
	}
	
	public Limousine getLimousineByFeature(LimousineFeature feature) {
		for (Car car : cars) {
			if (car.getClass().getSimpleName().equals("Limousine")) {
				Limousine limousine = (Limousine) car;
				if (limousine.getLimousineFeature() == feature) {
					return limousine;
				}
			}
		}
		return null;
	}
}

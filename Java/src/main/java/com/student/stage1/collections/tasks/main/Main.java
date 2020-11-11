package com.student.stage1.collections.tasks.main;

import java.util.Arrays;
import java.util.List;

import com.student.stage1.collections.tasks.main.car.Car;
import com.student.stage1.collections.tasks.main.car.Coupe;
import com.student.stage1.collections.tasks.main.car.Limousine;
import com.student.stage1.collections.tasks.main.car.Sedan;
import com.student.stage1.collections.tasks.main.taxi.TaxiStation;
import com.student.stage1.collections.tasks.main.type.CoupeType;
import com.student.stage1.collections.tasks.main.type.FuelType;
import com.student.stage1.collections.tasks.main.type.LimousineFeature;


/*
 * Задание. Создать консольное приложение, удовлетворяющее следующим требованиям:
 * Каждый класс должен иметь отражающее смысл название и информативный состав.
 * Использовать возможности ООП: классы, наследование, полиморфизм, инкапсуляция.
 * Наследование должно применяться только тогда, когда это имеет смысл.
 * При кодировании должны быть использованы соглашения об оформлении кода java code convention.
 * Классы должны быть грамотно разложены по пакетам
 * Консольное меню должно быть минимальным.
 * Для хранения параметров инициализации можно использовать файлы.
 * 
 * 10. Таксопарк. Определить иерархию легковых автомобилей. Создать таксопарк. 
 * Подсчитать стоимость автопарка. Провести сортировку автомобилей парка по расходу топлива. 
 * Найти автомобиль в компании, соответствующий заданному диапазону параметров скорости.
 * 
 */

public class Main {
	private static List<Car> cars = Arrays.asList(
		new Sedan("Skoda Octavia", 170, 7.5, 20000, 200, FuelType.PETROL_92),
		new Sedan("KIA Rio", 180, 8.0, 25000, 220, FuelType.DIESEL),
		new Sedan("Hyundai Solaris", 180, 8.5, 22000, 250, FuelType.GAS),
		new Coupe("Mercedes-Benz SLK", 210, 9.0, 30000, CoupeType.CABRIOLET, FuelType.PETROL_95),
		new Coupe("Aston Martin Vantage", 220, 10.0, 32000, CoupeType.ROADSTER, FuelType.DIESEL),
		new Coupe("Ford Mustang", 250, 12.0, 40000, CoupeType.SPORTCAR, FuelType.PETROL_98),
		new Limousine("Cadillac Escalade", 6, 140, 11.0, 31000, FuelType.DIESEL, LimousineFeature.TINTED_GLASS),
		new Limousine("Lincoln Navigator", 4, 150, 10.5, 33000, FuelType.PETROL_95, LimousineFeature.QUALITY_SOUND)
	);

	public static void main(String[] args) {
		TaxiStation taxiStation = new TaxiStation(cars);
		
		int cost = taxiStation.getAllCarsCost();
		System.out.println("The autopark cost is : " + cost);
		
		taxiStation.sortCarsByFuelCost();
		Car carWithBiggestFuelCost = taxiStation.getCars().get(taxiStation.getCars().size() - 1);
		System.out.println("\nThe car with the biggest fuel cost is : \n" + carWithBiggestFuelCost);
		
		int minSpeedLimit = 200;
		Car carBySpeed = taxiStation.getCarWithSpeedMoreThen(minSpeedLimit);
		System.out.println("\nThe car with max speed more then " + minSpeedLimit + " is: \n" 
							+ carBySpeed);
	}

}

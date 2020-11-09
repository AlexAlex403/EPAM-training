package com.student.stage1.cleancode.aircompany;

import com.student.stage1.cleancode.aircompany.airplane.ExperimentalPlane;
import com.student.stage1.cleancode.aircompany.airplane.MilitaryPlane;
import com.student.stage1.cleancode.aircompany.airplane.PassengerPlane;
import com.student.stage1.cleancode.aircompany.airplane.Plane;
import com.student.stage1.cleancode.aircompany.model.MilitaryType;

import java.util.*;


public class Airport {
	private List<? extends Plane> planes;
	
	public Airport(List<? extends Plane> planes) {
		this.planes = planes;
	}
	
	public List<? extends Plane> getPlanes() {
		return planes;
	}

	public List<PassengerPlane> getPassengerPlanes() {
		List<PassengerPlane> passengerPlanes = new ArrayList<>();
		for (Plane plane : planes) {
			if (plane instanceof PassengerPlane) {
				passengerPlanes.add((PassengerPlane) plane);
			}
		}
		return passengerPlanes;
	}

	public List<MilitaryPlane> getMilitaryPlanes() {
		List<MilitaryPlane> militaryPlanes = new ArrayList<>();
		for (Plane plane : planes) {
			if (plane instanceof MilitaryPlane) {
				militaryPlanes.add((MilitaryPlane) plane);
			} 
		} 
		return militaryPlanes;
	}

	public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
		List<PassengerPlane> passengerPlanes = getPassengerPlanes();
		PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
		for (int i = 0; i < passengerPlanes.size(); i++) {
			if (passengerPlanes.get(i).getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
				planeWithMaxCapacity = passengerPlanes.get(i);
			}
		}

		return planeWithMaxCapacity;
	}

	public List<MilitaryPlane> getTransportMilitaryPlanes() {
		List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
		List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
		for (int i = 0; i < militaryPlanes.size(); i++) {
			MilitaryPlane plane = militaryPlanes.get(i);
			if (plane.getMilitaryType() == MilitaryType.TRANSPORT) {
				transportMilitaryPlanes.add(plane);
			}
		}
		return transportMilitaryPlanes;
	}

	public List<MilitaryPlane> getBomberMilitaryPlanes() {
		List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
		List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
		for (int i = 0; i < militaryPlanes.size(); i++) {
			MilitaryPlane plane = militaryPlanes.get(i);
			if (plane.getMilitaryType() == MilitaryType.BOMBER) {
				bomberMilitaryPlanes.add(plane);
			}
		}
		return bomberMilitaryPlanes;

	}

	public List<ExperimentalPlane> getExperimentalPlanes() {
		List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
		for (Plane plane : planes) {
			if (plane instanceof ExperimentalPlane) {
				experimentalPlanes.add((ExperimentalPlane) plane);
			}
		}
		return experimentalPlanes;
	}

	public void sortByMaxDistance() {
		Collections.sort(planes, new Comparator<Plane>() {
			public int compare(Plane o1, Plane o2) {
				return o1.getMaxFlightDistance() - o2.getMaxFlightDistance();
			}
		});
	}

	public void sortByMaxSpeed() {
		Collections.sort(planes, new Comparator<Plane>() {
			public int compare(Plane o1, Plane o2) {
				return o1.getMaxSpeed() - o2.getMaxSpeed();
			}
		});
	}

	public void sortByMaxLoadCapacity() {
		Collections.sort(planes, new Comparator<Plane>() {
			public int compare(Plane o1, Plane o2) {
				return o1.getMaxLoadCapacity() - o2.getMaxLoadCapacity();
			}
		});
	}

	public void printPlanes() {
		Iterator<? extends Plane> iterator = planes.iterator();
		while (iterator.hasNext()) {
			Plane plane = iterator.next();
			System.out.println(plane);
		}
	}

	@Override
	public String toString() {
		return "Airport{" + "Planes=" + planes.toString() + '}';
	}

}

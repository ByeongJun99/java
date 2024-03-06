package test09;

public class Cargoplane extends Plane {
	public Cargoplane() {
		super();
	}
	
	public Cargoplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
	}

	public void flight(int distance) {
		System.out.println(distance + " 운항");
		setFuelSize(getFuelSize() - (distance * 5));
	}
}

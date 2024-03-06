package test09;

public class Airplane extends Plane {
	public Airplane() {
		super();
	}
	
	public Airplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
	}
	
	public void flight(int distance) {
		System.out.println(distance + " 운항");
		setFuelSize(getFuelSize() - (distance * 3));
	}
}

package test10;

public class Sales extends Employee implements Bonus {
	public Sales() {
		super();
	}
	
	public Sales(String name, int number, String department, int salary) {
		super(name, number, department, salary);
	}
	
	public double tax() {
		return getSalary() * 0.13;
	}
	
	public void incentive(int pay) {
		setSalary((int) (getSalary() + (pay*1.2)));
	}
}

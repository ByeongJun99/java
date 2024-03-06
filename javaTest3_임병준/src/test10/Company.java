package test10;

public class Company {
	public static void main(String[] args) {
		
		Employee[] employees = new Employee[2];
		
		employees[0] = new Secretary("Hilery", 1, "secretary", 800);
		employees[1] = new Sales("Clinten", 2, "sales", 1200);
		
		System.out.println("name\tdepartment\tsalary");
		System.out.println("------------------------------------");
		for(int i=0; i<employees.length; i++) {
			Employee e = employees[i];
			System.out.println(e.getName() + "\t" + e.getDepartment() + (i==0 ? "\t" : "\t\t") + e.getSalary());
		}
		
		((Secretary) employees[0]).incentive(100);
		((Sales) employees[1]).incentive(100);
		
		System.out.println("name\tdepartment\tsalary\ttax");
		System.out.println("----------------------------------------------");
		for(int i=0; i<employees.length; i++) {
			Employee e = employees[i];
			System.out.println(e.getName() + "\t" + e.getDepartment() + (i==0 ? "\t" : "\t\t") + e.getSalary() + "\t" + e.tax());
		}
		
	}
}

package test06;

public class Calculator {
	public double getSum(int data)  {
		if((data > 5) || data < 2) {
			return 0;
		}
		
		else {
			double sum = 0;
			
			for(int i=1; i<data+1; i++) {
				sum += i;
			}
			
			return sum;			
		}
	}
}

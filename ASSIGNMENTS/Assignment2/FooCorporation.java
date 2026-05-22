package chap2;

// Assignment 2:
// Method to print pay based on base pay and hours worked. 
// Overtime: More than 40 hours, paid 1.5 times 
// base pay 
// Minimum Wage: $8.00/hour 
// Maximum Work: 60 hours a week

public class FooCorporation {
	static double OVERTIME_RATE = 1.5;

	public static double computePay(double basePay, double hoursWorked) {
		double overtimeHours = 0.0;
		double regularHours = hoursWorked;
		
		if (hoursWorked < 0) {
			System.out.println("Please, number of hours worked should be positive.");
			return 0.0;
		}
		else if ((hoursWorked > 40) && (hoursWorked <= 60)) {
			overtimeHours = hoursWorked - 40.0;
		}
		else if (hoursWorked > 60) {
			System.out.println("Please, meet the manager, hours work must be <= 60.");
			return 0.0;
		}
		
		if (basePay < 8.0) {
			System.out.println("Please, the base pay must be at least $8.00/hour.");
			return 0.0;
		}
		
		regularHours -= overtimeHours;
		double pay = (overtimeHours * OVERTIME_RATE * basePay) 
				+ (basePay * regularHours);
		
		return pay;
	}
	
	public static void printPay(double basePay, double hoursWorked) {
		double pay = computePay(basePay, hoursWorked);
		System.out.println(pay);
	}
	
	public static void main(String[] args) {
		// Test case : basePay < 8.0
		double basePay = 7.0;
		double hoursWorked = 35.0;
		printPay(basePay, hoursWorked);
		
		// Test case : hoursWorked > 60
		basePay = 10.0;
		hoursWorked = 70;
		printPay(basePay, hoursWorked);
		
		// Test case : hoursWorked < 0
		basePay = 10.0;
		hoursWorked = -3.5;
		printPay(basePay, hoursWorked);
		
		// Test case : Correct values with no overtime
		basePay = 10.0;
		hoursWorked = 35;
		printPay(basePay, hoursWorked);
		
		// Test case : Correct values with overtime
		basePay = 10.0;
		hoursWorked = 50;
		printPay(basePay, hoursWorked);
	}
}

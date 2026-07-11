package Chap3;

// A group of friends participate in the Boston Marathon.
// Find the best performer.
// Find the second-best performer.
// Data Structures (given) : Array of names and corresponding 
// array of values.

public class Marathon {
	// To solve this exercise, a list of friends
	// and a list of the respective performances
	// are to be created.
	
	public static void main(String[] arguments) {
		// Array storing the names of participants
		String[] participants = {
				"Peter", "Andrew", "Smith", "Donald", "Sophie",
				"Justin", "Mark", "Mike", "Rebecca", "Adalbert"
		};
		
		// Array storing the performance in hours 
		double[] performance = {
				25.4, 29.5, 20.3, 15.2, 27.5, 
				20.2, 23.3, 22.5, 32.1, 20.9
		};
		
		// Use the bubble sort algorithm in order to sort the
		// to sort both arrays at the same time.
		double temp_performance = 0.0;
		String temp_participant = "";
		for (int i = performance.length - 1; i >1 ; i--) {
			for (int j = 0; j < i - 1; j++) {
				if (performance[j + 1] < performance[j]) {
					// Reverse the values at adjacent positions 
					// when the condition applies.
					temp_performance = performance[j];
					performance[j] = performance[j + 1];
					performance[j + 1] = temp_performance;
					
					temp_participant = participants[j];
					participants[j] = participants[j + 1];
					participants[j + 1] = temp_participant;
				}	
			}
		}  // End of bubble sort algorithm (both arrays are sorted).
		
		
		// From the sorted arrays, extract the best performance (and participant)
		// and the second best performance (participant), positions 0 and 1. 
		// Then print the results.
		System.out.println("Best participant : " + participants[0] 
				+ " ; Best time : " + performance[0]);
		System.out.println("Second best participant : " + participants[1] 
				+ " ; Second best time : " + performance[1]);
	}
}

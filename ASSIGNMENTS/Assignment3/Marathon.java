package Chap3;
import java.util.Arrays;

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
		
		// Performance in hours 
		double[] performance = {
				25.4, 29.5, 20.3, 15.2, 27.5, 
				20.2, 23.3, 22.5, 32.1, 20.9
		};
		
		// Construct a deep copy of the performance vector and
		// sort the copy.
		double[] performanceCopy = performance.clone();
		Arrays.sort(performanceCopy);
		
		double bestPerformance = performanceCopy[0];
		double secondBestPerformance = performanceCopy[1];
		String bestParticipant = "";
		String secondBestParticipant = "";
		
		for (int i = 0; i < performance.length; i++) {
			if (performance[i] == bestPerformance) {
				bestParticipant = participants[i];
			}
			if (performance[i] == secondBestPerformance) {
				secondBestParticipant = participants[i];
			}
		}
		
		System.out.println("Best participant : " + bestParticipant 
				+ " ; Best time : " + bestPerformance);
		System.out.println("Second best participant : " + secondBestParticipant 
				+ " ; Second best time : " + secondBestPerformance);
	}
}

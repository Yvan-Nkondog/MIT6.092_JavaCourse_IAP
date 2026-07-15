package Empty_assignments;

class Marathon {
    public static void main (String[] arguments) {
    	String[] participants = {
				"Peter", "Andrew", "Smith", "Donald", "Sophie",
				"Justin", "Mark", "Mike", "Rebecca", "Adalbert"
		};
		
		// Array storing the performance in hours 
		double[] performance = {
				25.4, 29.5, 20.3, 15.2, 27.5, 
				20.2, 23.3, 22.5, 32.1, 20.9
		};

        for (int i = 0; i < participants.length; i++) {
            System.out.println(participants[i] + ": " + performance[i]);
        }
    }
} 

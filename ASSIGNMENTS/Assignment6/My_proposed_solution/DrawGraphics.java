package Chap6;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class DrawGraphics {
	// Interface to 
	ArrayList<Mover> movers;

    /** Initializes this class for drawing. */
    public DrawGraphics() {
    	// Initialize the array of "bouncers" and "straightMovers".
    	movers = new ArrayList<Mover>();
    	
    	// Create / draw the shapes.
        Rectangle box1 = new Rectangle(15, 20, Color.RED);
        Rectangle box2 = new Rectangle(22, 30, Color.BLUE);
        Oval oval1 = new Oval(32, 100, Color.GREEN);
        Oval oval2 = new Oval(10, 20, Color.YELLOW);
        
        // Adjust the parameters for the bouncer objects.
        movers.add(new Bouncer(100, 170, box1));
        movers.get(0).setMovementVector(3, 1);
        movers.add(new Bouncer(250, 50, oval1));
        movers.get(1).setMovementVector(-1, 2);
        
        // Adjust the parameters for the straightMover objects.
        movers.add(new StraightMover(145, 145, box2));
        movers.get(2).setMovementVector(2, 2);
        movers.add(new StraightMover(75, 250, oval2));
        movers.get(3).setMovementVector(5, -2);
        
    }

    /** Draw the contents of the window on surface. */
    public void draw(Graphics surface) {
        for (Mover mover : movers) {
        	mover.draw(surface);
        }
    }
    
}

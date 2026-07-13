package Chap5;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class DrawGraphics {
    ArrayList<BouncingBox> bouncingBoxes;
    ArrayList<Color> colors;
    ArrayList<Point> startCoordinates;
    int nPoints = 4;
    
    /** Initializes this class for drawing. */
    public DrawGraphics() {
    	// Initialize and the four colors for the four points.
    	colors = new ArrayList<>(List.of(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW));
    	
    	// Initialize the initial coordinates.
    	startCoordinates = new ArrayList<Point>();
    	for (int i = 0; i < nPoints; i++) {
    		// Based on the initial "point" value given, set 
    		// arbitrary coordinates that fall on the same line.
    		startCoordinates.add(new Point(200 - 50*i, 50*(i+1)));
    	}
    	
    	// Initialize the bouncing boxes based on the initial
    	// coordinates and on the colors.
    	bouncingBoxes = new ArrayList<BouncingBox>();
    	for (int i = 0; i < nPoints; i++) {
    		bouncingBoxes.add(new BouncingBox(startCoordinates.get(i).getX(),
    				startCoordinates.get(i).getY(), colors.get(i)));
    	}
    	
    	// Set the animation parameters. Boxes speed increases as their
    	// position index inside the 'ArrayList' increases.
    	for (int i = 0; i < nPoints; i++) {
    		bouncingBoxes.get(i).setMovementVector(3*i, -1);
    	}
    }

    /** Draw the contents of the window on surface. Called 20 times per second. */
    public void draw(Graphics surface) {
        surface.drawLine(50, 50, 250, 250);
		for (int i = 0; i < nPoints; i++) {
			bouncingBoxes.get(i).draw(surface);
		}
    }
    
} 

package Chap6;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Oval implements Sprite {
	private int width;
	private int height;
	private Color color;

	public Oval(int width, int height, Color color) {
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	@Override
	public void draw(Graphics surface, int leftX, int topY) {
		// Set the color to fill the oval figure.
		surface.setColor(this.color);
		surface.fillOval(leftX,  topY,  this.width, this.height);
		// Set the color to fill the surrounding line.
		surface.setColor(Color.BLUE);
		// Add a line surrounding the entire oval figure (circumference).
		((Graphics2D) surface).setStroke(new BasicStroke(5.0f));
		surface.drawOval(leftX, topY, width, height);
	}

	@Override
	public int getWidth() {
		return this.width;
	}

	@Override
	public int getHeight() {
		return this.height;
	}
	
}

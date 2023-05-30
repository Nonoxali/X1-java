package typo;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;

public class Glyph extends Box {
	final private static FontRenderContext frc = new FontRenderContext(null, false, false);
	
	final private Font font;
	final private char[] chars;
	final private Rectangle2D bounds;

	// classe à compléter (question 2)
	
	public Glyph(java.awt.Font font, char c) {
		this.font = font;		
		this.chars = new char[1];
		this.chars[0] = c;
		
		TextLayout layout = new TextLayout("" + chars[0], font, frc);
		this.bounds = layout.getBounds();
	}

	public double getStretchingCapacity() {
		return 0;
	}

	public double getWidth() {
		return bounds.getWidth();
	}

	public double getAscent() {
		return - bounds.getY();
	}

	public double getDescent() {
		return bounds.getHeight() + bounds.getY(); 
	}

	public boolean doDraw(Graphics graph, double x, double y, double w) {
		graph.setFont(font);
		int coordx =  (int) (x-bounds.getX());
		int coordy =  (int) (y-bounds.getY());
		
		graph.drawChars(chars, 0, 1, coordx, coordy);
		
		return true;
	}
	
	public String toString() {
		
		return String.format("Glyph(%s)" + super.toString(), chars[0] );
	}
}
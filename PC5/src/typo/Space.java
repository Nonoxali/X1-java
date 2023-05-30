package typo;

import java.awt.Graphics;

public class Space {
	
	final private double width;
	final private double stretchingCapacity;
	
	Space(double w, double stretch){
		this.width = w;
		this.stretchingCapacity = stretch;
	}
	
	public boolean doDraw(Graphics graph, double x, double y, double w) {		
		return true;
	}
	
	public double getAscent() {
		return 0;
	}

	public double getDescent() {
		return 0; 
	}
	
	public String toString() {
			
			return String.format("Space" + super.toString() );
		}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

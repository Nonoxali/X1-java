package typo;

import java.awt.Graphics;

public class Vbox extends Group {
	double lineskip;
	
	public Vbox(double lineskip) {
		this.lineskip = lineskip;
	}
	
	public void add(Box b) {
		ascent += descent + b.getAscent()+lineskip;
		if(b.getWidth() > this.getWidth()) this.width= b.getWidth();
		if(b.getStretchingCapacity() > this.getStretchingCapacity()) this.stretch= b.getStretchingCapacity();
		this.descent = b.getDescent();
		super.add(b);
	}
	public String toString() {
		return "Vbox"+super.toString();
	}
	
	public boolean doDraw(Graphics graph, double x, double y, double w) {
		double saute = 0;
		for(Box b:list) {
			b.doDraw(graph, x, y+ saute, w);
			saute += lineskip + b.getAscent() + b.getDescent();
		}
		return true;
	}
}

package typo;

import java.awt.Graphics;

public class Hbox extends Group {
	
	public void add(Box b) {
		this.width+= b.getWidth();
		this.stretch+= b.getStretchingCapacity();
		if(b.getAscent() > this.getAscent()) ascent= b.getAscent();
		if(b.getDescent() > this.getDescent()) this.descent= b.getDescent();
		super.add(b);
	}
	public String toString() {
		return "Hbox"+super.toString();
	}
	
	public boolean doDraw(Graphics graph, double x, double y, double w) {
		double mw = this.getWidth();
		double cursor = 0;
		if(mw > w) {
			for(Box b:list) {
				b.doDraw(graph, x+cursor, y-ascent-b.getAscent(), b.getWidth());
				cursor += b.getWidth();
				}
			return false;
		}
		else {
			double diff = w-mw;
			for(Box b:list) {
				b.doDraw(graph, x+cursor, y +this.ascent - b.getAscent() , w*b.getWidth()/mw);
				cursor += b.getWidth();
				if( stretch >0) cursor +=b.getStretchingCapacity()*diff/stretch;
			}
			return true;
		}
	}
}

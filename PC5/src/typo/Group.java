package typo;
import java.util.LinkedList;


public abstract class Group extends Box {
double width;
double ascent;
double descent;
double stretch;

protected final LinkedList<Box> list = new LinkedList<Box>();

public  double getWidth() {
	return this.width;
}
	
public  double getAscent() {
	return this.ascent;
}
	
public  double getDescent() {
	return this.descent;
}
	
public  double getStretchingCapacity() {
	return this.stretch;
}
 @Override
public String toString() {
	String o = new String("");
	o+= super.toString()+"{\n";
	for(Box b: list) {
		o+= "	"+b.toString()+",\n";
	}
	o+="}";
return o;
}



public void add(Box b) {
	list.add(b);
}

}

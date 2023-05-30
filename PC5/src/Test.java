import typo.Glyph;

import java.awt.Font;

public class Test {
	
	static void test2() {
		  Font f = new Font("SansSerif", Font.PLAIN, 70);
		  Glyph g = new Glyph(f, 'g');
		  System.out.println(g);
		}
	
	static void test3() {
	    Font f = new Font("SansSerif", Font.PLAIN, 70);
	    Glyph g = new Glyph(f, 'g');
	    System.out.println(g);
	    new Page(g, 150, 150);
	}
	
	static void test5() {
	    Font f = new Font("SansSerif", Font.PLAIN, 70);
	    Space s = new Space(f, 'g');
	    FixedSpace s2 = new FixedSpace(f, 'g');
	    RelativeSpace s3 = new RelativeSpace(f, 'g');
	    System.out.println(s);
	    System.out.println(s2);
	    System.out.println(s3);
	}
	
	public static void main(String[] args) {
	test2();

	}

}

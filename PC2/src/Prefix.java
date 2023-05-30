
public class Prefix {
	String[] t;
	
	final static String start = "<START>", end="<END>", par="<PAR>";
	
	Prefix(int n){
		t= new String[n];
		for(int i= 0;i<t.length;i++) {
			t[i]=start;
		}
	}
	
	static boolean eq(Prefix p1, Prefix p2) {
		if(p1.t == p2.t) {
			return true;
		}
		
		if(p1.t == null || p2.t ==null) {
			return false;
		}
		
		if(p1.t.length != p2.t.length) {
			return false;
		}
		
		for(int i=0; i<p1.t.length;i++) {
			if(!p1.t[i].equals(p2.t[i])) {
				return false;
			}
		}
		return true;
	}
	
	Prefix addShift(String w) {
		Prefix p2 = new Prefix(this.t.length);
		int size = p2.t.length;
		for(int i=0;i<size-1;i++) {
			p2.t[i]=this.t[i+1];
		}
		p2.t[size-1]=w;
		return p2;
	}
	
	public int hashCod() {
		int h =0;
		if(t==null) return h;
		for(int i=0 ; i<t.length ;i++) {
			h = 37*h + t[i].hashCode();			
		}
		
		return h;
		
	}
	
	int hashCode(int n) {
		int r = this.hashCod()%n;
		while(r<0) {
			r+=n;
		}
		return r;
	}
	
	public static void main(String[] args) {
		}
	
}

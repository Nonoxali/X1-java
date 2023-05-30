
public class Percolation {
	
	static final int size = 10;
	static final int length = size * size;
	static boolean[] grid = new boolean[length];
	
	public static void init() {
		UnionFind.init(length +2);
		for (int i =0; i<size; i++) 
		{
			for (int j =0; j<size; j++) 
			{
				grid[size*i + j]=false;
			}
		}
	}
	
	public static void print()
	{
		for (int i =0; i<size; i++)
		{
			for (int j =0; j<size; j++) 
			{
				if(grid[size*i + j] ==true)
					{
					System.out.print("*");
					}
				else
				{
					System.out.print("-");
				}
			}
			System.out.println();
		}
	}
	
	public static void propagateUnion(int x) {
		if( x<length -size && grid[x+size]) UnionFind.union(x,x+size);
		if( x>=size && grid[x-size]) UnionFind.union(x,x-size);
		if( x%size!=0 && grid[x-1]) UnionFind.union(x,x-1);
		if( (x+1)%(size)!=0 && grid[x+1]) UnionFind.union(x,x+1);
		if(x<size) UnionFind.union(x,length);
		if(x>=(length-size)) UnionFind.union(x, length+1);
	}
	
	public static int randomShadow() {
		double random =length*Math.random();
		int k = (int) random ;
		while(grid[k]) {
			random =length*Math.random();
			k = (int) random ;
		}
		grid[k] = true;
		propagateUnion(k);
		return k;
	}
	
	public static boolean detectPath(boolean[] seen, int n, boolean up) {
		
		if(up && n<size) {
			return true;
		}
		if(!up && n>=length-size) {
			return true;
		}
		
		seen[n]=true;
		
		if((n+1)%(size) != 0 && !seen[n+1] && grid[n+1] ) {
			if(detectPath(seen, n+1, up)) {
				return true;
			}
		}
		
		if(n%(size) != 0 && !seen[n-1] && grid[n-1] ) {
			if(detectPath(seen, n-1, up)) {
				return true;
			}
		}
		
		if( !up && !seen[n+size] && grid[n+size]) {
			if(detectPath(seen, n+size, up)) {
				return true;		
			}
		}
		
		if( up && !seen[n-size] && grid[n-size]) {
			if(detectPath(seen, n-size, up)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean isNaivePercolation(int n) {
		boolean[] seen1 = new boolean[length];
		boolean[] seen2 = new boolean[length];
				
		if(detectPath(seen1,n,true) && detectPath(seen2,n,false)){
			return true;
		}
		else {
			return false;
		}
	
	}
	public static boolean isFastPercolation(int n) {
		int eq = UnionFind.find(n);
		for(int i=0;i<size;i++) {
			if(UnionFind.find(i)==eq) {
				for(int j=length-size;j<length;j++) {
					if(UnionFind.find(j)==eq) return true;
				}
			}
		}
	return false;
	}
	
	public static boolean isLogPercolation() {
		return(UnionFind.find(length) == UnionFind.find(length+1));
	}
		
	
	public static boolean isPercolation(int n) {
		return isFastPercolation(n);
	}
	
	public static double percolation() {
		int i =randomShadow();
		int compteur = 1; 
		while(!isPercolation(i)){
			i=randomShadow();
			compteur+=1;
		}
		return (double)compteur/(double)length;	
	}
	
	public static double monteCarlo(int n) {
		double sum = 0.0;
		for(int i=0;i<n;i++) {
			init();
			sum+=percolation();
		}
		return sum/n;
	}
	

	
	public static void main(String[] args) {
		//int n= Integer.parseInt(args[0]);
		double t0= System.currentTimeMillis();
		System.out.println(monteCarlo(Integer.parseInt(args[0])));
		//double t1 = System.currentTimeMillis();
		System.out.println(((System.currentTimeMillis()-t0)/Integer.parseInt(args[0])));
	}

		
}

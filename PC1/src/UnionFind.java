public class UnionFind {
	
	static int[] equiv;
	static int[] height;
	
	public static void init(int len) {
	equiv = new int[len];
	height = new int[len];
	for(int i=0; i<len;i++) {
		equiv[i]=i;	
		height[i]=1;
	}
		
	}
	
	public static int naiveFind(int x) {
		return equiv[x];		
	}
	
	public static int naiveUnion(int x, int y) {
		int rep = find(x);
		for(int i =0; i<equiv.length;i++) {
			if(find(i)==rep) {
				equiv[i]=find(y);
			}
		}
		return find(y);
	}
	
	public static int fastFind(int x) {
		int rep = equiv[x];
		while(rep != equiv[rep]) {
			rep = equiv[rep];
		}
		return rep;
	}
	
	public static int fastUnion(int x, int y) {
		int resp=find(x);
		equiv[resp]= find(y);
		return y;
	}
	
	public static int logUnion(int x, int y) {
		int respx = find(x);
		int respy = find(y);
		if(height[respx]>height[respy]) {	
			equiv[respy]= respx;
			return respx;
		}
		else if(height[respx]==height[respy]) {
			equiv[respx]= respy;
			height[respy]+=1;
			return respy;
		}
		else{	
			equiv[respx]= respy;
			return respy;
		}	
	}
	
	public static int logFind(int x) {
		int k =x;
		int q;
		while(k != equiv[k]) {
			q = k;
			k = equiv[k];
			equiv[q]=equiv[equiv[q]];
		}
		return k;		
	}
	
	public static int find(int x) {
		return fastFind(x);
		
	}

	public static int union(int x, int y) {
		return fastUnion(x,y); 	
	}
	
	public static void main(String[] args) {
	/*	init(10);
		System.out.println(union(0,3));
		System.out.println(Arrays.toString(equiv));
		System.out.println(union(8,4));
		System.out.println(Arrays.toString(equiv));
		System.out.println(union(0,5));
		System.out.println(Arrays.toString(equiv));
		System.out.println(union(5,8));
		System.out.println(Arrays.toString(equiv));
		System.out.println(union(9,3));
		System.out.println(Arrays.toString(equiv));
		System.out.println(find(3));
		System.out.println(find(0));
		System.out.println(find(0)==find(3));*/
		}

}

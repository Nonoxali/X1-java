
public class HMap {
	
	EntryList[] t;
	int nbEntries;
	
	HMap(int n ){
		nbEntries = 0;
		t = new EntryList[n];
	}
	
	HMap(){
		nbEntries = 0;
		t = new EntryList[20];
	}
	
	WordList find(Prefix key) {
		if(this.nbEntries==0) return null;
		int h=key.hashCode(this.t.length);
		for(EntryList cur = t[h];cur!=null;cur=cur.next) {
			if(Prefix.eq(cur.head.key,key)) return cur.head.value;
		}
		return null;
	}
	
	void addSimple(Prefix key, String w) {
		int h=key.hashCode(this.t.length);
		if(this.t[h]==null) {
			Node added_node = new Node(w,null);
			Entry newentry = new Entry(key,new WordList(added_node));
			t[h] = new EntryList(newentry,null);
			nbEntries++;
		}
		else {
				if(Prefix.eq(key,this.t[h].head.key)) {
					this.t[h].head.value.addLast(w);
				}
				else {
					int indicator = 0;
					EntryList rebuilt = new EntryList(t[h].head,null);
					t[h]= t[h].next;
					while(t[h]!=null) {
						rebuilt = new EntryList(t[h].head,rebuilt);     //switch line ? 
						if(Prefix.eq(t[h].head.key,key)){
							t[h].head.value.addLast(w);
							indicator++;
							}
						t[h] = t[h].next;
					}
					if(indicator==0) {
						Node added_node = new Node(w,null);
						Entry newentry = new Entry(key,new WordList(added_node));
						rebuilt = new EntryList(newentry,rebuilt);
						nbEntries++;
						}
					while(rebuilt!=null) {
						t[h] = new EntryList(rebuilt.head,t[h]);
						rebuilt=rebuilt.next;
				}
			}
		}
	}	
	void rehash(int n) {
		HMap bigger = new HMap(n);
		for (int i = 0; i < t.length; i ++) {
			while(t[i] != null) {
				int h = t[i].head.key.hashCode(n);
				bigger.t[h] = new EntryList(t[i].head, bigger.t[h]);
				bigger.nbEntries += 1;
				t[i] = t[i].next;
			}
		}
		t = bigger.t;
		nbEntries = bigger.nbEntries;
	}
	
	void add(Prefix key, String w) {
		float a= nbEntries;
		float b= this.t.length;
		float load = a/b;
		if(load>=0.75) {
			this.rehash(this.t.length*2);
			this.addSimple(key, w);
		}
		else {this.addSimple(key, w);}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

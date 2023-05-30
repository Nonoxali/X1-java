public class Bovary {

	static HMap buildTable(String[] files, int n) {
		HMap hash = new HMap();
		for(int i =0; i<files.length;i++) {
			Prefix key = new Prefix(n);
			WordReader list = new WordReader(files[i]);
			String word = list.read();
			while(word!=null) {
				hash.add(key, word);
				key = key.addShift(word);
				word= list.read();
			}
			hash.add(key, Prefix.end);
		}
		return hash;
	}
	
	static void generate(HMap t, int n) {
		Prefix key = new Prefix(n);
		WordList list = t.find(key);
		//random word choose
		int i = (int) Math.random()*list.length();
		Node cur = list.content;
		for(int j =0;j<i;j++) {
			cur=cur.next;
		}
		String word= cur.head;

		WordList rebuilt = new WordList(new Node(word,null)); 
		System.out.print(word+" ");
		while(word!=Prefix.end) {
			key = key.addShift(word); //shift key with word
			list = t.find(key);  //find new element assigned to key
			//random word choose in loop
			i = (int) (Math.random()*list.length());
			cur = list.content;     //new node to loop throug
			
			for(int j =0;j<i;j++) {
				rebuilt.addLast(cur.head);
				cur=cur.next;
			}
			word= cur.head;   // new word randomly chosen in new list
			
			while(rebuilt.content!=null) {
				list = new WordList(new Node(rebuilt.content.head,list.content));
				rebuilt.content=rebuilt.content.next;
			}
			if(word.equals("<PAR>") || word.equals("<END>")) System.out.println();
			else System.out.print(word+" ");			
	}
	}
	

		
	/*int indicator = 0;
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
	*/
		
	public static void main(String[] args) {
		String[] a = args;
		HMap Map = buildTable(a,3);
		generate(Map,3);
	}

}

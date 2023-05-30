
public class WordList {
	Node content;

	// CONTRUCTEURS 
	
	WordList() {content = null;	}

	WordList(Node n) { content = n;	}
	
	WordList(String[] s){
		if(s.length==0) content = null;
		if(s.length==1) content = new Node(s[0],null);
		else {
			content = new Node(s[0],null);
			Node cur = content.next;
			for(int i =1; (i+1)<s.length; i++) {
				cur = new Node(s[i],new Node(s[i+1],null));
				cur = cur.next;
		}
	
		}
	}

	static WordList foobar = new WordList(Node.foobar);

	// METHODES 
	
	int length() { return Node.length(content);}

	public String toString() {
		return Node.makeString(content);
	}
	
	void addFirst(String w) {
		content = new Node(w,content);
	}
	
	void addLast(String w) {
		if(content ==null) content = new Node(w,null);
		else {
			Node.addLast(w, content);
		}
	}
	
	String removeFirst() {
		if(content == null  ) return null;
		if(content.next==null) {
			String w = content.head;
			content = null;
			return w;
		}
		else {
			String w = content.head;
			content = new Node(content.next.head,content.next.next);
			return w;
		}
	}
	
	String removeLast() {
		if(content == null) return null;
		if(content.next==null) {
			String w = content.head;
			content = null;
			return w;
		}
		else{
			Node cur = content;
			while(cur.next.next != null) {
				cur = cur.next;
			}
			String w = cur.next.head;
			cur.next = null;
			return w;
		}
	}
	
	void insert(String s) {
		content = Node.insert(s,content);
	}
	
	void insertionSort() {
		content = Node.insertionSort(content);
	}
	
	//void mergeSort()

	
	public static void main(String[] args) {
		String[] o = new String[] {"hello","hi","whqt"};
		WordList hi = new WordList(o);
		System.out.println(hi);
	}

}

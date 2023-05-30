
public class Node {
	String head;
	Node next;
	
	Node(String head, Node next){
		this.head = head;
		this.next = next;
	}
	
	static Node foobar = new Node("foo", new Node("bar", new Node("baz", null)));
	static Node foobars = new Node("bar", new Node("baz", new Node("foo", null)));
	
	public static int lengthRec(Node l) {
		if(l == null) return 0;
		return lengthRec(l.next)+ 1;
	}
	
	public static int length(Node l) {
		int c=0;
		if(l==null) return 0;
		for(Node cur =l; cur!= null; cur=cur.next) {
			c+=1;
		}
		return c;
	}
	
	public static String makeString(Node l) {
		if(l==null) return "[]";
		String word="["+l.head;
		for(Node cur=l.next; cur!=null; cur=cur.next) {
			word+=", "+ cur.head;
		}
		word+="]";
		return word;
	}
	
	public static void addLast(String s, Node l) {
		if(l==null) l = new Node(s,null);
		else {
			Node cur = l;
			while(cur.next!=null){
				cur=cur.next;
			}
			cur.next= new Node(s,null);
			}
		}
	
	public static Node copy(Node the) {
		if(the==null) return null;
		Node n2 = new Node(the.head,null);
		for(Node cur=the; cur.next!=null; cur=cur.next) {
			addLast(cur.next.head,n2); 
		}
		return n2;
	}
	
	public static Node insert(String s, Node l) {
		if(l==null) return new Node(s,null);
		else if(s.compareTo(l.head)<=0) {
			Node tempnode = new Node(l.head,l.next);
			l.head = s;
			l.next = tempnode;
			return l;
		}
		return new Node(l.head,insert(s,l.next));
	}
	
	
	public static Node insertionSort(Node l) {
		if(l==null) return null;
		else {
			Node sorted = new Node(l.head,null);
			for(Node cur=l; cur.next!=null; cur=cur.next) {
				sorted = insert(cur.next.head,sorted);
			}
			return sorted;
		}
	}
	
	static Node merge(Node l1, Node l2) {
		if(l1 ==null && l2==null) return null;
		if(l2 ==null) return l1;
		if(l1 ==null) return l2;
		else {
			Node cur = l1;
			while(cur.next!=null){
				cur=cur.next;
			}
			cur.next= l2;
			Node merged = insertionSort(l1);
			return merged;
		}
	}
	
	public static void main(String[] args) {
	}

}

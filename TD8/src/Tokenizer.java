
public class Tokenizer {

	//CONSTRUCTEUR 
	
	public boolean isStart; 
	public boolean isIntNum;
	public double num;
	public Calculator calc;
	
	public Tokenizer() {
		this.isStart = true;
		this.isIntNum = false;
		this.num = 0;
		this.calc = new Calculator();
	}
	
	//METHODES 
	
	public void readChar(char c) {
		switch(c){
		   
	       case '=': 
	    	   isStart = true;
				calc.pushDouble(num);
				this.num = 0;
				calc.commandEqual();
	           break;
	   
	       case '+':
	    	   calc.pushDouble(num);
	    	   calc.commandOperator(Operator.PLUS);
	    	   this.num = 0;
	    	   isStart = false;
	    	   isIntNum = false;
	           break;
	   
	       case '-':
	    	   calc.pushDouble(num);
	    	   calc.commandOperator(Operator.MINUS);
	    	   this.num = 0;
	    	   isStart = false;
	    	   isIntNum = false;
	           break;
	       
	       case '*':
	    	   calc.pushDouble(num);
	    	   calc.commandOperator(Operator.MULT);
	    	   this.num = 0;
	    	   isStart = false;
	    	   isIntNum = false;
	           break;
	           
	       case '/':
	    	   calc.pushDouble(num);
	    	   calc.commandOperator(Operator.DIV);
	    	   this.num = 0;
	    	   isStart = false;
	    	   isIntNum = false;
	           break;
	           
	       case '(':
	    	   //calc.pushDouble(num);
	    	   calc.commandLPar();
	    	   //this.num = 0;
	    	   isStart = false;
	    	   isIntNum = false;
	           break;
	        
	       case ')':
	    	  // calc.pushDouble(num);
	    	   calc.commandRPar();
	    	   //this.num = 0;
	    	   isStart = false;
	    	   isIntNum = false;
	           break; 
	           
	       default:
	    	   isStart = false;
	    	   isIntNum = true;
	    	   //i= (int) Math.log10(num) ;
	    	   //System.out.println("i="+i);
	    	   num = 10*num + Character.getNumericValue(c);			
		}		
	}
	
	void readString(String s) {
		char c;
		for(int i=0; i<s.length();i++) {
			c= s.charAt(i);
			readChar(c);
		}
	}
	
	
	
	public static void main(String[] args) {
		Tokenizer tk = new Tokenizer();
	    tk.readChar('(');
	    System.out.println(tk.num);
	    tk.readChar('(');
	    System.out.println(tk.num);
	    System.out.println(tk.calc.toString());
		// TODO Auto-generated method stub

	}

}

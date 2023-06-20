
public class Tokenizer {

	//CONSTRUCTEUR 
	
	public boolean isStart; 
	public boolean isIntNum;
	public double num;
	public Calculator calc;
	public boolean isNonIntNum;
	int decimalDigits;
	boolean isMinUnary;
	boolean isNeg;
	
	public Tokenizer() {
		this.isStart = true; // vrai ssi tout debut ou apres =
		this.isIntNum = false;//vrai ssi lire entier
		this.isNonIntNum = false; //
		this.decimalDigits = 0;
		this.num = 0;
		this.calc = new Calculator();
		this.isMinUnary = true;
		this.isNeg = false;
	}
	
	//METHODES 
	
	public void readChar(char c) {
		if(Character.isDigit(c)) {
			isStart = false;
			if(num == 0 && c !='.' && !isNonIntNum) {
				isIntNum = true;
			}
			int val = isNeg? 1 : 0;
	    	   if(isIntNum) {
	    		   num = 10*num + Character.getNumericValue(c)*Math.pow(-1,val);		    		   
	    	   }
	    	   else if(isNonIntNum) {
	    		   num = num + Character.getNumericValue(c)/Math.pow(10, decimalDigits)*Math.pow(-1,val);
	    		   decimalDigits++;
	    	   }
	    	   
		}
		else  {
			if(isIntNum && c!='.') {
				calc.pushDouble(num);
				isIntNum = false;
				isMinUnary = false;
				isNeg = false;
			}
			if(isNonIntNum && c!='.') {
				calc.pushDouble(num);
				isNonIntNum = false;
				decimalDigits = 0;
				isMinUnary = false;
				isNeg = false;
			}
			isStart = false;
		switch(c){	
		
		   
	       case '=': 
	    	   isMinUnary = true;
	    	   isStart = true;
				this.num = 0;
				calc.commandEqual();
				System.out.println();
				isMinUnary = true;
	           break;
	           
	       case 'C': 
	    	   this.calc = new Calculator();
	    	   this.isStart = true; // vrai ssi tout debut ou apres =
	   		this.isIntNum = false;//vrai ssi lire entier
	   		this.isNonIntNum = false; //
	   		this.decimalDigits = 0;
	   		this.num = 0;
	   		this.calc = new Calculator();
	   		this.isMinUnary = true;
	   		this.isNeg = false;
	           break;
	           
	       case '.' :
	    	   isIntNum = false;
	    	   isNonIntNum = true;
	    	   this.decimalDigits++;
	    	   isMinUnary = false;
	    	   break;
	   
	       case '+':
	    	   isMinUnary = true;
	    	   calc.commandOperator(Operator.PLUS);
	    	   this.num = 0;
	           break;
	   
	       case '-':
	    	   if(isMinUnary) isNeg = true;
	    	   else { 
	    		calc.commandOperator(Operator.MINUS);
	    	   this.num = 0;
	    	   isMinUnary = true;
				}
	           break;
	       
	       case '*':
	    	   isMinUnary = true;
				isNeg = false;
	    	   calc.commandOperator(Operator.MULT);
	    	   this.num = 0;
	    	   
	           break;
	           
	       case '/':
	    	   isMinUnary = true;
	    	   calc.commandOperator(Operator.DIV);
	    	   this.num = 0;
	           break;
	           
	   	case '(' :
	   		isMinUnary = true;
	    	   calc.commandLPar();
	    	   isMinUnary = true;
	    	   break;
	        
	       case ')':
	    	   calc.commandRPar();
	    	   isMinUnary = false;
	           break; 
	           
	       default:
	    	}
		
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

	    	}

}

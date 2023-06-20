import java.util.Stack;

public class Calculator {
	//CONSTRUCTEUR 
	
	public Stack<Double> numbers;
	public Stack<Operator> operators;
 	public java.util.LinkedList<Double> results;
 	
	Calculator(){
		numbers = new Stack<Double>();
		operators = new Stack<Operator>();
		results = new java.util.LinkedList<Double>();
	}
	
	//METHODES 
	
	@Override
	public String toString() {
		String s = new String("Numbers : \n");
		s+=numbers.toString();
		s+= "\nOperators : \n";
		s+=operators.toString();
		s+= "\nResults : \n";
		s+=results.toString();
		return s;
	}
	
	void pushDouble(double d) {
		numbers.add(d);
	}
	
	void pushOperator(Operator o) {
		operators.add(o);
	}
	
	public double getResult() {
		return results.get(results.size()-1);
	}
	
	void executeBinOperator( Operator op ) {
		double a = numbers.pop();
		double b = numbers.pop();
		
		
		switch(op){
		   
	       case PLUS: 
	           numbers.add(a+b);
	           break;
	   
	       case MINUS:
	    	   numbers.add(b-a);
	           break;
	   
	       case MULT:
	    	   numbers.add(a*b);
	           break;
	           
	       case DIV:
	    	   if ( a==0) {
	   			throw new RuntimeException( "Cannot divide by 0" );
	   			}
	    	   numbers.add(b/a);
	           break;
	       default:
	    	   
		}
	}
	
	private int precedence(Operator op) {
		switch(op){
		   
	       case PLUS: 
	           return 1;
	   
	       case MINUS:
	    	  return 1;
	   
	       case MULT:
	    	  return 2;
	           
	       case DIV:
	    	   return 2;
	    	   
	       case OPEN:
	    	   return -1;
	    	   
	       default:
				return 0;
		}
		
	}
	
	void commandOperator(Operator op) {
		while(!(operators.isEmpty())) {
			Operator x = operators.pop();
			if(precedence(op)<=precedence(x)) {
				executeBinOperator(x);
			}
			else {
				pushOperator(x);
				break;
			}
		}
		pushOperator(op);
	}
	
	void commandDouble(Double d) {
	numbers.add(d);		
	}
	
	void commandEqual() {
		while(!operators.isEmpty()) {
			executeBinOperator(operators.pop());
		}
		results.add(numbers.pop());
	}
	
	void commandLPar() {
		pushOperator(Operator.OPEN);
	}
	
	void commandRPar() {
		while(operators.peek()!= Operator.OPEN) {
			if(operators.isEmpty()) {
				throw new RuntimeException( "Bad parentheses" );
   			}
			executeBinOperator(operators.pop());
			}
		operators.pop();
		}
	
	void commandInit() {
		numbers.clear();
		operators.clear();
	}
	
	void commandReadMemory(int i) {
		numbers.add(results.get(results.size()-i));
	}
	public static void main(String[] args) {

	}

}

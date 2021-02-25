package Master_DS_Algo;

import java.util.Stack;

//Without Paranthesis PostFixExpressionEvaluation
public class PostFixExpEvaluation {
	
	//Sample static immutable string for testing
	String exp = "36+2*4-";
	public static Stack<Integer> stack = new Stack<>();
	
	//Method to return the result of a operator between two operands
	//Since all the operator are binary
	public static int calInterResVal(int one, int two, char op) {
		
		if (op == '*')
			return one * two;
		if (op== '/')
			return one/two;
		if (op == '+')
			return one + two;
		if (op == '-')
			return one - two;
		return 0;
	}
		
	//Method to evaluate a string expression with single digit values with +-*/ operators
	//This method returns the result of the postfix expression
	public static int evaluateStringExpression(String exp) {
		
		for (int i =0;i<exp.length();i++) {
			
			//If any digit is encountered directly pushing it into the stack
			if( Character.isDigit( exp.charAt(i) ) )
				PostFixExpEvaluation.stack.push(Character.getNumericValue(exp.charAt(i)));
			else
				//In case of any operand encounter since all the operands are binary 
				//Doing 2 pops and evaluating and pushing the result back to stack
				if(!PostFixExpEvaluation.stack.isEmpty()) {
					int one = PostFixExpEvaluation.stack.pop();
					int two = PostFixExpEvaluation.stack.pop();
					
					PostFixExpEvaluation.stack.push(calInterResVal(one,two,exp.charAt(i)));
				}
				
				
		}
		
		//Finally the stack will be available with the result
		return PostFixExpEvaluation.stack.pop();
	}

	public static void main(String[] args) {
		PostFixExpEvaluation pfee = new PostFixExpEvaluation();
		
		
		System.out.println("Ressult of expression "+ pfee.exp + " is " +evaluateStringExpression(pfee.exp));
		

	}

}
